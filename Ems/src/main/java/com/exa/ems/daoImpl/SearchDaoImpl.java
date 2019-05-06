package com.exa.ems.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exa.ems.dao.SearchDao;
import com.exa.ems.model.EmployeeLeaveDetailse;
import com.exa.ems.model.EmployeePersonalDetails;
import com.exa.ems.model.SalaryDetails;

@Repository
public class SearchDaoImpl implements SearchDao {

	@Autowired private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeLeaveDetailse> getSearchLeavesById(String empCode) {
		List<EmployeeLeaveDetailse> listLeav = new ArrayList<EmployeeLeaveDetailse>();
		Session session = sessionFactory.getCurrentSession();
		listLeav = session.createQuery("From EmployeeLeaveDetailse WHERE usernameEmp=:usernameEmp")
				.setParameter("usernameEmp", empCode).list();
		return listLeav;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeePersonalDetails> getEmployeeProfileByEmpCode(String empCode) {
		List<EmployeePersonalDetails> employeeByCode = new ArrayList<EmployeePersonalDetails>();
		Session session = sessionFactory.getCurrentSession();
		employeeByCode = session.createQuery("From EmployeePersonalDetails WHERE username=:username")
				.setParameter("username", empCode).list();
		return employeeByCode; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SalaryDetails> getEmployeeSalaryByEmpCode(String empCode) {
		// TODO Auto-generated method stub
		List<SalaryDetails> salaryByCode = new ArrayList<SalaryDetails>();
		Session session = sessionFactory.getCurrentSession();
		salaryByCode = session.createQuery("From SalaryDetails WHERE usernameEmp=:usernameEmp")
				.setParameter("usernameEmp", empCode).list();
		return salaryByCode;
	}

}
