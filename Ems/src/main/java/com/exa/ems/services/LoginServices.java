package com.exa.ems.services;

import java.util.List;

import com.exa.ems.model.EmployeePersonalDetails;

public interface LoginServices {

	//List<EmployeePersonalDetails> loginAuth(String username, String password); 

	List<EmployeePersonalDetails> loginAuthEmp(String username, String password);     

}
