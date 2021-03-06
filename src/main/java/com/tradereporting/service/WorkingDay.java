package com.tradereporting.service;

import java.time.LocalDate;

public interface WorkingDay {
	
	abstract boolean isNonWorkingDay(LocalDate date);
	
	/**
	 * This method contain logic to get workingday
	 * @param date
	 * @return LocalDate
	 */
	public default LocalDate findWorkingDay(LocalDate date) {
		LocalDate workingDay = date;
		while (isNonWorkingDay(workingDay)) {
			workingDay = workingDay.plusDays(1);
		}
		return workingDay;
	}
	

}
