package com.tradereporting.service;

import static junit.framework.TestCase.assertTrue;

import java.math.BigDecimal;
import java.util.Objects;

import org.junit.Before;
import org.junit.Test;

import com.tradereporting.model.TradeInstruction;
import com.tradereporting.util.TradeUtility;


public class USDTradeAmountTest {

	TradeInstruction tradeInstruction;
	@Before
	public void setUp() throws Exception {

		tradeInstruction = new TradeInstruction("A1", "B", BigDecimal.valueOf(0.50), "AED", "13-Sept-2016",
				"16-Sep-2016", 10, BigDecimal.valueOf(100));
	}
	
	@Test
	public void testTradeAmountInUSD() {
		TradeUtility.calculateTradeAmountInUSD(tradeInstruction);
		assertTrue(Objects.equals(tradeInstruction.getTradeAmount(), BigDecimal.valueOf(500.00)));
	}
}
