package com.bms.repository;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.bms.vo.Transaction;



@Persistent
public interface TransactionRespository extends MongoRepository<Transaction,String>,CrudRepository<Transaction, String>{
	

}