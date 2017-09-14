package com.tradereporting.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.tradereporting.service.ReportGenerator;
import com.tradereporting.service.TradeCalculator;


public class Main {
	public static void main(String[] args) {

		TradeInstruction tr1 = new TradeInstruction("A1","B",BigDecimal.valueOf(0.50),"AED","13-Sept-2016",
				"16-Sep-2016",10,BigDecimal.valueOf(100));
		
		TradeInstruction tr2 = new TradeInstruction("A2","S",BigDecimal.valueOf(1),"USD","13-Sept-2016",
				"16-Sep-2016",5,BigDecimal.valueOf(100));
		
		TradeInstruction tr3 = new TradeInstruction("A3","B",BigDecimal.valueOf(1.5),"GBP","13-Sept-2016",
				"16-Sep-2016",3,BigDecimal.valueOf(100));
		
		TradeInstruction tr4 = new TradeInstruction("A4","B",BigDecimal.valueOf(0.50),"SAR","13-Sept-2016",
				"16-Sep-2016",7,BigDecimal.valueOf(100));
		
		TradeInstruction tr5 = new TradeInstruction("A5","B",BigDecimal.valueOf(0.60),"INR","13-Sept-2016",
				"16-Sep-2016",8,BigDecimal.valueOf(100));
		
		TradeInstruction tr6 = new TradeInstruction("A6","B",BigDecimal.valueOf(1),"USD","13-Sept-2016",
				"16-Sep-2016",15,BigDecimal.valueOf(100));
		
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
