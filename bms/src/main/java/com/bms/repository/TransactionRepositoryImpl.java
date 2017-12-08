package com.bms.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.bms.vo.Transaction;




public class TransactionRepositoryImpl implements  TransactionRepositoryCustom{

	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<Transaction> findByAccountNumber(long accountNumber) {
		List<Transaction> txnList = mongoTemplate.find(Query.query(Criteria.where("accountNumber").is(accountNumber)),Transaction.class);
		return txnList;
	}

	
	//Query query = new Query(Criteria.where("b").elemMatch(Criteria.where("startDate").lte(date).and("endDate").gte(date));  to get data between dates
	//Criteria.where("expenseDate").gte(calendar1.getTime()).lte(calendar2.getTime()).and("userid").is(uid);}
	


}
