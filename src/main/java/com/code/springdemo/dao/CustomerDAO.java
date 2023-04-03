package com.code.springdemo.dao;

import java.util.List;

import com.code.springdemo.entity.Customer;
import com.code.springdemo.entity.Review;

public interface CustomerDAO {

	Customer addCustomer(Customer theCustomer);

	List<Customer> getCustomers();

	Customer getLookup(String name);

	String getLookup(int sellerNo);

	void deleteCustomer(String name);
}
