package com.bms.vo;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Transaction")
public class Transaction {
	private long accountNumber;
	private String transactionType;
	private String accountname;
	private String accountType;
	private BigDecimal amount;
	private BigDecimal totalAvailableBalance;
	private String transactionDate;
	
	
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getAccountname() {
		return accountname;
	}
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getTotalAvailableBalance() {
		return totalAvailableBalance;
	}
	public void setTotalAvailableBalance(BigDecimal totalAvailableBalance) {
		this.totalAvailableBalance = totalAvailableBalance;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	
}
