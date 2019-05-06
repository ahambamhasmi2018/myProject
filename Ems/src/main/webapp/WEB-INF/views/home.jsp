<%@include file="header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Management System</title>

<style>
table, td, th {
    border: 1px solid black;
}

table {
    border-collapse: collapse;
}

th  {
    	text-align: center;
	}

</style>
</head>

<body leftmargin="10%" rightmargin="10%">
	 <div align="right"><a href="logout">logout</a> | <a href="userHome">My profile</a></a> | <font color="green">Welcome  : ${name}</font></div>
	<div align="center">
		<h1><font color="#002080">Employee Management System</font></h1>
		<br></br>
		 <div align="left">
		 	<a href="newEmployee"><h3> Add New Employee </h3></a>
		 </div><div align="left">
			 <a href="empPersonalDetails"><h3>Employee List </h3></a>
		 </div><div align="left"> 
			 <a href="empSalaryDetails"><h3> Salary Management </h3></a>
		</div><div align="left">
		 	<a href="empLeaves"><h3> Leaves Management</h3> </a>
	</div>
	
</body>
</html>