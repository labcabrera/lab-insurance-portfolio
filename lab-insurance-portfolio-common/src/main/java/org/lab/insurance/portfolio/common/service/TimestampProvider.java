package org.lab.insurance.portfolio.common.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class TimestampProvider {

	private ThreadLocal<Long> offset;

	public TimestampProvider() {
		offset = new ThreadLocal<Long>();
		offset.set(0L);
	}

	/**
	 * Devuelve la fecha actual truncada a las 00:00:00 horas.
	 * 
	 * @return
	 */
	public LocalDateTime getCurrentDate() {
		LocalDateTime date = getCurrentDateTime();
		return date.with(LocalTime.MIN);
	}

	/**
	 * Devuelve la fecha actual.
	 * 
	 * @return
	 */
	public LocalDateTime getCurrentDateTime() {
		LocalDateTime now = LocalDateTime.now();
		if (offset.get() == 0L) {
			return now;
		}
		else {
			return now.plus(offset.get(), ChronoUnit.MILLIS);
		}
	}

	/**
	 * Permite cambiar la fecha del sistema a nivel del thread activo.
	 * 
	 * @param date
	 */
	public void setDate(Date date) {
		// TODO java time api
		Date now = Calendar.getInstance().getTime();
		offset.set(date.getTime() - now.getTime());
	}

	/**
	 * Elimina la opcion de trabajar a una fecha diferente en el thread activo.
	 */
	public void resetDate() {
		offset.set(0L);
	}
}
