package com.exa.ems.dao;

import java.util.List;

import com.exa.ems.model.EmployeePersonalDetails;

public interface LoginDao {
	
	//List<EmployeePersonalDetails> loginAuth(String username, String password);

	List<EmployeePersonalDetails> loginAuthEmp(String username, String password); 
}
