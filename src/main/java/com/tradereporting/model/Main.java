package com.tradereporting.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.tradereporting.service.ReportGenerator;
import com.tradereporting.service.TradeCalculator;


public class Main {
	public static void main(String[] args) {

		String instructionDate ="15-Sept-2016";
		String buyInstruction="B";
		String sellInstruction ="S";
		String settlementDate ="16-Sep-2016";
		TradeInstruction tr1 = new TradeInstruction("A1",buyInstruction,BigDecimal.valueOf(0.50),"AED",instructionDate,
				settlementDate,10,BigDecimal.valueOf(100));
		
		TradeInstruction tr2 = new TradeInstruction("A2",sellInstruction,BigDecimal.valueOf(1),"USD",instructionDate,
				settlementDate,5,BigDecimal.valueOf(100));
		
		TradeInstruction tr3 = new TradeInstruction("A3",buyInstruction,BigDecimal.valueOf(1.5),"GBP",instructionDate,
				settlementDate,3,BigDecimal.valueOf(100));
		
		TradeInstruction tr4 = new TradeInstruction("A4",buyInstruction,BigDecimal.valueOf(0.50),"SAR",instructionDate,
				settlementDate,7,BigDecimal.valueOf(100));
		
		TradeInstruction tr5 = new TradeInstruction("A5",buyInstruction,BigDecimal.valueOf(0.60),"INR",instructionDate,
				settlementDate,8,BigDecimal.valueOf(100));
		
		TradeInstruction tr6 = new TradeInstruction("A6",buyInstruction,BigDecimal.valueOf(1),"USD",instructionDate,
				settlementDate,15,BigDecimal.valueOf(100));
		
		List<TradeInstruction> tradeInsructions = new ArrayList<>();
		tradeInsructions.add(tr1);
		tradeInsructions.add(tr2);
		tradeInsructions.add(tr3);
		tradeInsructions.add(tr4);
		tradeInsructions.add(tr5);
		tradeInsructions.add(tr6);
		TradeCalculator tradeCalculator = new TradeCalculator();
		ReportGenerator report = new ReportGenerator(tradeCalculator);
		report.generateReport(tradeInsructions);
	}


}
