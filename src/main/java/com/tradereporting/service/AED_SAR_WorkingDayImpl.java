package com.tradereporting.service;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class AED_SAR_WorkingDayImpl extends WorkingDay {

	/**
	 * This method contain logic to check non working 
	 * day for currency other than AER and SAR
	 * @param date
	 * @return boolean
	 */
	public boolean isNonWorkingDay(LocalDate date) {
		final DayOfWeek day = date.getDayOfWeek();
		if (day == DayOfWeek.FRIDAY || day == DayOfWeek.SATURDAY) {
			return true;
		}else {
			return false;
		}
		
	}

}
