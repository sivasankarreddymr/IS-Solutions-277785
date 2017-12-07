package com.bms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bms.dao.BMSDAOException;
import com.bms.repository.CustomerRespository;
import com.bms.repository.TransactionRespository;
import com.bms.service.CustomerService;
import com.bms.service.TransactionService;
import com.bms.vo.Customer;
import com.bms.vo.Response;
import com.bms.vo.Transaction;
import com.bms.vo.User;


@RestController
public class CustomerController {

	 @Autowired
	CustomerRespository customerRepository;
	 @Autowired
	 CustomerService customerService;
	
	 @Autowired
	 TransactionService transactionService;
	 
	 @Autowired
	 TransactionRespository transactionRepository;
	
	@RequestMapping("/home")
	public ModelAndView home(){
		
		ModelAndView model = new ModelAndView("index");
		return model;
	}
	
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String registerUser(@RequestBody @Valid Customer customer, BindingResult bindingResult) throws BMSDAOException{
		 System.out.println("username>>>"+customer.getUsername());
		 /* Response response= new Response();
		if(bindingResult.hasErrors()){
			List<ObjectError> errorsList = bindingResult.getAllErrors();
			response.setSuccess(false);
			response.setData(errorsList);
		}else{
			   customer = customerService.fillCustomerDetails(customer);
			   Transaction transaction = transactionService.fillTransactionDetails(customer);
			   
			   customer = customerRepository.insert(customer);
			   transactionRepository.insert(transaction);
			   
		}*/
		 
		/* List<Customer> customerList = customerRepository.findAll();
		 System.out.println("customerList ::"+customerList);*/
		 Transaction txn = new Transaction();
		
	
		return "register";
	}
	
	

	  @RequestMapping(value="/login", method=RequestMethod.POST, consumes = "application/json")
	  @ResponseBody
	  public Response login(@RequestBody User user ) {
		  Response response= new Response();
		  try{
			System.out.println(customerService+"  login method called" +user.getUsername());
			if(user.getUsername().equals("sathish")){
				String str=null;
				str.toString();
			}
			Customer cust= new Customer();
			cust.setName("Yasin");
			cust.setUsername("yasin");
			cust.setAccountNumber(0001001);
			response.setSuccess(true);
			response.setData(cust);
		  }catch(Exception ex){
				response.setSuccess(false);
				response.setData("Invalid Credentials");
		  }
		  return response;
	  }
	
	  @RequestMapping(value="/saveTransaction", method=RequestMethod.POST, consumes = "application/json")
	  @ResponseBody
	  public Response saveTransaction(@RequestBody Transaction transaction ) {
		  System.out.println(" saveTransaction method called" +transaction.getAccountNumber());
		  Response response= new Response();
		  try{			
			//call next layer method
			  transactionRepository.insert(transaction);
			response.setSuccess(true);
			response.setData(null);
		  }catch(Exception ex){
				response.setSuccess(false);
				response.setData("Transaction Failed. Please contact alpsupportteam@cts.com.");
		  }
		  return response;
	  }
	  
	  @RequestMapping(value="/viewStatements", method=RequestMethod.POST, consumes = "application/json")
	  @ResponseBody
	  public Response viewStatements(@RequestBody Customer customer ) {
		  System.out.println(" viewStatements method called" +customer.getUsername());
		  Response response= new Response();
		  try{			
			//call next layer method
			  //transactionRepository.findAll(Transaction.);
			response.setSuccess(true);
			response.setData(null);
		  }catch(Exception ex){
				response.setSuccess(false);
				response.setData("Transaction Failed. Please contact alpsupportteam@cts.com.");
		  }
		  return response;
	  }
	
	
	
}
