package com.tradereporting.service;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

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

	/**
	 * Calculate daily incoming and outgoing trade amount 
	 * @param tradeInstructions
	 */
	public Map<String, BigDecimal> calculateDailyTradeAmount(List<TradeInstruction> tradeInstructions,
			Predicate<TradeInstruction> predicate) {

		Stream<TradeInstruction> instStream = tradeInstructions.stream();
		return instStream.filter(predicate).collect(groupingBy(TradeInstruction::getSettlementDate,
				mapping(TradeInstruction::getTradeAmount, reducing(BigDecimal.ZERO, BigDecimal::add))));

	}
}
