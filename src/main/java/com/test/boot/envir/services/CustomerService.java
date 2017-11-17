package com.test.boot.envir.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.boot.envir.models.Customer;

public interface CustomerService {

	Customer findById(int id);
	 
    void saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    
    void deleteCustomerById(int id);
     
    List<Customer> findAllCustomers();
 
    Customer findCustomerByName(String name);
}
