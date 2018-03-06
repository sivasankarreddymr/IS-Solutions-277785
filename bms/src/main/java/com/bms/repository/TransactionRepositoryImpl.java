package com.bms.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import com.bms.vo.Transaction;

public class TransactionRepositoryImpl implements TransactionRepositoryCustom {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<Transaction> findByAccountNumber(long accountNumber) {
		List<Transaction> txnList = mongoTemplate.find(Query.query(Criteria.where("accountNumber").is(accountNumber)),Transaction.class);
		return txnList;
	}

	@Override
	public List<Transaction> findByTransactionType(long accountNumber,String transactionType) {
		List<Transaction> txnList = mongoTemplate.find(Query.query(Criteria.where("accountNumber").is(accountNumber).andOperator(Criteria.where("transactionType").is(transactionType))), Transaction.class);
		return txnList;
	}

}
