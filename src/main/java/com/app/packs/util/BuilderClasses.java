package com.app.packs.util;

import java.sql.Timestamp;
import java.util.Date;

import com.app.packs.domain.pack.Pack;
import com.app.packs.domain.user.UserPack;
import com.app.packs.enums.EEstadoPack;

public class BuilderClasses {

	public static UserPack buildUser(long phone, Pack pack){
		UserPack up = new UserPack();
		up.setPhone(phone);
		up.setPack(pack);
		up.setEstado(EEstadoPack.N);
		java.util.Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		up.setFecha(timestamp);
		up.setFechaVencimiento(pack.darFechaVencimiento(timestamp));
		return up;
	}
}
