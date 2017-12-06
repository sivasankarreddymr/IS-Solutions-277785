package com.bms.test;

import com.bms.bd.UserRegistrationBD;
import com.bms.dao.BMSDAOException;
import com.bms.model.Customer;

public class MongoTest {
 public static void main(String[] args) throws BMSDAOException {
	
	 Customer customer = new Customer();
	 customer.setName("test");
	 customer.setUsername("testuser");
	 UserRegistrationBD userRegistrationBD =  new UserRegistrationBD();
		int status = userRegistrationBD.insertNewUserDetails(customer);
}
}
