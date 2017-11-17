package com.test.boot.envir.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.boot.envir.dao.CustomerDAO;
import com.test.boot.envir.dao.impl.CustomerDAOImpl;
import com.test.boot.envir.models.Customer;
import com.test.boot.envir.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {


	 CustomerDAO customerDAO=new CustomerDAOImpl();
	
	public Customer findById(int id) {
		// TODO Auto-generated method stub
		return (Customer) customerDAO.findById(id);
	}

	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.saveCustomer(customer);
	}

	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.updateCustomer(customer);
	}

	public void deleteCustomerById(int id) {
		// TODO Auto-generated method stub
		customerDAO.deleteCustomerById(id);
	}

	public List<Customer> findAllCustomers() {
		// TODO Auto-generated method stub
		return customerDAO.findAllCustomers();
	}

	public Customer findCustomerByName(String name) {
		// TODO Auto-generated method stub
		return (Customer) customerDAO.findCustomerByName(name);
	}

}