package com.bms.repository;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.bms.vo.Customer;


public class CustomerRepositoryImpl implements CustomerRespository{

	@Override
	public <S extends Customer> List<S> save(Iterable<S> entites) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Customer> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Customer> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Customer> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Customer> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Customer> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Customer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Customer> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Customer> findAll(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findOne(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Customer> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Customer> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Customer> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Customer> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Customer> S findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public Customer findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
