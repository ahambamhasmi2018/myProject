package com.exa.ems.services;

import java.util.List;

import com.exa.ems.model.SalaryDetails;

public interface EmpSalaeyServices {

	void saveEmpSalary(SalaryDetails salaryDetails);

	List<SalaryDetails> getEmployeesSalary();

	Integer getSalaryByEmpId(String string);     
}
