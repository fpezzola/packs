package com.app.packs.web.rest.error.dto;

public class ErrorDTO {
	
	private final String message;
    private final String description;
    
    public ErrorDTO(String message, String description) {
        this.message = message;
        this.description = description;
    }

	public String getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}
    
    

}
