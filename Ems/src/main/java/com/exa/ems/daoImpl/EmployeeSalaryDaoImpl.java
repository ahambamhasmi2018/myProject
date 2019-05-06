package com.exa.ems.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exa.ems.dao.EmployeeSalaryDao;
import com.exa.ems.model.SalaryDetails;

@Repository
public class EmployeeSalaryDaoImpl implements EmployeeSalaryDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveEmpSalary(SalaryDetails salaryDetails) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(salaryDetails);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SalaryDetails> getEmployeesSalary() {
		List<SalaryDetails> eSalary = new ArrayList<SalaryDetails>();
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(SalaryDetails.class);
		eSalary = cr.list();
		return eSalary;
	}

	@Override
	public Integer getSalaryByEmpId(String string) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<SalaryDetails> empSalary = session.createQuery("From SalaryDetails WHERE usernameEmp=:usernameEmp")
				.setParameter("usernameEmp", string).list();
		Integer empSalarySize = empSalary.size();
		return empSalarySize;
	}

}
