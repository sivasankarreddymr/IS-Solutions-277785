package com.bms.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bms.constants.BMSConstants;
import com.bms.repository.CustomerRespository;
import com.bms.vo.Customer;
import com.bms.vo.User;

@Service
public class CustomerService {

	@Autowired
	CustomerRespository customerRepository;

	public Customer registerCustomer(Customer customer) {
		customer.setAccountNumber(generateUniqueAccNumber());
		customer.setCustomerId(generateUniqueCustomerId());
		customer.setTotalAccountBalance(customer.getDepositAmount());
		customerRepository.insert(customer);
		customer.setResultMessage(BMSConstants.REGISTRATION_SUCC_MSG+ customer.getCustomerId());
		return customer;

	}

	private long generateUniqueAccNumber() {
		long uniqueAccountNumber = (long) (Math.random() * 10000000000000000L);
		return uniqueAccountNumber;
	}

	private String generateUniqueCustomerId() {
		Random random = new Random();
		String uniqueCustomerId = "R-" + random.nextInt(900);
		return uniqueCustomerId;
	}

	public Customer authenticateUser(User user) {
		Customer customer = customerRepository.findByUsername(user
				.getUsername());
		if (customer.getPassword() != null
				&& customer.getPassword().equals(user.getPassword())) {
			return customer;
		} else {
			return null;
		}
	}

}
