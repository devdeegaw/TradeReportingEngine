package com.tradereporting.service;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.tradereporting.model.EntityRank;
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
	
	/**
	 * Calculate daily incoming and outgoing trade amount 
	 * @param tradeInstructions
	 */
	public List<EntityRank> calculateRanking(List<TradeInstruction> tradeInstructions,
			Predicate<TradeInstruction> predicate) {
		List<EntityRank> entityRankList = new ArrayList<>();
		Comparator<TradeInstruction> compareAmount = (TradeInstruction tr1, TradeInstruction tr2) -> Integer
				.compare(tr2.getTradeAmount().intValue(), tr1.getTradeAmount().intValue());

		tradeInstructions.stream().filter(predicate).collect(groupingBy(TradeInstruction::getSettlementDate))
				.forEach((settlementDate, instructions) -> {
					int rank =1;
					Collections.sort(instructions, compareAmount);
					for (TradeInstruction instruction : instructions) {
						entityRankList
								.add(new EntityRank(rank++, instruction.getEntity(), settlementDate));
					}
				});
		return entityRankList;

	}
	
	/**
	 * calculate settlement for 
	 * @param tradeInstructions
	 */
	public void caluclateSettlementDate(List<TradeInstruction> tradeInstructions) {
		tradeInstructions.forEach(TradeCalculator::setSettlementDate);
	}
	
	private static void setSettlementDate(TradeInstruction tradeInsructions) {
		WorkingDay workingDay = getWorkingDay(tradeInsructions.getCurrency());
		LocalDate settlementDate = workingDay.findWorkingDay(TradeUtility.convertLocaleDate(tradeInsructions.getSettlementDate()));
		tradeInsructions.setSettlementDate(TradeUtility.convertDateToString(settlementDate));
	}
	
	private static WorkingDay getWorkingDay(String currency) {
		if ("AED".equalsIgnoreCase(currency)
				|| "SAR".equalsIgnoreCase(currency)) {
			return  new AED_SAR_WorkingDayImpl();
		} else {
			return  new WorkingDayImpl();
		}
		
	}
}
