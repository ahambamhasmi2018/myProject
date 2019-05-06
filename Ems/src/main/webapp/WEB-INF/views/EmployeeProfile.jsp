<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Profile</title>

<style>
#profile {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 60%;
}

#profile tr:nth-child(even){background-color: #f2f2f2;}

#profile tr:hover {background-color: #ddd;}

#profile th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #4CAF50;
    color: white;
}

a:link {
  color: red;
}

/* visited link */
a:visited {
  color: green;
}

/* mouse over link */
a:hover {
  color: #FF6600;
}

/* selected link */
a:active {
  color: blue;
}
</style>
</head>
<body marginwidth="10%">
<div align="right"><c:if test="${role eq 'User'}">
					<a href="userHome">Back</a>
			</c:if>
			<c:if test="${role eq 'Admin'}">
					<a href="home">Back</a>
			</c:if>
			 | <font color="green">  Welcome : ${name} </font>| <a href="logout">logout</a></font></div>
<br></be>
		<center><h3><font color="#002080">Employee Profile</font></h3>
					<br></be><br></be><br></be> 
	<table width="42%" id="profile"> 
	<b><font color="#FF0000">${msg}</font></b>
		<c:if test="${size != 0}">
		<c:forEach items="${employeeByEmpCode}" var="employeePersonalDetails"> 
			<tr>
				<td> Employee Code </td><td> <b>${employeePersonalDetails.username}</b></td>
			</tr>
			<tr>
				<td> Name </td><td> ${employeePersonalDetails.firstname}   ${employeePersonalDetails.lastname}</td>
			</tr>
			<tr>
				<td> Gender </td><td> ${employeePersonalDetails.genderFkId.constantValue}</td>
			</tr>
			<tr>
				<td> Email </td><td> ${employeePersonalDetails.email}</td>
			</tr>
			<tr>
				<td> Address </td><td> ${employeePersonalDetails.address}</td>
			</tr>
			<tr>
				<td> Date of birth </td><td> ${employeePersonalDetails.dob}</td>
			</tr>
			<tr>
				<td> Date of joining </td><td> ${employeePersonalDetails.doj}</td>
			</tr>
			<tr>
				<td> Designation </td><td> ${employeePersonalDetails.designationFkId.designationName}</td>
			</tr>
			<tr>
				<td> Department </td><td> ${employeePersonalDetails.departmentFkId.departmentName}</td>
			</tr>
			<tr>
				<td> Location </td><td> ${employeePersonalDetails.locationFkId.locationName}</td>
			</tr>
			<tr>
				<td> Hod Name  </td><td> ${employeePersonalDetails.hodName}</td>
			</tr>
			<tr>
				<td> Account No </td><td> ${employeePersonalDetails.accNo}</td>
			</tr>
			<tr>
				<td> Contact No  </td><td> ${employeePersonalDetails.telephone}</td>
			</tr>
			<tr>
				<td> Employee Type  </td><td> ${employeePersonalDetails.empTypeFkId.constantValue}</td>
			</tr>
			<tr>
				<td> Grade </td><td> ${employeePersonalDetails.empGradeFkId.constantValue}</td>
			</tr>
			<tr>
				<td> Aadhar Card No  </td><td> ${employeePersonalDetails.aadharCardNo}</td>
			</tr>
			<tr>
				<td> Pan Card  </td><td> ${employeePersonalDetails.panCardNo}</td>
			</tr>
				</c:forEach>
			</c:if>
		<c:if test="${size == null}">

			<tr>
				<td> Employee Code </td><td> <b>${employeePersonalDetails.username}</b></td>
			</tr>
			<tr>
				<td> Name </td><td> ${employeePersonalDetails.firstname}   ${employeePersonalDetails.lastname}</td>
			</tr>
			<tr>
				<td> Gender </td><td> ${employeePersonalDetails.genderFkId.constantValue}</td>
			</tr>
			<tr>
				<td> Email </td><td> ${employeePersonalDetails.email}</td>
			</tr>
			<tr>
				<td> Address </td><td> ${employeePersonalDetails.address}</td>
			</tr>
			<tr>
				<td> Date of birth </td><td> ${employeePersonalDetails.dob}</td>
			</tr>
			<tr>
				<td> Date of joining </td><td> ${employeePersonalDetails.doj}</td>
			</tr>
			<tr>
				<td> Designation </td><td> ${employeePersonalDetails.designationFkId.designationName}</td>
			</tr>
			<tr>
				<td> Department </td><td> ${employeePersonalDetails.departmentFkId.departmentName}</td>
			</tr>
			<tr>
				<td> Location </td><td> ${employeePersonalDetails.locationFkId.locationName}</td>
			</tr>
			<tr>
				<td> Hod Name  </td><td> ${employeePersonalDetails.hodName}</td>
			</tr>
			<tr>
				<td> Account No </td><td> ${employeePersonalDetails.accNo}</td>
			</tr>
			<tr>
				<td> Contact No  </td><td> ${employeePersonalDetails.telephone}</td>
			</tr>
			<tr>
				<td> Employee Type  </td><td> ${employeePersonalDetails.empTypeFkId.constantValue}</td>
			</tr>
			<tr>
				<td> Grade </td><td> ${employeePersonalDetails.empGradeFkId.constantValue}</td>
			</tr>
			<tr>
				<td> Aadhar Card No  </td><td> ${employeePersonalDetails.aadharCardNo}</td>
			</tr>
			<tr>
				<td> Pan Card  </td><td> ${employeePersonalDetails.panCardNo}</td>
			</tr>
			</c:if>
	</table>
	</center>
</body>
</html>