package com.bms;


import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.WebApplicationContext;

import com.bms.controller.CustomerController;
import com.bms.service.CustomerService;
import com.bms.service.TransactionService;
import com.bms.vo.Customer;
import com.bms.vo.Request;
import com.bms.vo.Response;
import com.bms.vo.Statement;
import com.bms.vo.Transaction;
import com.bms.vo.User;

public class TestBmsApp extends BmsApplicationTest{
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@InjectMocks
    private CustomerController customCont;
	@Mock
    public User user;
	
	@Mock
    public Customer customer;
	
	@Mock
	public Request request;
	
	@Mock
	public Transaction transaction;
	
	@Mock
	BindingResult bindingResult;
	
	@Mock
    public CustomerService customerService;
	
	@Mock
	public TransactionService transactionService;
	 
	

	private MockMvc mockMvc;
	

	@Before
	public void setup() {
		//mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		MockitoAnnotations.initMocks(this);
		user.setUsername("yasin");
		user.setPassword("123");
		
       
	}

	@Test
	public void testCustomer(){
	
		user.setUsername("yasin");
		user.setPassword("123");
		Customer customer1 = new Customer();
		customer1.setAccountNumber(123);
		Mockito.when(customerService.authenticateUser(Mockito.any())).thenReturn(customer1);
		Response res= customCont.login(user);
		assertNotNull(res);
		
	}
	
	@Test
	public void testRegister() {
		customer.setAccountNumber(123);
		bindingResult.addError(new ObjectError("test","test1"));
		Mockito.when(customerService.authenticateUser(Mockito.any())).thenReturn(customer);
		//Mockito.when(transactionService.insertTransactionDetails(Mockito.any()).doNothing();//thenReturn(customer);
		Mockito.doNothing().when(transactionService).insertTransactionDetails(Mockito.any());
		Response res= customCont.registerUser(customer, bindingResult);
		assertNotNull(res);
		
	}
	
	@Test
	public void testTransaction() {
		Mockito.doNothing().when(transactionService).saveTransaction(Mockito.any());
		Response res= customCont.saveTransaction(transaction);
		assertNotNull(res);
		
	}
	
	@Test
	public void testStatements() {
		customer.setAccountNumber(123);
		bindingResult.addError(new ObjectError("test","test1"));
		List<Statement> list= new ArrayList<Statement>();
		Mockito.when(transactionService.viewStatement(Mockito.any())).thenReturn(list);
		Response res= customCont.viewStatements(request);
		assertNotNull(res);
		
	}
}
