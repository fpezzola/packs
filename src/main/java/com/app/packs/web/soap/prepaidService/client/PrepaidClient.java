package com.app.packs.web.soap.prepaidService.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.packs.domain.bono.Bono;
import com.app.packs.domain.pack.Pack;
import com.app.packs.web.soap.prepaidService.jaxbClasses.BoltonOperationRequest;
import com.app.packs.web.soap.prepaidService.jaxbClasses.GetPlanForUserResponse;
import com.app.packs.web.soap.prepaidService.jaxbClasses.UserOperationRequest;
import com.app.packs.web.soap.prepaidService.service.PrepaidService;

/**
 * Cliente que realiza las peticiones a traves de la interfaz {@link com.app.packs.web.soap.prepaidService.service.PrepaidService}
 */

@Component
public class PrepaidClient {
	
	@Autowired
	private PrepaidService prepaidService;
	
	/**
	 * Consulta al sistema prepago y devuelve el plan del usuario.
	 * @param phone
	 * @return
	 */
	
	public String getPlanForUser(long phone){
		UserOperationRequest userOperation = new UserOperationRequest();
		userOperation.setPhoneNumber(phone);
		GetPlanForUserResponse userResponse = prepaidService.getPlanForUser(userOperation);
		return userResponse.getPlan();
	}
	
	/**
	 * Compra todos los bonos que componen el pack en el sistema prepago
	 * @param phone
	 * @param pack
	 */
	public void purchase(long phone, Pack pack){
		BoltonOperationRequest purchaseRequest = new BoltonOperationRequest();
		purchaseRequest.setPhoneNumber(phone);
		for(Bono bono : pack.getBonos()){
			purchaseRequest.setBoltonCode(bono.getBoltonCode());
			prepaidService.purchaseBolton(purchaseRequest);
		}
	}
	
	/**
	 * Elimina los bonos de todos los packs en sistema prepago
	 * @param phone
	 * @param packs
	 */
	public void deleteBolton(long phone, List<Pack> packs){
		BoltonOperationRequest purchaseRequest = new BoltonOperationRequest();
		purchaseRequest.setPhoneNumber(phone);
		for(Pack pack : packs){
			for(Bono bono : pack.getBonos()){
				purchaseRequest.setBoltonCode(bono.getBoltonCode());
				prepaidService.deleteBolton(purchaseRequest);
			}
		}
	
	}

}
