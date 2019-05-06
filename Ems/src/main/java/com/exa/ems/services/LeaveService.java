package com.exa.ems.services;

import java.util.List;

import com.exa.ems.model.EmployeeLeaveDetailse;

public interface LeaveService {

	List<EmployeeLeaveDetailse> getAllLeaves();

	void saveLeaves(EmployeeLeaveDetailse employeeLeaveDetailse);

	Integer getLeaveByEmpId(String usernameEmp);

	void setAcceptLeave(Integer empLeavePkId);

	void setRejectLeave(Integer empLeavePkId);    

}
