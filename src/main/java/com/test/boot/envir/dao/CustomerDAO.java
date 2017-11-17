package com.test.boot.envir.dao;


import java.util.List;


import com.test.boot.envir.models.Customer;

public interface CustomerDAO {
	
	Customer findById(long id);
	 
    void saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    
    void deleteCustomerById(long id);
     
    List<Customer> findAllCustomers();
 
    Customer findCustomerByName(String name);
}
