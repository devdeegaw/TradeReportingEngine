package com.tradereporting.service;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

import com.tradereporting.model.EntityRank;
import com.tradereporting.model.TradeInstruction;


public class DailyEntityRankingTest {
	List<TradeInstruction> tradeInstructions = new ArrayList<>();
	TradeCalculator tradeCalculator = new TradeCalculator();
	@Before
	public void setUp() throws Exception {

		TradeInstruction tradeInstruction1 = new TradeInstruction("A1", "B", BigDecimal.valueOf(0.50), "AED",
				"14-Sept-2016", "16-Sep-2016", 10, BigDecimal.valueOf(100));
		tradeInstruction1.setTradeAmount(BigDecimal.valueOf(500.00));
		
		TradeInstruction tradeInstruction2 = new TradeInstruction("A2", "S", BigDecimal.valueOf(1), "USD",
				"14-Sept-2016", "16-Sep-2016", 4, BigDecimal.valueOf(100));
		tradeInstruction2.setTradeAmount(BigDecimal.valueOf(400.00));
		
		TradeInstruction tradeInstruction3 = new TradeInstruction("A3", "B", BigDecimal.valueOf(1.5), "GBP",
				"14-Sept-2016", "16-Sep-2016", 3, BigDecimal.valueOf(100));
		tradeInstruction3.setTradeAmount(BigDecimal.valueOf(450.00));
		
		tradeInstructions.add(tradeInstruction1);
		tradeInstructions.add(tradeInstruction2);
		tradeInstructions.add(tradeInstruction3);
	}
	
	@Test
    public void testDailyOutGoingRanking() throws Exception {
		Predicate<TradeInstruction> buyPredicate = (TradeInstruction p) -> p.getInstructionFlag().equalsIgnoreCase("B");
        final List<EntityRank> dailyoutGoingRanking = tradeCalculator.calculateRanking(tradeInstructions, buyPredicate);

        assertEquals(2, dailyoutGoingRanking.size());
        assertTrue(dailyoutGoingRanking.contains(new EntityRank(1, "A1", "16-Sep-2016")));
        assertTrue(dailyoutGoingRanking.contains(new EntityRank(2, "A3", "16-Sep-2016")));

    }
	
	@Test
    public void testDailyIncomingRanking() throws Exception {
		Predicate<TradeInstruction> sellPredicate = (TradeInstruction p) -> p.getInstructionFlag().equalsIgnoreCase("S");
        final List<EntityRank> dailyIncomingRanking = tradeCalculator.calculateRanking(tradeInstructions, sellPredicate);

        assertEquals(1, dailyIncomingRanking.size());
        assertTrue(dailyIncomingRanking.contains(new EntityRank(1, "A2", "16-Sep-2016")));

    }

}
