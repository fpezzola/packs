package com.app.packs.service.interfaces;

public interface IPackService {
	
	public void purchasePack(long phone, String pack) throws Exception;
	
	public void deletePack(long phone);
	
	public void verificarVencimiento();

}
