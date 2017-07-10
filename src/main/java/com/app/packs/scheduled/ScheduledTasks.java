package com.app.packs.scheduled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.app.packs.service.interfaces.IPackService;


@Component
public class ScheduledTasks {
	
	@Autowired
	private IPackService service;
	
	/**
	 * Ejecuta el vencimiento de los packs de usuario.
	 */

    @Scheduled(cron = "0 * * * * *")
    public void actualizarPacks() {
        service.verificarVencimiento();
    }

}
