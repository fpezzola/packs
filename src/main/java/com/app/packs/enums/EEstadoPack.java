package com.app.packs.enums;

public enum EEstadoPack {
	
	N("NUEVO"), E("ELIMINADO"), V("VENCIDO");
	
	private String descripcion;
	
	private EEstadoPack(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
}
