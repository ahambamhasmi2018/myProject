<%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Employee Salary details</title>
		<link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel = "stylesheet">
		<script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
		<script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
		
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
			    align-content: center;
			    align-items: center; 
			}
		</style>
<script type="text/javascript" language = "javascript"> 
$(document).ready(function(){
	$("#empFkId").change(function(){
		var empCode = $("#empFkId").val();
	      if(empCode != "" && empCode != null){
	    	  $("#tabSalary").hide();
	      }
 		$.ajax({
            url : "./searchEmployeeSalary/"+empCode,
            type: "GET",
            contentType: "application/json; charset=utf-8",
            dataType: "json", 
            processData: false,
            success : 
                function(data) {
                    $('#response').html("<table  width='45%'>");
                    $('#response').append("<th>Sr.No.</th><th>Emp Id</th><th>CTC</th><th>Basic Salary</th><th>HRA</th><th>PF</th><th>Allowance</th><th>Others</th><th>Salary Date</th>");
                	$.each(data, function(index,data) { 
                		$('#response').append("<tr>");
                		$('#response').append("<td>"+(index+1)+"</td>");
                		$('#response').append("<td>"+data.usernameEmp+"</td>");
                		$('#response').append("<td>"+data.empSalaryYear+"</td>");
                		$('#response').append("<td>"+data.besicSalary+"</td>");
                   		$('#response').append("<td>"+data.empSalaryMonth+"</td>");
                   		$('#response').append("<td>"+data.pf+"</td>");
                   		$('#response').append("<td>"+data.allowance+"</td>");
                   		$('#response').append("<td>"+data.others+"</td>");
                		$('#response').append("<td>"+data.salaryDate+"</td>");
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
   <a href="home">Back</a> | <font color="Green">Welcome : ${name} </font> | <a href="logout">logout</a>
	  <div align="right">
		  <label>Search :</label>   
				<select id="empFkId"> 
			    	<option value="">--- select---</option>
			    	<c:forEach items="${employees}" var="emp">
			    		<option value="${emp.username}">${emp.username}</option>
			       </c:forEach>
			    </select>
	 </div>
    <div align="center">
        <h3><font color="#002080">Employee Salary</font> </h3>
        <form:form action="saveEmployeeSalary" method="Post" modelAttribute="salaryDetails" onsubmit="return validation()">
        <table>
       <%--   <form:hidden path="salaryPkId"/> --%>
            <tr>
                <td>Employee Code:</td> 
               <td>
             <form:select id="usernameEmpFkId" path="usernameEmp">
			           <form:option value="" label="--- Select ---" />
			           <form:options items="${employees}" itemValue="username" itemLabel="username"/> 
			        </form:select> 
		         <font color="red"><b>${message}</b></font>
		       </td>  
            </tr>
               <tr>
                <td>CTC :</td>
                <td><form:input path="empSalaryYear" id="empSalaryYearId"/></td>
            </tr>
<%--       
               <tr>
                <td>Ctc:</td> 
                <td><form:input path="empSalaryMonth" id="empSalaryMonthId"/></td>
            </tr>
            <tr>
                <td>Basic Salary:</td>
                <td><form:input path="besicSalary" id="besicSalaryId"/></td>
            </tr> --%>
            <tr>
                <td>Salary date:</td>
                <td><form:input path="salaryDate" id = "datepicker"/></td>
            </tr>
         	<tr>
                <td colspan="2" align="center"><input type="submit" class="button" value="Save"></td>
            </tr>
        </table>
        </form:form>
  		<div id="response"></div>
    	<table border="1" id="tabSalary"  width="60%">
			<th>Employee Id</th>
			<th>CTC</th>
			<th>Basic Salary</th>
			<th>HRA</th>
			<th>PF</th>
			<th>Allowance</th>
			<th>Others</th>
			<th>Salary Date</th>

    <c:forEach var="salary" items="${salaryList}" varStatus="idx">
				<tr>
					<td align="center"><b>${salary.usernameEmp}</b></td>
					<td align="center">${salary.empSalaryYear}</td>
					<td align="center">${salary.besicSalary}</td>
					<td align="center">${salary.empSalaryMonth}</td>
					<td align="center">${salary.pf}</td>
					<td align="center">${salary.allowance}</td>
					<td align="center">${salary.others}</td>
					<td align="center">${salary.salaryDate}</td>

				</tr>
			</c:forEach>
		</table>

      </div>
          <!-- Javascript -->
      <script type="text/javascript">

         $(function() {
             $( "#datepicker" ).datepicker({
                 dateFormat : 'mm/dd/yy',
                 changeMonth : true,
                 changeYear : true,
                 yearRange: '-100y:c+nn',
                 //maxDate: 'd',
                 getDate:true
             });
         });
         
     	
     	function validation() {
     	   
     		var username = $("#usernameEmpFkId").val();
     	    if (username == "" || username == null) {
     	        alert("Employee code must be filled out.");
     	        return false;
     	    }
     	         	    
     	    var year = $("#empSalaryYearId").val();
     	    if(year == "" || year == null){
     	    	alert("CTC must be field out.");
     	    	return false;
     	    }
    	    
    	    var date = $("#datepicker").val();
     	    if(date == "" || date == null){
     	    	alert("Please select date");
     	    	return false;
     	    }
     	}
     </script>
</body>
</html>