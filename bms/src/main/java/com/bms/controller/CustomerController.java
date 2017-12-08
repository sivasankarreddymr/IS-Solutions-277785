package com.bms.controller;

import java.util.ArrayList;
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

import com.bms.service.CustomerService;
import com.bms.service.TransactionService;
import com.bms.vo.Customer;
import com.bms.vo.Request;
import com.bms.vo.Response;
import com.bms.vo.Statement;
import com.bms.vo.Transaction;
import com.bms.vo.User;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	TransactionService transactionService;

	@RequestMapping("/home")
	public ModelAndView home() {

		ModelAndView model = new ModelAndView("index");
		return model;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Response registerUser(@RequestBody @Valid Customer customer,
			BindingResult bindingResult) {
		Response response = new Response();
		try {
			if(bindingResult.hasErrors()){
				List<ObjectError> errorsList = bindingResult.getAllErrors();
				List<String> errorMessage = new ArrayList<String>();
				for(ObjectError objectError: errorsList){
					String codes[] =objectError.getCodes();
					String field = codes[0].split("\\.")[2];
					errorMessage.add(field+" "+objectError.getDefaultMessage());
				}
				response.setSuccess(false);
				response.setData(errorMessage.toArray());
			
			} else {
				customer = customerService.registerCustomer(customer);
				transactionService.insertTransactionDetails(customer);
				response.setSuccess(true);
				response.setData(customer.getResultMessage());
	
			}
		} catch (Exception ex) {
			response.setSuccess(false);
			response.setData("Registration Failed. Please contact bmssupportteam@cts.com. ");
		}
		return response;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Response login(@RequestBody User user) {
		Response response = new Response();
		try {
			Customer customer = customerService.authenticateUser(user);
			if (customer != null) {
				response.setSuccess(true);
				response.setData(customer);
			} else {
				response.setSuccess(false);
				response.setData("Invalid Credentials");
			}

		} catch (Exception ex) {
			response.setSuccess(false);
			response.setData("Invalid Credentials");
		}
		return response;
	}

	@RequestMapping(value = "/saveTransaction", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Response saveTransaction(@RequestBody Transaction transaction) {
		Response response = new Response();
		try {			
			transactionService.saveTransaction(transaction);
			response.setSuccess(true);
			response.setData(transaction.getResultMessage());
		} catch (Exception ex) {
			response.setSuccess(false);
			response.setData("Transaction Failed. Please contact bmssupportteam@cts.com.");
		}
		return response;
	}

	@RequestMapping(value = "/viewStatements", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Response viewStatements(@RequestBody Request request) {

		Response response = new Response();
		try {
			List<Statement> stmtList = transactionService.viewStatement(request);
			response.setSuccess(true);
			response.setData(stmtList);
		} catch (Exception ex) {
			response.setSuccess(false);
			response.setData("Transaction Failed. Please contact bmssupportteam@cts.com.");
		}
		return response;
	}

}
