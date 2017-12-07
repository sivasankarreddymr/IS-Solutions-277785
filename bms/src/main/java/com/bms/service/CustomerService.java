package com.bms.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.bms.vo.Customer;
import com.bms.vo.Transaction;



@Service
public class CustomerService {
	
  public Customer  fillCustomerDetails(Customer customer){
	
	  customer.setAccountNumber(generateUniqueAccNumber());
	  customer.setCustomerId(generateUniqueCustomerId());
	 // customer.setTransaction(generateTransactionDetails(customer));
	  
	  return customer;
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
  
  private Transaction generateTransactionDetails(Customer customer){
	  
	  Transaction transaction = customer.getTransaction();
	  transaction.setAccountNumber(customer.getAccountNumber());
	  transaction.setAccountType(customer.getAccountType());
	  transaction.setAmount(customer.getDepositAmount());
	  transaction.setTransactionDate(customer.getRegistrationDate());
	  transaction.setTransactionType("C");
	  transaction.setTotalAvailableBalance(transaction.getAmount());
	  return transaction;
  }

}
