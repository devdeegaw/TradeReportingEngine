package com.tradereporting.model;

import java.math.BigDecimal;

/**
 *  Model bean class for trade instructions sent by various clients
 */
public class TradeInstruction {

	private String entity;

	private String instructionFlag;

	private BigDecimal agreedFix;

	private String currency;

	private String instructionDate;

	private String settlementDate;

	private int unit;

	private BigDecimal pricePerUnit;

	private BigDecimal tradeAmount;

	public TradeInstruction(String entity, String instructionFlag, BigDecimal agreedFix, String currency, String instructionDate,
			String settlementDate, int unit, BigDecimal pricePerUnit) {
		this.entity = entity;
		this.instructionFlag = instructionFlag;
		this.agreedFix = agreedFix;
		this.currency = currency;
		this.instructionDate = instructionDate;
		this.settlementDate = settlementDate;
		this.unit = unit;
		this.pricePerUnit = pricePerUnit;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getAgreedFix() {
		return agreedFix;
	}

	public void setAgreedFix(BigDecimal agreedFix) {
		this.agreedFix = agreedFix;
	}

	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(BigDecimal pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getInstructionFlag() {
		return instructionFlag;
	}

	public void setInstructionFlag(String instructionFlag) {
		this.instructionFlag = instructionFlag;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public BigDecimal getTradeAmount() {
		return tradeAmount;
	}

	public void setTradeAmount(BigDecimal tradeAmount) {
		this.tradeAmount = tradeAmount;
	}

	public String getInstructionDate() {
		return instructionDate;
	}

	public void setInstructionDate(String instructionDate) {
		this.instructionDate = instructionDate;
	}

	public String getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(String settlementDate) {
		this.settlementDate = settlementDate;
	}

	@Override
	public String toString() {

		return "Instructions [" + this.entity + ", " + this.tradeAmount + ", " + this.settlementDate + ", "
				+ this.instructionFlag + "]";
	}

}
