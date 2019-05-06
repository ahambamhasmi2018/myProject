package com.exa.ems.dao;

import java.util.List;

import com.exa.ems.model.SalaryDetails;

public interface EmployeeSalaryDao {

	void saveEmpSalary(SalaryDetails salaryDetails); 
	
	List<SalaryDetails> getEmployeesSalary();
	
	Integer getSalaryByEmpId(String string); 
}
