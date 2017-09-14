package com.tradereporting.service;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

import com.tradereporting.model.TradeInstruction;


public class DailyTradeAmountTest {
	List<TradeInstruction> tradeInstructions = new ArrayList<>();
	TradeCalculator tradeCalculator = new TradeCalculator();
	@Before
	public void setUp() throws Exception {

		TradeInstruction tradeInstruction1 = new TradeInstruction("A1", "B", BigDecimal.valueOf(0.50), "AED",
				"14-Sept-2016", "16-Sep-2016", 10, BigDecimal.valueOf(100));
		tradeInstruction1.setTradeAmount(BigDecimal.valueOf(500.00));
		
		TradeInstruction tradeInstruction2 = new TradeInstruction("A2", "S", BigDecimal.valueOf(1), "USD",
				"14-Sept-2016", "16-Sep-2016", 5, BigDecimal.valueOf(100));
		tradeInstruction2.setTradeAmount(BigDecimal.valueOf(500.00));
		
		TradeInstruction tradeInstruction3 = new TradeInstruction("A3", "B", BigDecimal.valueOf(1.5), "GBP",
				"14-Sept-2016", "16-Sep-2016", 3, BigDecimal.valueOf(100));
		tradeInstruction3.setTradeAmount(BigDecimal.valueOf(450.00));
		
		tradeInstructions.add(tradeInstruction1);
		tradeInstructions.add(tradeInstruction2);
		tradeInstructions.add(tradeInstruction3);
	}

	@Test
	public void testDailyOutgoingAmount() throws Exception {
		Predicate<TradeInstruction> buyPredicate = (TradeInstruction p) -> p.getInstructionFlag().equalsIgnoreCase("B");
		
		final Map<String, BigDecimal> dailyOutgoingAmount = tradeCalculator.calculateDailyTradeAmount(tradeInstructions,
				buyPredicate);
		assertEquals(1, dailyOutgoingAmount.size());
		assertTrue(Objects.equals(dailyOutgoingAmount.get("16-Sep-2016"),BigDecimal.valueOf(950.00)));
	}
	
	@Test
	public void testDailyIncomingAmount() throws Exception {
		Predicate<TradeInstruction> buyPredicate = (TradeInstruction p) -> p.getInstructionFlag().equalsIgnoreCase("S");
		
		final Map<String, BigDecimal> dailyOutgoingAmount = tradeCalculator.calculateDailyTradeAmount(tradeInstructions,
				buyPredicate);
		assertEquals(1, dailyOutgoingAmount.size());
		assertTrue(Objects.equals(dailyOutgoingAmount.get("16-Sep-2016"),BigDecimal.valueOf(500.00)));
	}

}
