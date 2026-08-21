package com.punith.app.config;



import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.punith.app.service.CustomUserDetailsService;
import com.punith.app.utils.JwtRequestFilter;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;


@Configuration
@EnableMethodSecurity(prePostEnabled = true) 
//@PreAuthorize on your methods to control access based on roles.
public class AppConfig {

    private final JwtRequestFilter jwtRequestFilter;
    private final CustomUserDetailsService customUserDetailsService;

    public AppConfig(JwtRequestFilter jwtRequestFilter, CustomUserDetailsService customUserDetailsService) {
        this.jwtRequestFilter = jwtRequestFilter;
        this.customUserDetailsService = customUserDetailsService;
    }

    /**
     * Configures security filter chain to define security rules.
     * Disables CSRF, enables CORS, and sets up authentication and authorization rules.
     */
    @Bean    
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .csrf(csrf -> csrf.disable()) // Disable CSRF protection
            //Cross-Site Request Forgery
            .cors(cors -> cors.configurationSource(corsConfigurationSource())) 
            //Cross-Origin Resource Sharing
            .authorizeHttpRequests(request -> request
                .requestMatchers(
                    "/auth/**", // Public authenticnts
                    "/api/user/public/**" // Public user endpoints
                ).permitAll()
                .requestMatchers(
                    "/v3/api-docs/**", // Swagger API documentation
                    "/swagger-ui/**",
                    "/swagger-ui.html"   
                ).permitAll()
                .anyRequest().authenticated()) // All other requests require authentication
            .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); 
        // no session on server ,Enables HTTP Basic Authentication
        
        // Add JWT filter before the username-password authentication filter
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        
        return httpSecurity.build();
    }

    /**
     * Defines the password encoder to be used for securing passwords.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    /**
     * Configures authentication provider using DaoAuthenticationProvider.
     * It uses custom user details service and password encoder.
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
    	System.out.println("Authentication provider used");
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider(customUserDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    /**
     * Defines the authentication manager used for authentication processes.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
    	System.out.println("Authentication manager used");
        return authConfig.getAuthenticationManager();
    }
    
    /**
     * Configures CORS settings for handling cross-origin requests.
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOriginPattern("*");
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Allowed HTTP methods
        corsConfiguration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "X-Requested-With")); // Allowed headers
        corsConfiguration.setAllowCredentials(true); // Allow credentials 
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Spring Security Demo")
                .version("1.0")
                .description("API documentation for Spring Security Demo"))
            .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication")) // Secures API with Bearer token
            .components(new Components().addSecuritySchemes("Bearer Authentication",
                new SecurityScheme()
                    .name("Bearer Authentication")
                    .type(SecurityScheme.Type.HTTP)
                    .scheme("bearer")
                    .bearerFormat("JWT") // Enables Bearer Token Authentication
            ));
    }
}