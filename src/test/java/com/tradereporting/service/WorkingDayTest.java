package com.tradereporting.service;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class WorkingDayTest {
	
	private WorkingDay workingDay;
	

	@Test
	public void testDefaultWorkingDay_WeekDay() {
		workingDay = new WorkingDayImpl();
		LocalDate date = workingDay.findWorkingDay(LocalDate.of(2017, 9, 14));
		Assert.assertTrue(date.equals(LocalDate.of(2017, 9, 14)));
		
	}
	
	@Test
	public void testDefaultWorkingDay_WeekEnd() {
		workingDay = new WorkingDayImpl();
		LocalDate date = workingDay.findWorkingDay(LocalDate.of(2017, 9, 16));
		Assert.assertTrue(date.equals(LocalDate.of(2017, 9, 18)));
		
	}
	
	@Test
	public void testAEDWorkingDay_WeekEnd() {
		workingDay = new AED_SAR_WorkingDayImpl();
		LocalDate date = workingDay.findWorkingDay(LocalDate.of(2017, 9, 15));
		Assert.assertTrue(date.equals(LocalDate.of(2017, 9, 17)));
		
	}
	
	@Test
	public void testAEDWorkingDay_WeekDay() {
		workingDay = new AED_SAR_WorkingDayImpl();
		LocalDate date = workingDay.findWorkingDay(LocalDate.of(2017, 9, 14));
		Assert.assertTrue(date.equals(LocalDate.of(2017, 9, 14)));
		
	}

}
