<%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User salary details</title>
<style type="text/css">
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
    background-color: #f1f1c1;
    font-family: sans-serif;
    font-size: 14;
    width: 70%;
}
			th{
			    padding: 2px;
			    color:#805500; 
			}
			td {
			    padding: 2px;
			    color:#002080;
			    width: 10%;
		}
</style>
</head>
<body marginwidth="10%">
<div align="right"><a href="userHome">Back</a> | <font color="green">Welcome : ${name}</font> | <font><a href="logout">logout</a></font></div>
<center>
<h3><font color="#002080">Your Salary Details</font></h3>
			<table border="1">
			<!-- <th>Sr.No</th> -->
			<th> Emp Id</th>
			<th> CTC </th>
			<th> Basic Salary</th>
			<th> HRA</th>
			<th> PF</th>
			<th> Allowance</th>
			<th> Others</th>
			<th> Salary Date </th>
    <c:forEach var="salary" items="${userSalary}" varStatus="idx">
				<tr>
					<%-- <td >${idx.index + 1}</td> --%>
					<td align="center"><b>${salary.usernameEmp}</b></td>
					<td align="center">${salary.empSalaryYear}</td>
					<td>${salary.besicSalary}</td>
					<td>${salary.empSalaryMonth}</td>
					<td align="center">${salary.pf}</td>
					<td align="center">${salary.allowance}</td>
					<td align="center">${salary.others}</td>
					<td>${salary.salaryDate}</td>
				</tr>
			</c:forEach>
		</table></center>
</body>
</html>