<%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>User Leave details</title>
		<link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel = "stylesheet">
		<script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
		<script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
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
<div align="right"><a href="userHome">Back</a> |<font color="green">Welcome : ${name}</font> |<font><a href="logout">logout</a></font>|</div>
    <div align="center">
        <h3><font color="#002080">Employee Leaves</font></h3>
        <form:form action="saveUserLeaves" method="Post" modelAttribute="employeeLeaveDetailse" onsubmit="return validation()">
        <table>
         <form:hidden path="empLeavePkId"/>
            <tr>
               <td>Employee Code:</td> 
               <td>
	              <form:hidden path="usernameEmp" value="${uName}"/> <b>${uName}</b>
		         <font color="red"><b></b></font>
		       </td>  
            </tr>
            <form:hidden path="totalLeaves" id="totalLeavesId" value="${tLeave}" readonly="true"/>
            <tr>
                <td>Balance Leave:</td>
                <td> 
					<form:input path="balanceLeave" id="balanceLeaveId" value="${balanceLeave}" readonly="true"/>
				</td>
            </tr>
            <tr><td>Leave Type</td>
	            <td>
	            	<form:select path="leaveType" id="leaveTypeId">
	            		<form:option value="">Select leave </form:option>
	            		<form:option value="vacation">Vacation</form:option>
	            		<form:option value="sick">Sick</form:option>
	            	</form:select>
	            </td>
            </tr>
            <tr id="rowS">
                <td>Sick Leave:</td> 
                <td> ${sickL}<form:hidden path="sickLeave" id="sickLeaveId" value="${sickL}" readonly="true"/></td> 
            </tr>
            <tr id="rowV">
                <td>Vacation Leave:</td> 
                <td> ${vacL} <form:hidden path="vacationLeave" id="vacationLeaveId" value="${vacL}" readonly="true"/></td> 
            </tr>
            <tr>
                <td>Leave From date:</td>
                <td><form:input path="leaveFromDate" id = "datepicker"/></td>
            </tr>
            <tr>
                <td>Leave To date:</td>
                <td><form:input path="leaveToDate" id = "datepicker1"/></td>
            </tr> 
            <tr>
                <td>Take leaves:</td>
                <td><form:input path="leavetaken" id="leavetakenId" readonly="true"/></td>
            </tr> 
         	<tr>
                <td colspan="2" align="center">
                <input type="submit" id="submitId" class="bitton" value="Save"></td>
            </tr> 
        </table>
        </form:form>
        <br></br>
       <table border="1">
			<th>Emp Id</th>
		<!-- 	<th>Total Leave</th> -->
			<th>Balance Leave</th>
			<th>Leave Type</th>
			<th>Leave Taken</th>
			<th>Leave from date</th>
			<th>Leave to date</th>
			<th>Action</th>
    <c:forEach var="lev" items="${empLeaves}" varStatus="idx">
    <c:if test="${lev.leaveFromDate != null}">
				<tr>
					<td align="center"><b>${lev.usernameEmp}</b></td>
				<!-- 	<td> 12 </td> -->
					<td align="center">${lev.balanceLeave}</td>
					<td align="center">${lev.leaveType}</td>
					<td align="center">${lev.leavetaken}</td>
					<td align="center">${lev.leaveFromDate}</td>
					<td align="center">${lev.leaveToDate}</td>
					<td><c:if test="${lev.status == 0}">
					<font color="#FF8000"><b>In process</b></font> |  
						 <a href="cancelUserLeaves?empLeavePkId=${lev.empLeavePkId}">Cancel</a>
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
				</tr></c:if>
			</c:forEach>
		</table>
        
    </div>
   
      <!-- Javascript -->
<script type="text/javascript">
      $(document).ready(function(){

 	        var bLeave = $("#balanceLeaveId").val();
	       		$("#rowV").hide();
	    	    $("#rowS").hide();
	    		  $("#leaveTypeId").change(function(){
	    		  
	    		  if($("#leaveTypeId").val() == "vacation"){
			   	    	  $("#rowV").show();
			   	    	  $("#rowS").hide();
		   	      }else{
			   	    	$("#rowS").show();
		  	    	  	$("#rowV").hide();
   	      			}
	    	  });
	   	      
         $(function() {
             $( "#datepicker" ).datepicker( {
                 dateFormat : 'mm/dd/yy',
                 changeMonth : true,
                 changeYear : true,
                 yearRange: '-100y:c+nn',
                // maxDate: 'd',
                 getDate:true
             });

             $( "#datepicker1" ).datepicker({
                 dateFormat : 'mm/dd/yy',
                 changeMonth : true,
                 changeYear : true,
                 yearRange: '-100y:c+nn',
                // maxDate: 'd',
                 getDate:true,
                 onSelect: function () {
                	  daysCalculation();
                 }
             });
         });
         
			/* This  function calculate daya from end date to start date. */
			
         function daysCalculation() {
			var start = $( "#datepicker" ).datepicker("getDate");
			var end  =   $( "#datepicker1" ).datepicker("getDate");
			if(Date.parse(end) < Date.parse(start)){
				alert("Leave To date should be greater than Leave From date");
				$("#submitId").prop('disabled', true);
				return false;
			}
			var days = (end - start)/(1000 * 60 * 60 * 24);
			$("#leavetakenId").val(Math.round(days)+1);
			validateDate();
         }
         
         /* call function to validate balance leave and taken leave. calling from daysCalculation() */
         
         function validateDate() {
     		var lType = $("#leaveTypeId").val();
     		var vl = parseInt($("#vacationLeaveId").val());
    		var sL = parseInt($("#sickLeaveId").val());
    		 $("#submitId").prop('disabled', false);
    	        if(bLeave == 0){
    	        	alert("Now your balance leave is 0.Thank you..!!");
    	        	 $("#submitId").prop('disabled', true);
    	        }else{
    	        	var lt = parseInt($("#leavetakenId").val());
    	        	if(lt<=bLeave){
            			$("#submitId").prop('disabled', false);
            	} else{
            		alert("balance leave shuould be greater than or equal to taking leaves");
            		$("#submitId").prop('disabled', true);
            	}

    	      if(lType=="vacation"){
    	    	  $("#rowV").show();
	   	    	  $("#rowS").hide();
    	        		if(lt<=vl){
    	        			$("#submitId").prop('disabled', false);
    	        		}else{
    	        			alert("Vacation leave shuould be greater than or equal to taking leaves");
        	        		$("#submitId").prop('disabled', true);
    	        		}
    	     }else{
    	    	 	$("#rowS").show();
	  	    	  	$("#rowV").hide();
    	        		if(lt<=sL){
    	        			$("#submitId").prop('disabled', false);
    	        		}else{
    	        			alert("Sick leave shuould be greater than or equal to taking leaves");
        	        		$("#submitId").prop('disabled', true);
    	        		}
    	        	}
    	    
    		}
		} 
  	});     	
      	
      function validation() {
      	         	    
      	    var leavetaken = $("#leavetakenId").val();
      	    if(leavetaken == "" || leavetaken == null){
      	    	alert("leave taken must be field out.");
      	    	return false;
      	    }
      	    
      	    var year = $("#datepicker").val();
      	    if(year == "" || year == null){
      	    	alert("Select leave from date.");
      	    	return false;
      	    }
      	    
     	    var date = $("#datepicker1").val();
      	    if(date == "" || date == null){
      	    	alert("Select leave to date");
      	    	return false;
      	    }
      	}
      </script>
</body>
</html>