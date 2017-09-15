package com.tradereporting.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.tradereporting.model.TradeInstruction;
/**
 *  This class contains utility method of trade engine 
 */
public class TradeUtility {
	
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
	
	/**
	 * This method calculate and set trade amount 
	 * USD amount of a trade = Price per unit * Units * Agreed Fx
	 * @param instruction
	 * 
	 */
	public static void calculateTradeAmountInUSD(TradeInstruction instruction) {
		instruction.setTradeAmount(instruction.getPricePerUnit().multiply(BigDecimal.valueOf(instruction.getUnit())
				 .multiply(instruction.getAgreedFix())));
		
	}
	
	/**
	 * Convert string to locale date
	 * @param date
	 * @return 
	 */
	public static LocalDate convertLocaleDate(String date) {
		return LocalDate.parse(date, formatter);

	}
	
	/**
	 * Convert locale date to string
	 * @param date
	 * @return date in string format
	 */
	public static String convertDateToString(LocalDate date) {
		return formatter.format(date);

	}

}
