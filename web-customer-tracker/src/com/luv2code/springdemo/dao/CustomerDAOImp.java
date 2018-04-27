package com.luv2code.springdemo.dao;

import java.util.List;

import javax.persistence.Column;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;
@Repository
public class CustomerDAOImp implements CustomerDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	
	public List<Customer> getCustomers() {
		// Get the Current hibernate Session
		Session currentSession = sessionFactory.getCurrentSession();
		//Create Querry
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName",Customer.class);
		//Excute querry and get result list
		List<Customer> customers = theQuery.getResultList();
		//return the results
		
		return customers;
	}

}
