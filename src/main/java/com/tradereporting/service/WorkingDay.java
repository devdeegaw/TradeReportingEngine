package com.tradereporting.service;

import java.time.LocalDate;

public abstract class WorkingDay {
	
	abstract boolean isNonWorkingDay(LocalDate date);
	
	/**
	 * This method contain logic to get workingday
	 * @param date
	 * @return LocalDate
	 */
	public LocalDate findWorkingDay(LocalDate date) {

		while (isNonWorkingDay(date)) {
			date = date.plusDays(1);
		}
		return date;
	}
	

}
