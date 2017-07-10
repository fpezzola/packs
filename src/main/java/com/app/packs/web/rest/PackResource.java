package com.app.packs.web.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.packs.service.interfaces.IPackService;
import com.app.packs.util.UserPurchaseDTO;

import org.springframework.util.StringUtils;

@RestController
@RequestMapping(value="api/pack")
public class PackResource {
	
	@Autowired
	private IPackService service;
	
	@RequestMapping(path="/purchase",method=RequestMethod.POST,consumes="application/json")
	@ResponseBody
	public  ResponseEntity<String> purchasePOST(@Valid @RequestBody UserPurchaseDTO purchase) throws Exception{
		service.purchasePack(Long.parseLong(purchase.getPhone()), purchase.getPack());
		return ResponseEntity.ok("Operacion realizada con exito");
	}
	
	
	@RequestMapping(path="purchase/{phone}/{pack}",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> purchaseGET(@PathVariable("phone")Long phone,@PathVariable("pack")String pack)throws Exception{
		if(StringUtils.isEmpty(phone) || StringUtils.isEmpty(pack)){
			throw new IllegalArgumentException("El telefono y el pack es necesario.");
		}
		service.purchasePack(phone, pack);
		return ResponseEntity.ok("Operacion realizada con exito");
	}
	
	
	@RequestMapping(path="delete/{phone}",method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> delete(@PathVariable("phone")Long phone)throws Exception{
		if(StringUtils.isEmpty(phone)){
			throw new IllegalArgumentException("El telefono es necesario.");
		}
		service.deletePack(phone);
		return ResponseEntity.ok("Operacion Realizada con exito");
	}

}
