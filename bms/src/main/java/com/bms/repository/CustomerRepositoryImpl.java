package com.bms.repository;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.bms.vo.Customer;


public class CustomerRepositoryImpl implements CustomerRepositoryCustom{

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public Customer findByAccountNumber(long accountNumber) {
		Customer customer = mongoTemplate.findById(accountNumber, Customer.class);
		return customer;
	}

	@Override
	public Customer findByAccountNumber(long accountNumber,
			BigDecimal totalAccountBalance) {
		// TODO Auto-generated method stub
		Customer customer = mongoTemplate.findOne(Query.query(Criteria.where("accountNumber").is(accountNumber)),
				  Customer.class);
		customer.setTotalAccountBalance(totalAccountBalance);
mongoTemplate.save(customer);
return customer;
	}

	/*@Override
	public void findByAccountNumber(long accountNumber, BigDecimal totalAccountBalance) {
		// TODO Auto-generated method stub
		Customer customer = mongoTemplate.findOne(Query.query(Criteria.where("accountNumber").is(accountNumber)),
				  Customer.class);
		customer.setTotalAccountBalance(totalAccountBalance);
mongoTemplate.save(customer);
		
	}*/
  
	/*public void findByAccountNumber(long accountNumber, BigDecimal totalAccountBalance) {
		// TODO Auto-generated method stub
		
		Customer customer = mongoTemplate.findOne(Query.query(Criteria.where("accountNumber").is(accountNumber)),
												  Customer.class);
		customer.setTotalAccountBalance(totalAccountBalance);
		mongoTemplate.save(customer);
		
		
	  
		 
	}
*/
	

}
