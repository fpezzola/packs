package com.app.packs.domain.pack;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.app.packs.enums.EVigencia;

@Entity
@DiscriminatorValue(value=EVigencia.Values.DIARIO)
public class PackDiario extends Pack{

	/**
	 * Da la fecha de venicmineto de ahora a mañana.
	 */
	@Override
	public Timestamp darFechaVencimiento(Timestamp ts) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(ts);
		cal.add(Calendar.DAY_OF_WEEK, 1);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return new Timestamp(cal.getTime().getTime());
	}

}
