<%@include file="header.jsp" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User details</title>
<style type="text/css">
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
    background-color: #f1f1c1;
    font-family: sans-serif;
    font-size: 12;
}
			th{
			    padding: 2px;
			    color:#805500; 
			}
			td {
			    padding: 2px;
			    color:#005580; 
			}

</style>
</head>
<body>
<div align="right"><a href="userHome">Back</a> | <font color="green">Welcome : ${name} </font> | <font><a href="logout">logout</a></font></div>
<center>
<h3><font color="#002080">User Personal Details</font></h3>
	<table border="1">
			<th>Sr.No</th>
			<th>Emp Code</th>
			<th>Name</th>
			<th>Email</th>
			<th>Address</th>
			<th>Telephone</th>
			<th>Gender</th>
			<th>Dob</th>
			<th>Doj</th>
			<th>Acc No.</th>
			<th>Aadhar Card</th>
			<th>Pan Card</th>
			<th>Grade</th>
			<th>Emp Type</th>
			<th>Designation</th>
			<th>Department</th>
			<th>Location</th>
			<th>Password</th>
			<th>Action</th>
			<c:forEach var="employee" items="${employeePersonalDetails}" varStatus="idx">
				<tr>
					<td>${idx.index + 1}</td>
					<td align="center"><a href="employeeProfile?empPkId=${employee.empPkId}"><b>${employee.username}</b></a></td>
					<td>${employee.firstname} ${employee.lastname} </td>
					<td>${employee.email}</td>
					<td>${employee.address}</td>
					<td>${employee.telephone}</td>
					<td>${employee.genderFkId.constantValue}</td>
					<td>${employee.dob}</td>
					<td>${employee.doj}</td>
					<td>${employee.accNo}</td>
					<td>${employee.aadharCardNo}</td>
					<td>${employee.panCardNo}</td>
					<td>${employee.empGradeFkId.constantValue}</td>
					<td>${employee.empTypeFkId.constantValue}</td>
					<td>${employee.designationFkId.designationName}</td>
					<td>${employee.departmentFkId.departmentName}</td>
					<td>${employee.locationFkId.locationName}</td>
					<td>${employee.password}</td>
					<td><a href="createPdf?empPkId=${employee.empPkId}">Generate PDF</a> | 
					<a href="/pdf/profile_${employee.username}.pdf">Open PDF</a></td>
				</tr>
			</c:forEach>
		</table>
	<br></br>
<font color="Green"><b><i>${createPDF}</i></b></font> 
	</center>
</body>
</html>