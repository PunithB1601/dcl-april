package com.travelgo.bus.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

public class AppConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "vrxoc8bz",
                "api_key", "453932592655154",
                "api_secret", "did99aWpw17vCXN_yvdqs3-kzxQ"
        ));
    }
}
