package com.bms.repository;

import java.math.BigDecimal;

import com.bms.vo.Customer;

public interface CustomerRepositoryCustom {

	Customer findByAccountNumber(long accountNumber);
	Customer findByAccountNumber(long accountNumber,BigDecimal totalAccountBalance);
	Customer findByUsername(String username);
}
