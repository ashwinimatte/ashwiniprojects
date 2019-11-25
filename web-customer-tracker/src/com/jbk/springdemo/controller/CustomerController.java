 package com.jbk.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jbk.springdemo.dao.CustomerDAO;
import com.jbk.springdemo.entity.Customer;
import com.jbk.springdemo.service.CustomerService;

@Controller
public class CustomerController {
   
	// need to inject the customer DAO
	//@Autowired
	//private CustomerDAO customerDAO;
	
	//need to inject customer service
	@Autowired
	private CustomerService  customerService;
	
	@GetMapping("/")
	public String listCustomers(Model themodel) {
		
		
		//get customers from the service
		List<Customer> theCustomers=customerService.getCustomers();
		
		//add the customer to  the model
		themodel.addAttribute("customers",theCustomers);
		
		
		return "list-customers";
		
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model themodel) {
		
	Customer theCustomer= new Customer();
	
	themodel.addAttribute("customer",theCustomer);
	
		return "customer-form";
	}
	
	
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
		
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/";
		
	}
	@GetMapping("/showFormForUpdate")
    public 	String showFormForUpdate(@RequestParam("customerId") int theId, Model themodel ) {
		
		
		//get the customer from service
		
		Customer thecustomer=customerService.getCustomers(theId);
		
		//set customer as a model attribute to pre-populate the form
		themodel.addAttribute("customer", thecustomer);
		
		//send over to our form
	
		return "customer-form";
		
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		
		customerService.deleteCustomer(theId);
		
		
		return "redirect:/" ;
		
	}
	
	
	
	
	
	
	
	
	
}
