package com.tradereporting.service;


import java.util.List;
import com.tradereporting.model.TradeInstruction;
import com.tradereporting.util.TradeUtility;
/**
 *  This class contain trade calculation method like amount and settlement date 
 */
public class TradeCalculator {

	
	/**
	 * Calculate USD amount of a trade
	 * @param tradeInstructions
	 */
	public void calculateUSDAmountOfTrade(List<TradeInstruction> tradeInstructions) {
		tradeInstructions.forEach(TradeUtility::CalculateTradeAmountInUSD);
	}

	
}
