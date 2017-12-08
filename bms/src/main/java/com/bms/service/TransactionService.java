package com.bms.service;

import java.math.BigDecimal;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.bms.vo.Customer;
import com.bms.vo.Transaction;

@Service
public class TransactionService {
	
  public Transaction  fillTransactionDetails(Customer customer){
	
	  
	  Transaction transaction = new Transaction();
	  transaction.setAccountNumber(customer.getAccountNumber());
	  transaction.setAccountType(customer.getAccountType());
	  transaction.setAmount(customer.getDepositAmount());
	  transaction.setTransactionDate(customer.getRegistrationDate());
	  transaction.setTransactionType("C");
	  transaction.setTotalAvailableBalance(transaction.getAmount());
	  return transaction;
  }
  
  
  
  
 
  
  public void calculateTransaction(Transaction transaction,Customer customer){
	    String transactionType = transaction.getTransactionType();
	    BigDecimal totalAvailableBalance = new BigDecimal(0.0);
	    if("C".equalsIgnoreCase(transactionType)){
	    	totalAvailableBalance = customer.getTotalAccountBalance().add(transaction.getAmount());
	    }else if("D".equalsIgnoreCase(transactionType)){
	    	totalAvailableBalance = customer.getTotalAccountBalance().subtract(transaction.getAmount());
	    }
	    
	    transaction.setTotalAvailableBalance(totalAvailableBalance);
	    customer.setTotalAccountBalance(totalAvailableBalance);
  }

}
