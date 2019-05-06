package com.exa.ems.services;

import java.util.List;

import com.exa.ems.model.EmployeeLeaveDetailse;
import com.exa.ems.model.EmployeePersonalDetails;
import com.exa.ems.model.SalaryDetails;

public interface UserService {

	List<EmployeePersonalDetails> getPersonalDetilById(String loginUser);

	List<EmployeeLeaveDetailse> getLeaveById(String loginUser);

	List<SalaryDetails> getUserSalaryById(String loginUser);

	void userTakeLeave(EmployeeLeaveDetailse employeeLeaveDetailse);

	EmployeePersonalDetails getPersonalDetilByPkId(Integer empPkId);

	void setCancelLeave(Integer empLeavePkId);       

}
