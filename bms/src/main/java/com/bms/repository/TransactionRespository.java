package com.bms.repository;

import java.util.List;

import org.springframework.data.annotation.Persistent;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.bms.vo.Transaction;

@Persistent
public interface TransactionRespository extends MongoRepository<Transaction, String>, TransactionRepositoryCustom {

	public <S extends Transaction> List<S> save(Iterable<S> entites);

	public List<Transaction> findAll();

	public List<Transaction> findAll(Sort sort);

	public <S extends Transaction> S insert(S entity);

	public <S extends Transaction> List<S> insert(Iterable<S> entities);

	public <S extends Transaction> List<S> findAll(Example<S> example);

	public <S extends Transaction> List<S> findAll(Example<S> example, Sort sort);

	public Page<Transaction> findAll(Pageable pageable);

	public <S extends Transaction> S save(S entity);

	public Transaction findOne(String id);

	public boolean exists(String id);

	public Iterable<Transaction> findAll(Iterable<String> ids);

	public long count();

	public void delete(String id);

	public void delete(Transaction entity);

	public void delete(Iterable<? extends Transaction> entities);

	public void deleteAll();

	public <S extends Transaction> S findOne(Example<S> example);

	public <S extends Transaction> Page<S> findAll(Example<S> example,
			Pageable pageable);

	public <S extends Transaction> long count(Example<S> example);

	public <S extends Transaction> boolean exists(Example<S> example);

	/*
	 * public Transaction findByFirstName(String firstName) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * 
	 * public List<Customer> findByLastName(String lastName) { // TODO
	 * Auto-generated method stub return null; }
	 */

}