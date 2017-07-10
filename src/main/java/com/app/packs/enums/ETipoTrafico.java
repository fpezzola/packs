package com.app.packs.enums;

public enum ETipoTrafico {
	
	SMS("SMS","sms"),LLAMADA("CALL","minutos"),DATOS("DATA","MegaBytes");
	
	private String codigo;
	private String unidadTrafico;

	private ETipoTrafico(String codigo,String unidad) {
		this.codigo = codigo;
		this.unidadTrafico = unidad;
	}
	
	
	
	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public String getUnidadTrafico() {
		return unidadTrafico;
	}



	public void setUnidadTrafico(String unidadTrafico) {
		this.unidadTrafico = unidadTrafico;
	}



	public static class Values {
        public static final String LLAMADA = "LLAMADA";
        public static final String SMS = "SMS";
        public static final String DATOS = "DATOS";
    }   
}
