package com.bms.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.constants.BMSConstants;
import com.bms.repository.CustomerRespository;
import com.bms.repository.TransactionRespository;
import com.bms.vo.Customer;
import com.bms.vo.Request;
import com.bms.vo.Statement;
import com.bms.vo.Transaction;

@Service
public class TransactionService {

	@Autowired
	TransactionRespository transactionRepository;
	@Autowired
	CustomerRespository customerRepository;


	public void insertTransactionDetails(Customer customer) {

		Transaction transaction = new Transaction();
		transaction.setAccountNumber(customer.getAccountNumber());
		transaction.setAccountType(customer.getAccountType());
		transaction.setAmount(customer.getDepositAmount());
		transaction.setTransactionDate(getCurrentDate());
		transaction.setTransactionType(BMSConstants.TXN_TYPE_CREDIT);
		transaction.setTotalAvailableBalance(transaction.getAmount());
		transactionRepository.insert(transaction);

	}

	public void saveTransaction(Transaction transaction) {
		Customer customer = customerRepository.findByAccountNumber(transaction.getAccountNumber());
		String transactionType = transaction.getTransactionType();
		BigDecimal totalAvailableBalance = new BigDecimal(0.0);
		String transType="";
		if (BMSConstants.TXN_TYPE_CREDIT.equalsIgnoreCase(transactionType)) {
			totalAvailableBalance = customer.getTotalAccountBalance().add(transaction.getAmount());
			transType="Credit";
		} else if (BMSConstants.TXN_TYPE_DEBIT.equalsIgnoreCase(transactionType)) {
			totalAvailableBalance = customer.getTotalAccountBalance().subtract(transaction.getAmount());
			transType="Debit";
		}
		transaction.setTransactionDate(getCurrentDate());
		transaction.setTotalAvailableBalance(totalAvailableBalance);
		customer.setTotalAccountBalance(totalAvailableBalance);
		transactionRepository.insert(transaction);
		String resultMsg = "Transaction '"+transType+"' is Successful. \n Your total balance amount is ";
		transaction.setResultMessage(resultMsg+transaction.getTotalAvailableBalance()+BMSConstants.TRANSACTION_SUCC_MSG );
		updateCustomerDetails(customer);

	}

	private void updateCustomerDetails(Customer customer) {
		Customer updatedCustomer = customer;
		customerRepository.delete(customer.getId());
		customerRepository.insert(updatedCustomer);

	}

	public List<Statement> viewStatement(Request request) {
		List<Transaction> txnList = transactionRepository.findByAccountNumber(Long.parseLong(request.getAccountNumber()));
		List<Statement> stmtList = prepareStatmentList(txnList, request);
		return stmtList;
	}

	 private boolean isValidRecord(Transaction txn, Request requestVO) {
		 String fromDate= requestVO.getFrom();
		 String toDate= requestVO.getTo();
		 String transDate = txn.getTransactionDate();
		 boolean valid=false;
		 try{
		    if((getDate(transDate).before(getDate(toDate)) || getDate(transDate).equals(getDate(toDate)) ) &&
		    		( getDate(transDate).after(getDate(fromDate)) || getDate(transDate).equals(getDate(toDate))) ){
		    	valid = true;
		    }
		    if(valid && requestVO.getTransactionType()!= null){
		    	if(!requestVO.getTransactionType().equals(txn.getTransactionType())){
		    		valid = false;	
		    	}
		    }
		 }catch(Exception ex){
			 valid = false;
		 }
		return valid;
	 }
	 
	 private Date getDate(String dateStr){
		 SimpleDateFormat sdf = new SimpleDateFormat(BMSConstants.DATE_FORMAT);
		 Date date =null;
         try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return date;
	 }
	private List<Statement> prepareStatmentList(List<Transaction> txnList, Request request) {
		List<Statement> stmtList = new ArrayList<Statement>();
		Statement stmtVO = null;		
		for (Transaction txn : txnList) {
			stmtVO = new Statement();
			stmtVO.setAccountNumber(new Long(txn.getAccountNumber()).toString());
			stmtVO.setBalance(txn.getTotalAvailableBalance().longValue());
			if(txn.getTransactionType()!= null && txn.getTransactionType().equals("C")){
				stmtVO.setDebitCredit("Credit");
			}else if(txn.getTransactionType()!= null && txn.getTransactionType().equals("D")){
				stmtVO.setDebitCredit("Debit");
			}			
			stmtVO.setDescription(txn.getAccountname());
			stmtVO.setTransactionDate(txn.getTransactionDate());
			if(isValidRecord(txn,request)) {
				stmtList.add(stmtVO);
			}
			if(reachedNoOfTransactions(stmtList,request)){
				break;
			}
		}
		return stmtList;
	}
	
	private boolean reachedNoOfTransactions(List<Statement> stmtList,Request request){
		if(request.getNoOfTransactions()!=null && !request.getNoOfTransactions().isEmpty()){
			if(request.getNoOfTransactions().equals("ALL")){
				return false;
			}
			int num = Integer.parseInt(request.getNoOfTransactions());
			if(stmtList!= null && (stmtList.size()==num)){
				return true;
			}
		}
		return false;
	}

	private String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat(BMSConstants.DATE_FORMAT);
		String currentDate = sdf.format(new java.util.Date());
		return currentDate;
	}

}
