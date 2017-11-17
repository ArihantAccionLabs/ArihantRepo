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