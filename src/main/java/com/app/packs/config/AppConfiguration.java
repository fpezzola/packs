package com.app.packs.config;

import java.util.EnumMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.packs.enums.EVigencia;
import com.app.packs.repository.IPackDiarioRepository;
import com.app.packs.repository.IPackRepository;
import com.app.packs.repository.IPackSemanalRepository;

@Configuration
public class AppConfiguration {
	
	  	@Autowired 
	    private IPackDiarioRepository packDiario;
	    
	    @Autowired 
	    private IPackSemanalRepository packSemanal;
	    
	    @Bean
	    public Map<EVigencia, IPackRepository<?>> packRepository() {
	        Map<EVigencia,  IPackRepository<?>> map = new EnumMap<EVigencia,IPackRepository<?>>(EVigencia.class);
	        map.put(EVigencia.DIARIO, packDiario);
	        map.put(EVigencia.SEMANAL, packSemanal);
	        return map;
	    }
}
