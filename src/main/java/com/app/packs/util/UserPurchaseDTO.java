package com.app.packs.util;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserPurchaseDTO {
	
	@NotNull
	@Size(min=10,max=10)
	private String phone;
	@NotNull
	private String pack;
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
	
	
	

}
