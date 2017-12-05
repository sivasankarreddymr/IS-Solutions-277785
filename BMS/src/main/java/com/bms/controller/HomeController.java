package com.bms.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bms.model.Customer;

@RestController
public class HomeController {


	@RequestMapping(value="/home", method=RequestMethod.GET)
	public ModelAndView home() {
		
		ModelAndView mav = new ModelAndView("register");
		return mav;
	}
	
	
	@RequestMapping(value="/userregistration",headers="Accept=application/json")
	@ResponseBody
	public String register(@Valid @RequestBody Customer customer, BindingResult result, Model model) {
		System.out.println("in");
		if (result.hasErrors()) {
	        List<String> errors = result.getAllErrors().stream()
	          .map(DefaultMessageSourceResolvable::getDefaultMessage)
	          .collect(Collectors.toList());
	        return "error";
	    } else {
	    	System.out.println("Username is ::"+customer.getUsername());	
	            System.out.println("Validatino Success");
	            
	            return "register";
	        }
	    
		
		
		
			
		}
}
