'use strict';
 
//angular.module('app', ['signature']);
var App = angular.module('myApp',['ui.bootstrap','ngMaterial']);

App.directive("fileinput", [function() {
    return {
      scope: {
        fileinput: "=",
        filepreview: "="
      },
      link: function(scope, element, attributes) {
        element.bind("change", function(changeEvent) {
          scope.fileinput = changeEvent.target.files[0];
          var reader = new FileReader();
          reader.onload = function(loadEvent) {
            scope.$apply(function() {
              scope.filepreview = loadEvent.target.result;
            });
          }
          reader.readAsDataURL(scope.fileinput);
        });
      }
    }
  }]);

App.directive('exportToPdf', function(){
    
    return {
        restrict: 'E',
        scope: {
        		elemId: '@'
        },
        template: '<button data-ng-click="exportToPdf()">Export to PDF</button>',
        link: function(scope, elem, attr){

           scope.exportToPdf = function() {
           
               var doc = new jsPDF();
               
               console.log('elemId 12312321', scope.elemId);
                        
               doc.fromHTML(
               document.getElementById(scope.elemId).innerHTML, 15, 15, {
	                     'width': 170
               });
               
               doc.save('a4.pdf')
                
            }
        }                   
    }
 
 });    


App.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            
            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);

