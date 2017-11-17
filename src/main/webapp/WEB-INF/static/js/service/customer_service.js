'use strict';
 
App.factory('CustomerService', ['$http', '$q', function($http, $q){
 
    var REST_SERVICE_URI = 'http://awsbootpocqa-env.us-east-1.elasticbeanstalk.com/sample/customer/';
 
    var factory = {
        fetchAllCustomers: fetchAllCustomers,
        createCustomer: createCustomer,
        updateCustomer:updateCustomer,
        deleteCustomer:deleteCustomer
    };
 
    return factory;
    
  

   
    
 
    function fetchAllCustomers() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Customers');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function createCustomer(customer) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, customer)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Customer');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
 
    function updateCustomer(customer, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, customer)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating customer');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function deleteCustomer(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
   
    function handleError(response, data) {
        if (!angular.isObject(response.data) ||!response.data.message) {
          return ($q.reject("An unknown error occurred."));
        }

        return ($q.reject(response.data.message));
      }

      function handleSuccess(response) {
        return (response);
      }

 
}]);