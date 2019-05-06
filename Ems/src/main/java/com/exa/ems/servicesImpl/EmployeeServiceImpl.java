package com.exa.ems.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exa.ems.dao.EmployeeDAO;
import com.exa.ems.model.CommonConstant;
import com.exa.ems.model.Department;
import com.exa.ems.model.Designation;
import com.exa.ems.model.EmployeePersonalDetails;
import com.exa.ems.model.Location;
import com.exa.ems.services.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	@Transactional
	public void addEmployee(EmployeePersonalDetails employeePersonalDetails) {
		employeeDAO.addEmployee(employeePersonalDetails);
	}

	@Override
	@Transactional
	public List<EmployeePersonalDetails> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@Override
	@Transactional
	public void deleteEmployee(Integer employeeId) {
		employeeDAO.deleteEmployee(employeeId);
	}

	public EmployeePersonalDetails getEmployee(int empid) {
		return employeeDAO.getEmployee(empid);
	}

	public EmployeePersonalDetails updateEmployee(EmployeePersonalDetails employeePersonalDetails) {
		// TODO Auto-generated method stub
		return employeeDAO.updateEmployee(employeePersonalDetails);
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	@Transactional
	public List<CommonConstant> getGenders(String string) {
		return employeeDAO.getGenders(string); 
	}

	@Override
	@Transactional
	public List<CommonConstant> getGrades(String string) {
		return employeeDAO.getGrades(string); 
	}

	@Override
	@Transactional
	public List<CommonConstant> getEmpType(String string) {
		return employeeDAO.getEmpType(string); 
	}

	@Override
	@Transactional
	public List<Department> getDepartments() {
		return employeeDAO.getDepartments();
	}

	@Override
	@Transactional
	public List<Location> getLocations() {
		return employeeDAO.getLocations();
	}

	@Override
	@Transactional
	public List<Designation> getDesignation() {
		return employeeDAO.getDesignation();
	}

	@Override
	@Transactional
	public Integer getMaxPkId() {
		return employeeDAO.getMaxPkId();
	}

}
