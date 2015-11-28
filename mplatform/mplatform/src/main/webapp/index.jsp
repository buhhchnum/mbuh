<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" 	href="css/bootstrap.min.css">
        <script src="js/angular/angular.min.js"></script>
		<script src="js/angular/angular-route.min.js"></script>
		<script src="js/jquery/jquery-1.11.3.min.js"></script>
		<script src="js/bootstrap/bootstrap.min.js"></script>	
		<script src="js/munchub.js"></script>      
    </head>
    <body ng-app="munchub">
        <div class="container" ng-controller="mainController">
		<nav class="navbar navbar-default" ng-if='userContext'	>
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">MuncHub</a>
				</div>
		
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" >
					<ul class="nav navbar-nav">
						<li role="presentation" class="active"><a href="#">Home</a></li>
						<li role="presentation"><a href="#vendor">Vendor</a></li>
						<li role="presentation" ng-if='userContext'><a href="#">Logout</a></li>						
					</ul>
				</div>			
			</div><!-- /.navbar-collapse -->	
		</nav><!-- /.container-fluid --> 

		<div class="alert alert-success alert-dismissible" role="alert" ng-if='message'>
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>{{message}}
		</div>
		
		<!-- This tag will load the template html from the routing mechanism -->
		<div ng-view=""></div>
		
	</div>
    </body>
</html>
