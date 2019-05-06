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

th {
    	text-align: center;
	}

</style>
</head>

<body leftmargin="10%" rightmargin="10%">
	<div align="right"><font color="blue"><a href="logout"><b>logout</b></a></font> |<c:if test="${role eq 'Admin'}"> <a href="home"><b>Admin</b></a> | </c:if> <font color="green">Welcome  : ${name}</font></div>
	<div align="center">
	<h1><font color="#002080">Employee Management System</font></h1>
		<%-- <c:if test="${role eq 'Admin'}">
		   		<font color="blue"><a href="admin/home">Admin Details</a></font> |
		 	 </c:if>
		 --%>
		 <br></br>
		 <div align="left">
		 	<a href="userPersonalDetails"><h3>Profile Details </h3></a>
		 </div>
		 <div align="left">
		 	<a href="userSalaryDetails"><h3> Salary Management </h3></a>
		 </div>
		 <div align="left">
			 <a href="userLeaves"><h3>Leaves Management </h3> </a>
		</div>
	</div>
</body>
</html>