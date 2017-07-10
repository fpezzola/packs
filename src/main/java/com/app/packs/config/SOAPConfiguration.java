package com.app.packs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.packs.web.soap.prepaidService.impl.PrepaidServiceImplService;
import com.app.packs.web.soap.prepaidService.service.PrepaidService;

@Configuration
public class SOAPConfiguration {
    
    @Bean 
    public PrepaidService provider(){
    	return new PrepaidServiceImplService().getPrepaidServiceImplPort();
    }
    

}
