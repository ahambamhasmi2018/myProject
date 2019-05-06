 <script type="text/javascript"> 
 function validation() {
       	   
      		var fname = $("#fnameId").val();
      	    if (fname == "" || fname == null) {
      	        alert("first name  must be filled out.");
      	        return false;
      	    }
      	    
      	    var lname = $("#lnameId").val();
      	    if(lname == "" || lname == null){
      	    	alert("Last name  must be filled out.");
      	    	return false;
      	    }
      	    
      	  	var email = $("#emailId").val();
      	  	var atposition=email.indexOf("@");  
      		var dotposition=email.lastIndexOf(".");  
      		if (atposition<1 || dotposition<atposition+2 || dotposition+2>=email.length){  
      	  		alert("Please enter a valid e-mail address ");  
      	  		return false;      	    
      		}
      		
        	var teleId = $("#teleId").val();
       	    if(teleId == "" || teleId == null){
       	    	alert("Mobile no  must be filled out.");
       	    	return false;
       	    } else if(isNaN(teleId)){
       	    	alert("Numeric value only.");
       	    	return false;
       	    }else if (teleId.length != 10) {
       	    	alert("mobile no shuld have 10 degits only");
       	        return false;
			}
      		
     	    var dob = $("#datepicker").datepicker("getDate");
 				if(dob === null){
      	    	alert("Choose date of birth");
      	    	return false;
      	    } 
      	    
    	    var doj = $("#datepicker-1").datepicker("getDate");
      	    if(doj === null){
      	    	alert("Choose date of Joining");
      	    	return false;
      	    } 
      	    
        	var adhr = $("#aadharCardNoId").val();
       	    if(adhr == "" || adhr == null){
       	    	alert("Aadhar no  must be filled out.");
       	    	return false;
       	    } else if(isNaN(adhr)){
       	    	alert("Aadhar no numeric value only.");
       	    	return false;
       	    }else if (adhr.length != 12) {
       	    	alert("Aadhar no shuld have 12 degits only");
       	        return false;
			}
      	    
    	    var pass = $("#passwordId").val();
      	    if(pass == "" || pass == null){
      	    	alert("Password must be field out.");
      	    	return false;
      	    }
      	    
       	    
        	var grade = $("#eGradeId").val();
       	    if(grade == "" || grade == null){
       	    	alert("Please select grade.");
       	    	return false;
       	    } 
      		
      	   var etype = $("#eTypeId").val();
     	    if(etype == "" || etype == null){
     	    	alert("Please select employee type");
     	    	return false;
     	    }
     	    
       	   var genderId = $("#genderId").val();
    	    if(genderId == "" || genderId == null){
    	    	alert("Please select Gender");
    	    	return false;
    	    }
    	    
        	var locationId = $("#locationId").val();
       	    if(locationId == "" || locationId == null){
       	    	alert("Please select location");
       	    	return false;
       	    }
       	    
        	var designationId = $("#designationId").val();
       	    if(designationId == "" || designationId == null){
       	    	alert("Please select designation.");
       	    	return false;
       	    } 

       	    
        	var departmentId = $("#departmentId").val();
       	    if(departmentId == "" || departmentId == null){
       	    	alert("Please select department.");
       	    	return false;
       	    }
       	    
        	var role = $("#roleId").val();
       	    if(role == "" || role == null){
       	    	alert("Please select Role.");
       	    	return false;
       	    } 
      		
         }
</script>