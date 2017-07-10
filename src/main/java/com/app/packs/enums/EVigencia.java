package com.app.packs.enums;

import java.util.HashMap;
import java.util.Map;

public enum EVigencia {
	
	DIARIO("01"),SEMANAL("02");
	
	String codigo;

	private EVigencia(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	private static final Map<String,EVigencia> map;
    static {
        map = new HashMap<String,EVigencia>();
        for (EVigencia v : EVigencia.values()) {
            map.put(v.codigo, v);
        }
    }
    public static EVigencia findByKey(String i) throws Exception{
        EVigencia instance = map.get(i);
        if(instance == null){
        	throw new Exception("Codigo incorrecto");
        }
        return instance;
    }
	
	public static class Values {
        public static final String DIARIO = "DIARIO";
        public static final String SEMANAL = "SEMANAL";
    } 
	

}
