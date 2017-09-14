package com.tradereporting.service;

import static junit.framework.TestCase.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.Before;
import org.junit.Test;

import com.tradereporting.model.TradeInstruction;

public class CalculateUSDTradeAmountTest {

	private TradeCalculator tradeCalculator = new TradeCalculator();
	List<TradeInstruction> tradeInstructions = new ArrayList<>();

	@Before
	public void setUp() throws Exception {

		TradeInstruction tr1 = new TradeInstruction("A1", "B", BigDecimal.valueOf(0.50), "AED", "13-Sept-2016",
				"16-Sep-2016", 10, BigDecimal.valueOf(100));
		tradeInstructions.add(tr1);
	}
	
	@Test
	public void testTradeAmountInUSD() {
		tradeCalculator.calculateUSDAmountOfTrade(tradeInstructions);
		assertTrue(Objects.equals(tradeInstructions.get(0).getTradeAmount(), BigDecimal.valueOf(500.00)));
	}
}
