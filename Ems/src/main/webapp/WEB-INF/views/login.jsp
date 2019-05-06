<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/jquery.validate.min.js" ></script>
<script src="js/jquery-3.1.1.js"></script>
<%@include file="header.jsp" %>
<title>Login</title>
<style type="text/css">

html { height: 100% }
::-moz-selection { background: #fe57a1; color: #fff; text-shadow: none; }
::selection { background: #fe57a1; color: #fff; text-shadow: none; }
body { background-image: radial-gradient( cover, rgba(92,100,111,1) 0%,rgba(31,35,40,1) 100%), url('http://i.minus.com/io97fW9I0NqJq.png') }
.login {
  background: #eceeee;
  border: 1px solid #42464b;
  border-radius: 6px;
  height: 257px;
  margin: 20px auto 0;
  width: 500px;
}
.login h1 {
  background-image: linear-gradient(top, #f1f3f3, #d4dae0);
  border-bottom: 1px solid #a6abaf;
  border-radius: 6px 6px 0 0;
  box-sizing: border-box;
  color: #727678;
  display: block;
  height: 43px;
  font: 600 14px/1 'Open Sans', sans-serif;
  padding-top: 14px;
  margin: 0;
  text-align: center;
  text-shadow: 0 -1px 0 rgba(0,0,0,0.2), 0 1px 0 #fff;
}
input[type="password"], input[type="text"],select{
  background: url('http://i.minus.com/ibhqW9Buanohx2.png') center left no-repeat, linear-gradient(top, #d6d7d7, #dee0e0);
  border: 1px solid #a1a3a3;
  border-radius: 4px;
  box-shadow: 0 1px #fff;
  box-sizing: border-box;
  color: #696969;
  height: 39px;
  margin: 31px 0 0 29px;
  padding-left: 37px;
  transition: box-shadow 0.3s;
  width: 240px;
}
input[type="password"]:focus, input[type="text"]:focus {
  box-shadow: 0 0 4px 1px rgba(55, 166, 155, 0.3);
  outline: 0;
}
.show-password {
  display: block;
  height: 16px;
  margin: 26px 0 0 28px;
  width: 87px;
}
input[type="checkbox"] {
  cursor: pointer;
  height: 16px;
  opacity: 0;
  position: relative;
  width: 64px;
}
input[type="checkbox"]:checked {
  left: 29px;
  width: 58px;
}
.toggle {
  background: url(http://i.minus.com/ibitS19pe8PVX6.png) no-repeat;
  display: block;
  height: 16px;
  margin-top: -20px;
  width: 87px;
  z-index: -1;
}
input[type="checkbox"]:checked + .toggle { background-position: 0 -16px }
.forgot {
  color: #7f7f7f;
  display: inline-block;
  float: right;
  font: 12px/1 sans-serif;
  left: -19px;
  position: relative;
  text-decoration: none;
  top: 5px;
  transition: color .4s;
}
.forgot:hover { color: #3b3b3b }
input[type="submit"] {
  width:240px;
  height:35px;
  display:block;
  font-family:Arial, "Helvetica", sans-serif;
  font-size:16px;
  font-weight:bold;
  color:#fff;
  text-decoration:none;
  text-transform:uppercase;
  text-align:center;
  text-shadow:1px 1px 0px #37a69b;
  padding-top:6px;
  margin: 29px 0 0 29px;
  position:relative;
  cursor:pointer;
  border: none;  
  background-color: #37a69b;
  background-image: linear-gradient(top,#3db0a6,#3111);
  border-top-left-radius: 5px;
  border-top-right-radius: 5px;
  border-bottom-right-radius: 5px;
  border-bottom-left-radius:5px;
  box-shadow: inset 0px 1px 0px #2ab7ec, 0px 5px 0px 0px #497a78, 0px 10px 5px #999;
}

.shadow {
  background: #000;
  border-radius: 12px 12px 4px 4px;
  box-shadow: 0 0 20px 10px #000;
  height: 12px;
  margin: 30px auto;
  opacity: 0.2;
  width: 270px;
}

input[type="submit"]:active {
  top:3px;
  box-shadow: inset 0px 1px 0px #2ab7ec, 0px 2px 0px 0px #31524d, 0px 5px 3px #999;
}
</style>
</head>
<body >
 	<center> <br /><h1><font color="#002080">Employee Management System</font></h1> <br />
 		<!-- <h4><div style="color: darkblue">Please enter your username and password to login !</div></h4> -->
		<br />
			<div style="color: red">${error}</div>
			<div style="color: red">${logout}</div> 
		 <form:form method="post" action="loginAuthantication" modelAttribute="employeePersonalDetails" id="loginForm" onsubmit="return validation()">
				
				<div class="login"><br></br>
				<b><font style="color: darkblue">Please enter your username and password to login !</font></b>
    				<input type="text" name="username" id="usernameId" placeholder="Username" class="required"/>
    				<font color="red"><span id="user"></span> </font>  
  					<input type="password" name="password" id="passwordId" placeholder="Password" class="required"/>
  					<font color="red"><span id="pass"></span></font> 
<!--   					<select name="role" id="roleId">
  						<option value="" label="---Select role---" />	
	  					<option value="User" label="User" />
	  					<option value="Admin" label="Admin" />
  					</select> -->
  					<font color="red"><span id="rol"></span></font>
  					<!-- <a href="#" class="forgot">forgot password?</a> -->
 					<input type="submit" value="Sign In">
					</div> <div class="shadow"></div>
			</form:form>
	</center>
	
<script type="text/javascript">
	
	function validation() {
	   
		var username = $("#usernameId").val();
	    if (username == "") {
	        alert("Username must be filled out.");
	       // $("#user").text("Username must be filled out."); 
	        return false;
	    }
	    
	    var pass = $("#passwordId").val();
	    if(pass == ""){
	    	alert("Password must be field out.");
	    	return false;
	    }
/* 	    
	    var rol = $("#roleIdId").val();
	    if(rol == ""){
	    	alert("Please select role.");
	    	return false;
	    } */
	}
</script>

</body>
</html>