package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
@Service
public class CustomerServiceImp implements CustomerService {
	// Need to inject cstomer DAO
	@Autowired
	private CustomerDAO customerDAO;
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();
	}
	@Override
	@Transactional
	public void saveCustomer(Customer thecustomer) {
		// 
		customerDAO.saveCustomer(thecustomer);
	}
	@Override
	@Transactional
	public Customer getCustomer(int theID) {
		return customerDAO.getCustomer(theID);
	}
	@Override
	@Transactional
	public void deleteCustomer(int theID) {
		 customerDAO.deleteCustomer(theID);
	}
	@Override
	@Transactional
	public List<Customer>  searchcustomer(String customername) {
		// get customer from cusotmerDoaa
		return customerDAO.searchcustomer(customername);
	}

}
