package com.tradereporting.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import com.tradereporting.model.EntityRank;
import com.tradereporting.model.TradeInstruction;

public class ReportGenerator {
	TradeCalculator tradeCalculator;
	
	public ReportGenerator(TradeCalculator tradeCalculator) {
		this.tradeCalculator = tradeCalculator;
	}
	
	
	/**
	 * This method prints daily report of trading 
	 * @param tradeInstructions
	 */
	public void generateReport(List<TradeInstruction> tradeInstructions) {
		StringBuilder sb = new StringBuilder();
		tradeCalculator.calculateUSDAmountOfTrade(tradeInstructions);
		tradeCalculator.caluclateSettlementDate(tradeInstructions);
		
		Predicate<TradeInstruction> buyPredicate = (TradeInstruction p) -> p.getInstructionFlag().equalsIgnoreCase("B");
		sb.append("Daily Outgoing Amount :");
		Map<String, BigDecimal> incomingAmount = tradeCalculator.calculateDailyTradeAmount(tradeInstructions,buyPredicate);
		sb = printAmountReport(incomingAmount,sb);
		sb.append("------------------------------");
		sb.append("\n");
		
		sb.append("Daily Incoming Amount :");
		Predicate<TradeInstruction> sellPredicate = (TradeInstruction p) -> p.getInstructionFlag().equalsIgnoreCase("S");
		Map<String, BigDecimal> outgoingAmount = tradeCalculator.calculateDailyTradeAmount(tradeInstructions,sellPredicate);
		sb = printAmountReport(outgoingAmount,sb);
		sb.append("------------------------------");
		sb.append("\n");
		
		sb.append("Daily Outgoing Entity Ranking :");
		List<EntityRank> entityBuyerRanks = tradeCalculator.calculateRanking(tradeInstructions, buyPredicate);
		sb = printEntityRanking(entityBuyerRanks,sb);
		sb.append("------------------------------");
		sb.append("\n");
		
		sb.append("Daily Incoming Entity Ranking :");
		List<EntityRank> entitySellerRanks =  tradeCalculator.calculateRanking(tradeInstructions, sellPredicate);
		sb = printEntityRanking(entitySellerRanks,sb);
		
		System.out.println(sb.toString());
		
	}
	
	private StringBuilder printAmountReport(Map<String, BigDecimal> amountReport, StringBuilder sb) {
		sb.append("\n");
		amountReport.forEach((Date, Amount) -> {
			sb.append("Date : " + Date + " Amount : " + Amount);
			sb.append("\n");
		});

		return sb;
	}
	
	private StringBuilder printEntityRanking(List<EntityRank> entityRanks,StringBuilder sb) {
		sb.append("\n");
		sb.append("Date : Rank :  Entity :");
		entityRanks.forEach(entityRank -> {
			sb.append("\n");
			sb.append(entityRank.getDate() + " " + entityRank.getRank() + " " + entityRank.getEntity());
			
		});
		sb.append("\n");
		return sb;
	}

}
