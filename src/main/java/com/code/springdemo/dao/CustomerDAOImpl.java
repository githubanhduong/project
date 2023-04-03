package com.code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.code.springdemo.entity.Customer;
import com.code.springdemo.entity.Review;

@Repository
public class CustomerDAOImpl implements CustomerDAO {


	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomers() {
		Session currentSession = sessionFactory.getCurrentSession();
			Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
			List<Customer> customers = theQuery.getResultList();
			return customers;
	}
	
	@Override
	public Customer addCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theCustomer);
		Query<Customer> theQuery = currentSession.createQuery("from Customer WHERE customerId = :name", Customer.class);
		theQuery.setParameter("name", theCustomer.getCustomerId());
		List<Customer> results = theQuery.getResultList();
		
		return results.get(0);
	}

	@Override
	public Customer getLookup(String name) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> theQuery = currentSession.createQuery("from Customer WHERE customerId = :name", Customer.class);
		theQuery.setParameter("name", name);
		List<Customer> results = theQuery.getResultList();
		
		
		return results.get(0);
	}

	@Override
	public String getLookup(int sellerNo) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer loadCustomer = currentSession.get(Customer.class, sellerNo);
		
		return loadCustomer.getCustomerId();
	}

	@Override
	public void deleteCustomer(String username) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("DELETE FROM Customer WHERE customerId = :name");
		theQuery.setParameter("name",username);
		theQuery.executeUpdate();
		
	}

	

	

	
			
	

	

}











