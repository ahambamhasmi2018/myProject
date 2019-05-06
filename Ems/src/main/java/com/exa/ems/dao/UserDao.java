package com.exa.ems.dao;

import java.util.List;

import com.exa.ems.model.EmployeeLeaveDetailse;
import com.exa.ems.model.EmployeePersonalDetails;
import com.exa.ems.model.SalaryDetails;

public interface UserDao {
	
	List<EmployeePersonalDetails> getPersonalDetilById(String loginUser);  
	
	List<EmployeeLeaveDetailse> getLeaveById(String loginUser);  
	
	List<SalaryDetails> getUserSalaryById(String loginUser);
	
	void userTakeLeave(EmployeeLeaveDetailse employeeLeaveDetailse); 
	
	EmployeePersonalDetails getPersonalDetilByPkId(Integer empPkId);
	
	void setCancelLeave(Integer empLeavePkId,EmployeeLeaveDetailse employeeLeaveDetailse); 
}
