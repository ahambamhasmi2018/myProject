package com.exa.ems.servicesImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exa.ems.dao.LoginDao;
import com.exa.ems.model.EmployeePersonalDetails;
import com.exa.ems.services.LoginServices;

@Service
public class LoginServicesImpl implements LoginServices {

	@Autowired
	private LoginDao loginDao;
	


/*	@Override
	@Transactional
	public List<EmployeePersonalDetails> loginAuth(String username, String password) {
		// TODO Auto-generated method stub
		return loginDao.loginAuthEmp(username, password);
	}*/

	@Override
	@Transactional
	public List<EmployeePersonalDetails> loginAuthEmp(String username, String password) {
		// TODO Auto-generated method stub
		return loginDao.loginAuthEmp(username, password);
	}
}
