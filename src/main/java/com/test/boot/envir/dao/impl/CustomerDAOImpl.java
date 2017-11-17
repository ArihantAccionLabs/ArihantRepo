package com.test.boot.envir.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.test.boot.envir.dao.CustomerDAO;
import com.test.boot.envir.models.Customer;


public class CustomerDAOImpl implements CustomerDAO{

	
	private static final AtomicLong counter = new AtomicLong();
    
    private static List<Customer> customers;
     
    static{
    	customers= populateDummyUsers();
    }
 
    

	public Customer findById(long id) {

	 int i=0;
	 for(Customer cust:customers) {
		 if(cust.getCustID()==id) {
			 return cust;
		 }
	 }
		return null;
	}

	public void saveCustomer(Customer customer) {
		customers.add(customer);		
	}

	public void updateCustomer(Customer customer) {
		Customer customer1 = findById(customer.getCustID());
		customer1.setAccOwner(customer.getAccOwner());
		customer1.setBillingCity(customer.getBillingCity());
		customer1.setBillingCountry(customer.getBillingCountry());
		customer1.setBillingPin(customer.getBillingPin());
		customer1.setBillingState(customer.getBillingState());
		customer1.setFeildComment(customer.getFeildComment());
		
	}

	public void deleteCustomerById(long id) {
		customers.remove(findById(id));
	}

	public List<Customer> findAllCustomers() {
		return customers;
	}

	public Customer findCustomerByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	 private static List<Customer> populateDummyUsers(){
	        List<Customer> users = new ArrayList<Customer>();
	        users.add(new Customer(counter.incrementAndGet(),"Arihant", "arihant@abc.com", "This is test",1,"Bang","111","KA","IN"));
	        users.add(new Customer(counter.incrementAndGet(),"Kala", "Kala@abc.com", "This is test two",2,"Bang","222","KA","IN"));
	        return users;
	    }

	
}
