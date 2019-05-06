package com.exa.ems.services;

import java.util.List;

import com.exa.ems.model.EmployeeLeaveDetailse;
import com.exa.ems.model.EmployeePersonalDetails;
import com.exa.ems.model.SalaryDetails;

public interface SearchServices {

	List<EmployeeLeaveDetailse> getSearchLeavesById(String empCode);

	List<EmployeePersonalDetails> getEmployeeProfileByEmpCode(String empCode);

	List<SalaryDetails> getEmployeeSalaryByEmpCode(String empCode);  


}
