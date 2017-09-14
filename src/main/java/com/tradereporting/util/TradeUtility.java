package com.tradereporting.util;

import java.math.BigDecimal;
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
	public static void CalculateTradeAmountInUSD(TradeInstruction instruction) {
		instruction.setTradeAmount(instruction.getPricePerUnit().multiply(BigDecimal.valueOf(instruction.getUnit())
				 .multiply(instruction.getAgreedFix())));
		
	}
	

}
