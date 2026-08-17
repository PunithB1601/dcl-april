package com.dcl.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.SneakyThrows;


@Configuration
@EnableWebSecurity
public class AppConfig {
//Entire config are written to create the obj with user logic when IoC container starts
	
	
	//before creating DAOAuthenticationProvider, this obj must be ready
	//coz we need to pass this obj as parameter for DAOAuthenticationProviderConstructor.
	//Hence, we are writing its impl inside SecurityServic, a class which impl UserDetailsService
	//thats how we are making this obj ready
	private final UserDetailsService uservice;
	
	public AppConfig(UserDetailsService uservice) {
		this.uservice=uservice;
	}
	
	//IYKYK
	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}
	
	//knows only to encode, cant decode
	@Bean //password encoder to encode our password
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	@Bean  //creating the authentication manager so that we can access in controller
	public AuthenticationManager authConfig(AuthenticationConfiguration configure) {
		return configure.getAuthenticationManager();
	}
	
	@Bean //creating the provider so that we can access it in controller
	public DaoAuthenticationProvider provider() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider(uservice);
		provider.setPasswordEncoder(encoder());
		return provider;
		
	}
	
	@Bean //Every request will hit first on SecurityFilterChain, so this obj has to be ready first
	@SneakyThrows
	public SecurityFilterChain filter(HttpSecurity security){
		security.csrf(req->req.disable()) //disable csrf
		.authorizeHttpRequests(
				req->req.requestMatchers(
				        		"/user/register", //making register req as public req
				        		"/user/login",  //making login req as public req
			                    "/v3/api-docs/**", // Swagger API documentation
			                    "/swagger-ui/**",
			                    "/swagger-ui.html"   
			                ).permitAll()
				        .anyRequest()
				        .authenticated()
				);
		
		return security.build();  //creating ref obj of SecurityFilterChain
	}

}
