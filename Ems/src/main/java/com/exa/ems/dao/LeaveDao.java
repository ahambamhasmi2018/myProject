package com.exa.ems.dao;

import java.util.List;

import com.exa.ems.model.EmployeeLeaveDetailse;

public interface LeaveDao {
	
	List<EmployeeLeaveDetailse> getAllLeaves();

	void saveLeaves(EmployeeLeaveDetailse employeeLeaveDetailse);
	
	Integer getLeaveByEmpId(String usernameEmp);
	
	void setAcceptLeave(Integer empLeavePkId);

	void setRejectLeave(Integer empLeavePkId, EmployeeLeaveDetailse employeeLeaveDetailse); 
	
	EmployeeLeaveDetailse getByLeaveId(Integer empLeavePkId);
}
