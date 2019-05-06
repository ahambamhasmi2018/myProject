<%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Leave details</title>
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
			}

</style>
<script type = "text/javascript" 
         	src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js">
      </script>
<script type="text/javascript" language = "javascript"> 
$(document).ready(function(){
	$("#empFkId").change(function(){
		var empCode = $("#empFkId").val();
	      if(empCode != "" && empCode != null){
	    	  $("#tableave").hide();
	      }
 		$.ajax({
            url : "./searchEmployeeLeaves/"+empCode,
            type: "GET",
            contentType: "application/json; charset=utf-8",
            dataType: "json", 
            processData: false,
            success : 
                function(data) {
                    $('#response').html("<table>");
                    $('#response').append("<th>Sr.No.</th><th>Emp Id</th><th>Balance Leave</th><th>Leave Taken</th><th>Leave from date</th><th>Leave to date</th>");
                	$.each(data, function(index,data) { 
                		$('#response').append("<tr>");
                		$('#response').append("<td>"+(index+1)+"</td>");
                		$('#response').append("<td>"+data.usernameEmp+"</td>");
                		$('#response').append("<td>"+data.balanceLeave+"</td>");
                		$('#response').append("<td>"+data.leavetaken+"</td>");
                		$('#response').append("<td>"+data.leaveFromDate+"</td>");
                		$('#response').append("<td>"+data.leaveToDate+"</td>");
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

<a href="home">Back</a> | <font color="green">Welcome : ${name}</font> | <font><a href="logout">logout</a></font> 
	  <div align="right"><%-- 		  <label>Search :</label>   <select id="empFkId"> 
			    	<option value="">--- select---</option>
			    	<c:forEach items="${employees}" var="emp">
			    		<option value="${emp.username}">${emp.username}</option>
			       </c:forEach>
			    </select> --%>
			     <form action="searchEmployeeLeaves" method="get" modelAttribute="employeeLeaveDetailse">
			    		<input type="text" name="usernameEmp" placeholder="Please enter employee code">
			    		&nbsp;<input type="Submit" value="search"/>
			     </form></div>
    <div align="center">
     <h3><font color="#002080">Employee Leaves</font></h3>
      <form:form action="saveEmployeeLeaves" method="Post" modelAttribute="employeeLeaveDetailse" onsubmit="return validation()">
        <table>
         <form:hidden path="empLeavePkId"/>
          <tr>
             <td>Employee Code:</td> 
               <td>
	              <form:select id="usernameEmpFkId" path="usernameEmp">
			           <form:option value="" label="--- Select ---" />
			           <form:options items="${employees}" itemValue="username" itemLabel="username"/> 
			        </form:select> 
		         <font color="red"><b></b></font>
		       </td>  
            </tr>
            <tr>
                <td>Total Leave:</td> 
                <td><form:input path="totalLeaves" id="totalLeavesId" value="12" readonly="true"/></td> 
            </tr>
            <tr>
                <td>Vacation Leave:</td> 
                <td><form:input path="vacationLeave" id="vacationLeaveId" value="8" readonly="true"/></td> 
            </tr>
            <tr>
                <td>Sick Leave:</td> 
                <td><form:input path="sickLeave" id="sickLeaveId" value="4" readonly="true"/></td> 
            </tr>
          <tr>
                <td>Take leaves:</td>
                <td><form:input path="leavetaken" id="leavetakenId" value="0" readonly="true"/> 
        <%--     <select name="leavetaken" id="leavetakenId"> 
                  <option value="">----- Select Leave-----</option>
                	<c:forEach items="${leaves}" var="i">
                		<option value='${i}'><c:out value="${i}"></c:out></option> 
                	</c:forEach>	
                  </select>
                </td>
            </tr> --%>
         	<tr>
                <td colspan="2" align="center"><input type="submit" class="button button1" value="Save"></td>
            </tr> 
        </table>
        </form:form>
	<div id="response"></div>
       <br></br>
       <table border="1" id="tableave">
       		<th>Sr.No.</th>
			<th>Emp Id</th>
			<th>Balance Leave</th>
			<th>Leave Type</th>
			<th>Leave Taken</th>
			<th>Leave from date</th>
			<th>Leave to date</th>
			<th>Action</th>
			<c:if test="${size == null }">
    <c:forEach var="lev" items="${leaveList}" varStatus="idx">
    	<%-- <c:if test="${lev.leaveFromDate != null}"> --%>
				<tr>
					<td>${idx.index + 1}</td>
					<td>${lev.usernameEmp}</td>
					<td>${lev.balanceLeave}</td>
					<td>${lev.leaveType}</td>
					<td>${lev.leavetaken}</td>
					<td>${lev.leaveFromDate}</td>
					<td>${lev.leaveToDate}</td>
					<td><c:if test="${lev.status == 0}">
					<a href="acceptStatus?empLeavePkId=${lev.empLeavePkId}">Accept</a> | 
						<a href="rejectStatus?empLeavePkId=${lev.empLeavePkId}">Reject</a>
					 </c:if>
					 <c:if test="${lev.status == 2}">
									<font color="Green"><b>Accepted</b></font>
					 </c:if>
					 <c:if test="${lev.status == 3}">
									<font color="red"><b>Rejected</b></font>
					 </c:if>
					 <c:if test="${lev.status == 4}">
									<font color="#1F3B4A"><b>Canceled</b></font>
					 </c:if>
					</td>
				</tr><%-- </c:if> --%>
			</c:forEach>
			</c:if>
			<c:if test="${size != 0 }">
    <c:forEach var="lev" items="${listOfLeavesbyId}" varStatus="idx">
    	<%-- <c:if test="${lev.leaveFromDate != null}"> --%>
				<tr>
					<td>${idx.index + 1}</td>
					<td>${lev.usernameEmp}</td>
					<td>${lev.balanceLeave}</td>
					<td>${lev.leavetaken}</td>
					<td>${lev.leaveFromDate}</td>
					<td>${lev.leaveToDate}</td>
					<td><c:if test="${lev.status == 0}">
					<a href="acceptStatus?empLeavePkId=${lev.empLeavePkId}">Accept</a> | 
						<a href="rejectStatus?empLeavePkId=${lev.empLeavePkId}">Reject</a>
					 </c:if>
					 <c:if test="${lev.status == 2}">
							<font color="Green"><b>Accepted</b></font>
					 </c:if>
					 <c:if test="${lev.status == 3}">
							<font color="red"><b>Rejected</b></font>
					 </c:if>
					</td>
				</tr>
			</c:forEach>
			</c:if>
		</table>
        
    </div>
   
      <!-- Javascript -->
      <script type="text/javascript">
         function validation() {
      		var username = $("#usernameEmpFkId").val();
      	    if (username == "" || username == null) {
      	        alert("Employee code must be filled out.");
      	        return false;
      	    }
      	    
/*       	    var leavetaken = $("#leavetakenId").val();
      	        if(leavetaken == "" || leavetaken == null){
      	    	alert("leave taken must be field out.");
      	    	return false;
      	    } */
         }
      </script>
</body>
</html>