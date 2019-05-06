package com.exa.ems.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exa.ems.dao.SearchDao;
import com.exa.ems.model.EmployeeLeaveDetailse;
import com.exa.ems.model.EmployeePersonalDetails;
import com.exa.ems.model.SalaryDetails;
import com.exa.ems.services.SearchServices;

@Service
public class SearchServicesImpl implements SearchServices {

	@Autowired SearchDao searchDao;
	
	@Override
	@Transactional
	public List<EmployeeLeaveDetailse> getSearchLeavesById(String empCode) {
		return searchDao.getSearchLeavesById(empCode); 
	}

	@Transactional
	public List<EmployeePersonalDetails> getEmployeeProfileByEmpCode(String empCode) {
		return searchDao.getEmployeeProfileByEmpCode(empCode);
	}

	@Override
	@Transactional
	public List<SalaryDetails> getEmployeeSalaryByEmpCode(String empCode) {
		return searchDao.getEmployeeSalaryByEmpCode(empCode); 
	}

}
