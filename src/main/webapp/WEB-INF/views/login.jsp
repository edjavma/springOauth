<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

	<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap/css/bootstrap.min.css' />">
	<link rel="stylesheet" href="<c:url value='/resources/css/style-login.css' />">  
	<style type="text/css">
	/*.wrap {
  display: -webkit-box;
  display: -webkit-flex;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-align: center;
  -webkit-align-items: center;
      -ms-flex-align: center;
          align-items: center;
  -webkit-box-pack: center;
  -webkit-justify-content: center;
      -ms-flex-pack: center;
          justify-content: center;
  height: 100vh;
  background: black;
}

.time-to {
  text-align: center;
  font-family: Bangers;
  color: white;
  font-size: 35px;
  letter-spacing: 2px;
}
.time-to span {
  display: block;
  font-size: 80px;
  color: red;
}*/
	</style>
</head>
<body ng-app="umgApp">

 	<div class="container" ng-controller="loginController">
    <div class="row">
        <div class="col-md-12">
            <div class="wrap">
                <p class="form-title">
                    Entrar</p>                 
                <form class="login">
                <span style="color:red" ng-if="message != ''">{{message}}</span>
                <input type="text" placeholder="Username" ng-model="data.username"/>
                <input type="password" placeholder="Password" ng-model="data.password"/>
                <input type="button" ng-click="login()" value="Sign In" class="btn btn-success btn-sm" />
                </form>
            </div>
        </div>
    </div>
</div>

	<script src="<c:url value='/resources/js/jquery/jquery-1.11.1.min.js' />"></script>
    <script src="<c:url value='/resources/css/bootstrap/js/bootstrap.min.js' />"></script>
	    
	<script src="<c:url value='/resources/js/angular/angular.min.js' />"></script>
	<script src="<c:url value='/resources/js/angular/lodash.min.js' />"></script>
	<script src="<c:url value='/resources/js/angular/angular_route.js' />"></script>
	<script src="<c:url value='/resources/js/angular/angular_resource.js' />"></script>
	<script src="<c:url value='/resources/js/angular/angular_cookies.js' />"></script>
	
	<script src="<c:url value='/resources/app/app.js' />"></script>
	<script src="<c:url value='/resources/app/controllers/loginController.js' />"></script>
	<script src="<c:url value='/resources/app/services/loginService.js' />"></script>
	<script src="<c:url value='/resources/app/directives/countdown.js' />"></script>
</body>
</html>