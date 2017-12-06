package com.bms.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

//@Document(collection="Transaction")
public class Transaction {

	private String accountNO;
	private String accountName;
	private String accountType;
	private Date transactionType;
	private String amount;
	private String transactionDt;
	private long transactionId;
	public String getAccountNO() {
		return accountNO;
	}
	public void setAccountNO(String accountNO) {
		this.accountNO = accountNO;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Date getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(Date transactionType) {
		this.transactionType = transactionType;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getTransactionDt() {
		return transactionDt;
	}
	public void setTransactionDt(String transactionDt) {
		this.transactionDt = transactionDt;
	}
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	
	
	
}
