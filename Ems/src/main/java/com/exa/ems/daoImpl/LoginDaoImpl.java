package com.exa.ems.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exa.ems.dao.LoginDao;
import com.exa.ems.model.EmployeePersonalDetails;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	/*@SuppressWarnings("unchecked")
	@Override
	public Integer loginAuth(String username, String password,String role) {
		Session session = sessionFactory.getCurrentSession();
		Integer check = 0;
		List<EmployeePersonalDetails> empUser = new ArrayList<EmployeePersonalDetails>();
		try {
			empUser = session.createSQLQuery("Select * from emp_personal_details where username=:username and password=:password and role=:role")
			.setParameter("username", username)
			.setParameter("password", password)
			.setParameter("role", role)
			.list();
		} catch (HibernateException he) {
			// TODO Auto-generated catch block
			he.printStackTrace();
		}
		check = empUser.size();
		System.out.println("DAO employee users check :"+check);
		return check;
	}*/


	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeePersonalDetails> loginAuthEmp(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		List<EmployeePersonalDetails> empUser = new ArrayList<EmployeePersonalDetails>();
		try {/*Select * from emp_personal_details where username=:username and password=:password*/
			 empUser = session.createQuery("From EmployeePersonalDetails where username=:username and password=:password")
			.setParameter("username", username)
			.setParameter("password", password)
			.setMaxResults(0)
			.list();
		} catch (HibernateException he) {
			// TODO Auto-generated catch block
			he.printStackTrace();
		}
		
		System.out.println("DAO employee users check :"+empUser.toString());
		return empUser;
	}
}
