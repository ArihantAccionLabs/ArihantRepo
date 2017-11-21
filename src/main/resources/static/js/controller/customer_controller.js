'use strict';
angular.module('app', ['ui.bootstrap','ngMaterial']);
App.controller('CustomerController', ['$scope','CustomerService', function($scope,CustomerService) {
	$scope.showModal = false;
	var self = this;
	  var checkQues=[];
    self.customer={custID:null,orgName:'',accOwner:'',feildComment:'',billingCity:'',billingPin:'',billingCountry:'',billingState:''};
    self.customers=[];
  
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
   
    self.fetchAllCustomers = fetchAllCustomers;
    
    fetchAllCustomers();
   
    function createCORSRequest(method, url) {
    	  var xhr = new XMLHttpRequest();
    	  if ("withCredentials" in xhr) {

    	    // Check if the XMLHttpRequest object has a "withCredentials" property.
    	    // "withCredentials" only exists on XMLHTTPRequest2 objects.
    	    xhr.open(method, url, true);

    	  } else if (typeof XDomainRequest != "undefined") {

    	    // Otherwise, check if XDomainRequest.
    	    // XDomainRequest only exists in IE, and is IE's way of making CORS requests.
    	    xhr = new XDomainRequest();
    	    xhr.open(method, url);

    	  } else {

    	    // Otherwise, CORS is not supported by the browser.
    	    xhr = null;

    	  }
    	  return xhr;
    	}

    	var xhr = createCORSRequest('GET', 'http://localhost:5000/sample/customer/');
    	if (!xhr) {
    	  throw new Error('CORS not supported');
    	}
    	
    function remove(id){
        console.log('id to be deleted', id);
        if(self.customer.custID === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteCustomer(id);
    }
    
    $scope.boundingBox = {
            width: 500,
            height: 300
        };
    

    
    function fetchAllCustomers(){
    	CustomerService.fetchAllCustomers()
            .then(
            function(d) {
                self.customers = d;
            },
            function(errResponse){
                console.error('Error while fetching Customers');
            }
        );
    }
 
    
    
    function createCustomer(customer){
    	CustomerService.createCustomer(customer)
            .then(
            fetchAllCustomers,
            function(errResponse){
                console.error('Error while creating Customer');
            }
        );
    }
 
    function updateCustomer(customer, id){
    	CustomerService.updateCustomer(customer, id)
            .then(
            fetchAllCustomers,
            function(errResponse){
                console.error('Error while updating Customer');
            }
        );
    }
 
    function deleteCustomer(id){
    	CustomerService.deleteCustomer(id)
            .then(
            fetchAllCustomers,
            function(errResponse){
                console.error('Error while deleting Customer');
            }
        );
    }
 
    function submit() {
        if(self.customer.custID===null){
            console.log('Saving New Customer', self.customer);
            createCustomer(self.customer);
        }else{
            updateCustomer(self.customer, self.customer.custID);
            console.log('Customer updated with id ', self.customer.custID);
        }
        reset();
    }
 
    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.customers.length; i++){
            if(self.customers[i].custID === id) {
                self.customer = angular.copy(self.customers[i]);
                break;
            }
        }
    }
 
  

    function reset(){
        self.customer={custID:null,orgName:'',accOwner:'',feildComment:'',billingCity:'',billingPin:'',billingCountry:'',billingState:''};
        $scope.myForm.$setPristine(); //reset Form
    }
    
  
  
 
}]);