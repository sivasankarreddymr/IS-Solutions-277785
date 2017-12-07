package com.bms.service;

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
  
  
  private long generateUniqueAccNumber(){
	  long uniqueAccountNumber = (long) (Math.random() * 10000000000000000L);
	 return  uniqueAccountNumber;
  }
  
  private String generateUniqueCustomerId() {
	  Random random = new Random();
	  String uniqueCustomerId = "RRR-"+random.nextInt(900);
	  return uniqueCustomerId;
  }

}
