<%@include file="header.jsp" %>
<%@include file="validation.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
<link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel = "stylesheet">
<script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
<script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<style type="text/css">
input[type="password"], input[type="text"],select{
  border: 1px solid #a1a3a3;
  color: #888800;
  height: 25px;
  padding-left: 37px;
  width: 240px;
}
input[type="password"]:focus, input[type="text"]:focus {
  box-shadow: 0 0 4px 1px rgba(55, 166, 155, 0.3);
  outline: 0;
   border: 3px solid #555;
}
/* input[type=text]:focus {
    border: 3px solid #555;
} */
input[select]:focus {
  box-shadow: 0 0 4px 1px rgba(55, 166, 155, 0.3);
  outline: 0;
    border: 3px solid #555;
}
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
    background-color: #ccccff;
    font-size: 14;
}
th, td {
    padding: 10px;
}

</style>
</head>
<body marginwidth="10%">
<div align="right"><a href="home">Back</a> | <font color="green">  Welcome : ${name} </font> | <a href="logout">logout</a></font> </div>
    <div align="center">
        <font size="5" color="darkblue"> New Employee</font><br></br>
        <form:form action="saveEmployee" method="Post" modelAttribute="employeePersonalDetails" onsubmit="return validation()">
        <table>
            <form:hidden path="empPkId"/>
            <form:hidden path="username"/>
            <tr>
                <td>First Name:<font color="#FF0000">*</font></td> 
                <td><form:input path="firstname" id="fnameId"/></td>
                <td>Last Name:<font color="#FF0000">*</font></td> 
                <td><form:input path="lastname" id="lnameId"/></td>
                <td>Email:<font color="#FF0000">*</font></td>
                <td><form:input path="email" id="emailId"/></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><form:input path="address" id="address"/></td>
                <td>Mobile:<font color="#FF0000">*</font></td>
                <td><form:input path="telephone" id="teleId"/></td>
                <td>Dob:<font color="#FF0000">*</font></td>
                <td><form:input path="dob" id = "datepicker" readonly="readonly"/></td>
            </tr>
            <tr>
                <td>Doj:<font color="#FF0000">*</font></td>
                <td><form:input path="doj" id = "datepicker-1"/></td>
                <td>Hod Name:</td> 
                <td><form:input path="hodName" id="hodNameId"/></td>
                <td>Account No:</td> 
                <td><form:input path="accNo" id="accNoId"/></td>
            </tr>
            <tr>
                <td>Aadhar Card No:<font color="#FF0000">*</font></td> 
                <td><form:input path="aadharCardNo" id="aadharCardNoId"/></td>
                <td>Pan Card No:</td> 
                <td><form:input path="panCardNo" id="panCardNoId"/></td>
                <td>Password:<font color="#FF0000">*</font></td> 
                <td><form:input path="password" id="passwordId"/></td>
            </tr>
            <tr>
                <td>Employee Grade:<font color="#FF0000">*</font></td> 
                <td>
	                <form:select id="eGradeId" path="empGradeFkId.commonConstantPkId">
			           <form:option value="" label="--- Select ---" />
			           <form:options items="${grads}" itemValue="commonConstantPkId" itemLabel="constantValue"/>
			        </form:select>
		        </td>
                <td>Employee Type:<font color="#FF0000">*</font></td> 
                <td>
                <form:select id="eTypeId" path="empTypeFkId.commonConstantPkId">
		           <form:option value="" label="--- Select ---" />
		           <form:options items="${eTypes}" itemValue="commonConstantPkId" itemLabel="constantValue"/>
		         </form:select>
		         </td>
                <td>Gender:<font color="#FF0000">*</font></td>
             <td>
                <form:select id="genderId" path="genderFkId.commonConstantPkId">
		           <form:option value="" label="--- Select ---" />
		           <form:options items="${genders}" itemValue="commonConstantPkId" itemLabel="constantValue"/>
		         </form:select>
             </td> 
             </tr>
              <tr>
             <td>Location:<font color="#FF0000">*</font></td>
             <td>
                <form:select id="locationId" path="locationFkId.locationPkId">
		           <form:option value="" label="--- Select ---" />
		           <form:options items="${locations}" itemValue="locationPkId" itemLabel="locationName"/>
		         </form:select>
             </td> 
             <td>Designation:<font color="#FF0000">*</font></td>
             <td>
                <form:select id="designationId" path="designationFkId.designationPkId">
		           <form:option value="" label="--- Select ---" />
		           <form:options items="${designations}" itemValue="designationPkId" itemLabel="designationName"/>
		         </form:select>
             </td> 
             <td>Department:<font color="#FF0000">*</font></td>
             <td>
                <form:select id="departmentId" path="departmentFkId.departmentPkId">
		           <form:option value="" label="--- Select ---" />
		           <form:options items="${departments}" itemValue="departmentPkId" itemLabel="departmentName"/>
		         </form:select>
             </td> 
            </tr>
        <tr>
           <td>Roles:<font color="#FF0000">*</font></td>
             <td>
             	<form:select path="role" id="roleId"> 
  						<form:option value="" label="---Select role---" />	
	  					<form:option value="User" label="User" />
	  					<form:option value="Admin" label="Admin" />
  				</form:select>
             </td> 
		</tr>
        </table><input type="submit" class="button button1" value="Save">
        </form:form>
    </div>
          <!-- Javascript -->
      <script type="text/javascript">

         $(function() {
             $( "#datepicker" ).datepicker({
                 dateFormat : 'mm/dd/yy',
                 changeMonth : true,
                 changeYear : true,
                 yearRange: '-100y:c+nn',
                 maxDate: 'd',
                 //getDate:true
             });
             
             $( "#datepicker-1" ).datepicker({
                 dateFormat : 'mm/dd/yy',
                 changeMonth : true,
                 changeYear : true,
                 yearRange: '-100y:c+nn',
               //  maxDate: 'd',
                 getDate:true
             });
             
         });
      </script>
</body>
</html>