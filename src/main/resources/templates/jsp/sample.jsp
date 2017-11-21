<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.springframework.org/schema/mvc">
  <head>  
    <title>AngularJS $http Example</title>  
    <style>
      .username.ng-valid {
          background-color: lightgreen;
      }
      .username.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .username.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }
 
      .email.ng-valid {
          background-color: lightgreen;
      }
      .email.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .email.ng-dirty.ng-invalid-email {
          background-color: yellow;
      }
    </style>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"></link>
     <link th:href="@{/css/app.css}" rel="stylesheet"></link>
     

      <script  type="text/javascript" th:src="@{/js/angular/angular.1.4.4.js}" />   
         <script  type="text/javascript"  th:src="@{/js/angular/angular-aria-1.3.15.js}" />
               
       <script  type="text/javascript"  th:src="@{/js/angular/angular-animate-1.4.6.js}" />

     <script  type="text/javascript"  th:src="@{/js/script-js/ui-bootstrap-tpls-0.14.0.js}" />
        <script  type="text/javascript"  th:src="@{/js/angular/angular-material.min-1.1.0.js}" />
      <script  type="text/javascript"  th:src="@{/js/app.js}"/>
      <script  type="text/javascript" th:src="@{/js/service/customer_service.js}" />
      <script  type="text/javascript"  th:src="@{/js/controller/customer_controller.js}" />
      
  </head>
  
  <body ng-app="myApp" class="ng-cloak" ng-controller="CustomerController as ctrl">
    <div class="generic-container">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Customer Registration Form </span></div>
              <div class="formcontainer">
                   <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.customer.custId" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" style="margin-left:80px;" for="uname">Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.customer.accOwner" id="accOwner" class="accOwner form-control input-sm" placeholder="Enter Account Owner Name" ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.accOwner.$error.required">This is a required field</span>
                                      <span ng-show="myForm.accOwner.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.accOwner.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" style="margin-left:80px;" for="orgName">Org Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.customer.orgName" id="orgName" class="form-control input-sm" placeholder="Enter your Organization."/>
                              </div>
                          </div>
                      </div>
 
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" style="margin-left:80px;" for="feildComment">Comment : </label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.customer.feildComment" id="feildComment" class="form-control input-sm" placeholder="Enter your Comment"/>
                              </div>
                          </div>
                      </div>
                      
                      
                        <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" style="margin-left:80px;" for="billingPin">Billing Pin</label>
                              <div class="col-md-7">
                                  <input type="password" ng-model="ctrl.customer.billingPin" id="billingPin" class="form-control input-sm" placeholder="Enter your Billing Pin."/>
                              </div>
                          </div>
                      </div>
                      
                       <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" style="margin-left:80px;" for="billingCity">City</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.customer.billingCity" id="billingCity" class="form-control input-sm" placeholder="Enter your City."/>
                              </div>
                          </div>
                      </div>
                      
                       <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" style="margin-left:80px;" for="billingState">State</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.customer.billingState" id="billingState" class="form-control input-sm" placeholder="Enter your State."/>
                              </div>
                          </div>
                      </div>
                      
  					 <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" style="margin-left:80px;" for="billingCountry">Country</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.customer.billingCountry" id="billingCountry" class="form-control input-sm" placeholder="Enter your Country."/>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-actions floatRight" style="float: left;margin-left: 390px;">
                              <input type="submit"  value="{{!ctrl.customer.custID ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" style="background-color:#040404; border-color: #efece7;width: 80px;" ng-disabled="myForm.$pristine"/>
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" style="background-color:#040404; border-color: #efece7;" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Users </span></div>
              <div class="tablecontainer">
                  <table  id="table" class="table table-hover" >
                      <thead>
                          <tr>
                              <th>ID</th>
                              <th>Owner Name</th>
                              <th>Organization Name</th>
                              <th>Comment</th>
                               <th>Pin</th>
                              <th>City</th>
                              <th>State</th>
                              <th>Country</th>
                              <th width="27%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="c in ctrl.customers">
                              <td><span ng-bind="c.custID"></span></td>
                              <td><span ng-bind="c.accOwner"></span></td>
                              <td><span ng-bind="c.orgName"></span></td>
                              <td><span ng-bind="c.feildComment"></span></td>
                               <td><span ng-bind="c.billingPin"></span></td>
                              <td><span ng-bind="c.billingCity"></span></td>
                              <td><span ng-bind="c.billingState"></span></td>
                              <td><span ng-bind="c.billingCountry"></span></td>
                              
                              <td>
                              <button type="button" ng-click="ctrl.edit(c.custID)" class="btn btn-success custom-width">Edit</button>  
                              <button type="button" ng-click="ctrl.remove(c.custID)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
 </div>
  </body>
</html>