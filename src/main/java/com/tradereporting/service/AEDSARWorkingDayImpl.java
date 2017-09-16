package com.tradereporting.service;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class AEDSARWorkingDayImpl implements WorkingDay {

	/**
	 * This method contain logic to check non working 
	 * day for currency other than AER and SAR
	 * @param date
	 * @return boolean
	 */
	public boolean isNonWorkingDay(LocalDate date) {
		final DayOfWeek day = date.getDayOfWeek();
		boolean isWeekEnd =false;
		if (day == DayOfWeek.FRIDAY || day == DayOfWeek.SATURDAY) {
			isWeekEnd = true;
		}
		return isWeekEnd;
		
	}

}
