package com.test.boot.envir.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.util.UriComponentsBuilder;

import com.test.boot.envir.models.Customer;
import com.test.boot.envir.services.CustomerService;





/**
 * @author AL1919
 *
 */


@RestController
@RequestMapping("/sample")
public class AppController {
	
	@Autowired
    CustomerService customerService;


	
    /*
     * This method will list all existing Customers.
     */
	
	@Autowired
	MultipartResolver multipartResolver;
	
	
	 @RequestMapping("/customer")
	    public ResponseEntity<List<Customer>> listAllCustomers() {
	        List<Customer> customers = customerService.findAllCustomers();
	        if(customers.isEmpty()){
	            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	    }
	 
	/* @RequestMapping(value = "/signature/{signImage}", method = RequestMethod.POST)
	  public ResponseEntity<Void> testSignature(@PathVariable("signImage") ByteArrayOutputStream  signImage){
		  System.out.println(" ::: test :: "+signImage);
		  return new ResponseEntity<Void>(HttpStatus.OK);
	  }
	 
	  @RequestMapping(value="/saveSignPdf",method = RequestMethod.POST) 
	 	 @ResponseBody
	 	 public   ResponseEntity<InputStreamResource> saveSignPDF( @RequestParam("file")MultipartFile file) throws MultipartException {
	 		
	 		 System.out.println(" file : "+file);
	 		  if (!file.isEmpty()) {
	                try {
	                    String uploadsDir = "c://";
	                    String realPathtoUploads =  "c://downloadFile//";
	                    if(! new File(realPathtoUploads).exists())
	                    {
	                        new File(realPathtoUploads).mkdir();
	                    }



	                    String orgName = file.getOriginalFilename();
	                    String filePath = realPathtoUploads + orgName;
	                    File dest = new File(filePath);
	                    file.transferTo(dest);
	                } catch (IOException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}
	 		  }
	    	 		 return null;
	 		
	 	    }
	 
	 */
	 
    
   //  * This method will provide the medium to add a new Customer.
     
	 
	 //-------------------Create a Customer--------------------------------------------------------
     
	    @RequestMapping(value = "/customer/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating customer " + customer.getAccOwner());
	  
	  
	        customerService.saveCustomer(customer);
	  
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/customer/{custId}").buildAndExpand(customer.getCustID()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	    
	    //------------------- Update a User --------------------------------------------------------
	      
	    @RequestMapping(value = "/customer/{custID}", method = RequestMethod.PUT)
	    public ResponseEntity<Customer> updateCustomer(@PathVariable("custID") int id, @RequestBody Customer customer) {
	        System.out.println("Updating User " + id);
	          
	        Customer currentCustomer = customerService.findById(id);
	          
	        if (currentCustomer==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	        }
	  
	        currentCustomer.setAccOwner(customer.getAccOwner());
	        currentCustomer.setOrgName(customer.getOrgName());
	        currentCustomer.setBillingCity(customer.getBillingCity());
	        currentCustomer.setBillingCountry(customer.getBillingCountry());
	        currentCustomer.setBillingPin(customer.getBillingPin());
	        currentCustomer.setFeildComment(customer.getFeildComment());
	        currentCustomer.setBillingState(customer.getBillingState());
	        customerService.updateCustomer(currentCustomer);
	        return new ResponseEntity<Customer>(currentCustomer, HttpStatus.OK);
	    }
	  
	  //------------------- Delete a Customer --------------------------------------------------------
	      
	    @RequestMapping(value = "/customer/{custID}", method = RequestMethod.DELETE)
	    public ResponseEntity<Customer> deleteCustomer(@PathVariable("custID") int custID) {
	        System.out.println("Fetching & Deleting Customer with id " + custID);
	  
	        Customer customer = customerService.findById(custID);
	        if (customer == null) {
	            System.out.println("Unable to delete. Customer with id " + custID + " not found");
	            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	        }
	  
	        customerService.deleteCustomerById(custID);
	        return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
	    }
	    
}
