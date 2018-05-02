package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerDAO {
	public List<Customer>  getCustomers();

	public void saveCustomer(Customer thecustomer);

	public Customer getCustomer(int theID);
	public void deleteCustomer(int theId);

	public List<Customer> searchcustomer(String customername);
}
