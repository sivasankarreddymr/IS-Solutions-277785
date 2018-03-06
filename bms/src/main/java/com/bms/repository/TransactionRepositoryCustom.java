package com.bms.repository;

import java.util.List;
import com.bms.vo.Transaction;



public interface TransactionRepositoryCustom {
	
List<Transaction> findByAccountNumber(long accountNumber);
List<Transaction> findByTransactionType(long accountNumber,String transactionType);

	

}
