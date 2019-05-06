package com.exa.ems.dao;

import java.util.List;

import com.exa.ems.model.CommonConstant;
import com.exa.ems.model.Department;
import com.exa.ems.model.Designation;
import com.exa.ems.model.EmployeePersonalDetails;
import com.exa.ems.model.Location;

public interface EmployeeDAO {

	public void addEmployee(EmployeePersonalDetails employeePersonalDetails);

	public List<EmployeePersonalDetails> getAllEmployees();

	public void deleteEmployee(Integer employeeId);

	public EmployeePersonalDetails updateEmployee(EmployeePersonalDetails employeePersonalDetails);

	public EmployeePersonalDetails getEmployee(int employeeid);
	
	public List<CommonConstant> getGenders(String string); 
	
	public List<CommonConstant> getGrades(String string);

	public List<CommonConstant> getEmpType(String string);

	public List<Department> getDepartments();

	public List<Location> getLocations();  
	
	public List<Designation> getDesignation();

	public Integer getMaxPkId();   
}
