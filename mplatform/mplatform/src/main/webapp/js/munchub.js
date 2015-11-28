var app = angular.module('munchub', ['ngRoute']);
/*app.run(function($rootScope) {
	  $rootScope.appName = "Welcome to Angular JS Application";
	  $rootScope.userName = "Ankur";
	});*/

app.config(function ($routeProvider){
	$routeProvider.when('/',{
		templateUrl : 'html/login.html',
		controller : 'loginController'
	})
	.when('/home',{
		templateUrl : 'html/home.html',
		controller : 'dashboardController'
	})
	.when('/vendor',{
		templateUrl :'html/vendor/vendor.html',
		controller : 'vendorController'
	})
	.when('/listVendor',{
		templateUrl :'html/vendor/listvendors.html',
		controller : 'listVendorController'
	})
	.when('/addVendor',{
		templateUrl :'html/vendor/addvendor.html',
		controller : 'addVendorController'
	})
	.when('/addItem',{
		templateUrl :'html/vendor/addItem.html',
		controller : 'addItemController'
	})
	.otherwise({
		redirectTo:'/'
	});	
}) ;
app.controller('mainController', function($scope){
	$scope.message = "";	
	$scope.userContext = "";
	$scope.setMessage = function(message){
		$scope.message = message;
	};
	$scope.setUserContext = function(userContext){
		$scope.userContext = userContext;
	};
	
});

app.controller('loginController', function($scope,$http, $location) {
	 $scope.loginForm = {
			 userName:"A",
			 password:"Y"
	 };
	 	$scope.loginForm.submitTheForm = function(item, event) {
        var responsePromise = $http.post("/mplatform/login", $scope.loginForm);
        responsePromise.success(function(dataFromServer, status, headers, config) {
           console.log(dataFromServer.userName);
           $scope.setUserContext(dataFromServer.userName);
           $location.path('/home');
        });
         responsePromise.error(function(data, status, headers, config) {
           alert("Submitting form failed!");
        });
       };
	});

app.controller('dashboardController', function($scope,$http,$location){	
	
});

app.controller('vendorController', function($scope){	
	
});

app.controller('listVendorController', function($scope,$http){
	      
        var responsePromise = $http.get("/mplatform/api/vendors", {});
        responsePromise.success(function(dataFromServer, status, headers, config) {
           $scope.vendors = dataFromServer;
        });
         responsePromise.error(function(data, status, headers, config) {
           alert("Submitting form failed!");
        });
     
});
app.controller('addVendorController', function($scope,$http,$location){
	$scope.vendorForm = {
			 name:"",
			 email:"",
			 password:"",
			 businessType:{id:""},
			 description:"",
			 phoneNumber:[],			 
		     address : {street : "", city:"",state:"",country:"",postalCode:"",longitude:"",latitude:""}
	 };
	 	$scope.vendorForm.submitForm = function( item, event) {
	 		
     var responsePromise = $http.post("/mplatform/api/vendors", $scope.vendorForm);
     responsePromise.success(function(dataFromServer, status, headers, config) {
        $location.path('/listVendor');
     });
      responsePromise.error(function(data, status, headers, config) {
        alert("Submitting form failed!");
     });
    }; 
});
app.controller('addItemController', function($scope,$http,$location){
	$scope.itemForm = {
			 name:"",
			 originalPrice:"",
			 discountedPrice:"",
			 itemType:{id:""},
			 offerExpDate:"",
			 vendor :{id:""}
			 
	 };
	 	$scope.itemForm.submitForm = function( item, event) {
	 		
     var responsePromise = $http.post("/mplatform/api/items", $scope.itemForm);
     responsePromise.success(function(dataFromServer, status, headers, config) {
       // $location.path('/listUser');
     });
      responsePromise.error(function(data, status, headers, config) {
        alert("Submitting form failed!");
     });
    }; 
});