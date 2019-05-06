<%@include file="header.jsp" %>
		<link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel = "stylesheet">
		<script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
		<script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Management System</title>
<style type="text/css">
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
    background-color: #f1f1c1;
    font-family: sans-serif;
    font-size: 14;
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
<script type="text/javascript" language = "javascript"> 
$(document).ready(function(){
	$("#empUsernameId").change(function(){
		var empCode = $("#empUsernameId").val();
	      if(empCode != "" && empCode != null){
	    	  $("#tabEmp").hide();
	      }

  		$.ajax({
            url : "./searchEmployee/"+empCode,
            type: "GET",
            contentType: "application/json; charset=utf-8",
            dataType: "json", 
            processData: false,
            success : 
                function(data) {
            	console.log(data);
                    $('#response').html("<table>");
                    $('#response').append("<th>Sr.No</th><th>Name</th><th>Username</th><th>Email</th><th>Address</th><th>Telephone</th><th>Gender</th>");
                    $('#response').append("<th>Dob</th><th>Doj</th><th>Basic Salary</th><th>Acc No.</th><th>Adhar Card</th><th>Pan Card</th>");
                    $('#response').append("<th>Grade</th><th>Emp Type</th><th>Designation</th><th>Department</th><th>Location</th>");
                    $('#response').append("<th>Password</th><th>Role</th>");
                	$.each(data, function(index,data) { 
                		$('#response').append("<tr>");
                		$('#response').append("<td>"+(index+1)+"</td>");
                		$('#response').append("<td>"+(data.firstname +"&nbsp"+ data.lastname)+"</td>");
                		$('#response').append("<td>"+data.username+"</td>");
                		$('#response').append("<td>"+data.email+"</td>");
                		$('#response').append("<td>"+data.address+"</td>");
                		$('#response').append("<td>"+data.telephone+"</td>");
                		$('#response').append("<td>"+data.genderFkId.constantValue+"</td>");
                		$('#response').append("<td>"+data.dob+"</td>");
                		$('#response').append("<td>"+data.doj+"</td>");
                		$('#response').append("<td>"+data.besicSalary+"</td>");
                		$('#response').append("<td>"+data.accNo+"</td>");
                		$('#response').append("<td>"+data.aadharCardNo+"</td>");
                		$('#response').append("<td>"+data.panCardNo+"</td>");
                		$('#response').append("<td>"+data.empGradeFkId.constantValue+"</td>");
                		$('#response').append("<td>"+data.empTypeFkId.constantValue+"</td>");
                		$('#response').append("<td>"+data.designationFkId.designationName+"</td>");
                		$('#response').append("<td>"+data.departmentFkId.departmentName+"</td>");
                		$('#response').append("<td>"+data.locationFkId.locationName+"</td>");
                 		$('#response').append("<td>"+data.password+"</td>");
                 		$('#response').append("<td>"+data.role+"</td>");
                		$('#response').append("</tr>");
                		$('#response').append("</table>");
                	});
                }
    		});
    	});	
	});
</script>
</head>
<body marginwidth="10%">
<a href="home">Back</a> | <font color="green">Welcome : ${name}</font> | <a href="logout">logout</a> </font>
<div align="right">	<%-- 	  <label>Search :</label>   <select id="empUsernameId"> 
			    	<option value="">--- select---</option>
			    	<c:forEach items="${listEmployee}" var="emp">
			    		<option value="${emp.username}">${emp.username}</option>
			       </c:forEach>
			    </select></div> --%>
			    <div> <form action="searchEmployeeProfileById" method="get" modelAttribute="employeePersonalDetails">
			    		<input type="text" name="username" placeholder="Please enter employee code">
			    		&nbsp;<input type="Submit" value="search"/>
			     </form></div>
	<div align="center">
		<font style="color: #002080"><h2>Employee List</h2></font><br></br>
		<table border="1" id="tabEmp"> 
			<th>Sr.No.</th>
			<th>Employee Code</th>
			<th>Name</th>
			<th>Email</th>
			<th>Designation</th>
			<th>Department</th>
			<th>Location</th>
			<th>Action</th>
			<c:forEach var="employee" items="${listEmployee}">
				<tr>
					<td>${employee.empPkId}</td>
					<td>${employee.username}</td>
					<td>${employee.firstname} ${employee.lastname}</td>
					<td>${employee.email}</td>
					<td>${employee.designationFkId.designationName}</td>
					<td>${employee.departmentFkId.departmentName}</td>
					<td>${employee.locationFkId.locationName}</td>
					<td>
						<a href="employeeProfile?empPkId=${employee.empPkId}">Details</a> | 
						<a href="editEmployee?empPkId=${employee.empPkId}">Edit</a> |
						<a href="deleteEmployee?empPkId=${employee.empPkId}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<div id="response"></div>
		<h4><c:if test="${role eq 'Admin'}">
					<font color="red">New Employee Register</font> <a href="newEmployee">here</a>
			</c:if> 
		</h4>
	</div>
  </body>
</html>