package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	// 	need to inject out customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model themodel) {
		//get the customers from dao
		List<Customer> theCustomers= customerService.getCustomers();
		System.out.println(theCustomers);
		//add the customers to the model
		themodel.addAttribute("customer", theCustomers);
		
		return "list-customers";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create the model attribute to bind form data
		Customer thecustomer = new Customer();
		theModel.addAttribute("customer",thecustomer);
		return "customer-form";
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer thecustomer) {
		//save the customer using the service
		customerService.saveCustomer(thecustomer);
		return "redirect:/customer/list";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,Model theModel) {
		//get the customer from the service
		Customer theCustomer =customerService.getCustomer(theId);
		//set customer as model attribute to pre populate the form
		theModel.addAttribute("customer",theCustomer);
		//send over to form
		return "customer-form";
	}
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId,Model theModel) {
		customerService.deleteCustomer(theId);
		//set customer as model attribute to pre populate the form
		//theModel.addAttribute("customer",theCustomer);
		return "redirect:/customer/list";
	}
	@PostMapping("/search")
	public String SearchCustomer(@RequestParam("customername") String customername ,Model theModel) {
		//get the customer from the service
		List<Customer> theCustomer = customerService.searchcustomer(customername);
		theModel.addAttribute("customer", theCustomer);

			
		return "list-customers";
	}
}
