package com.exa.ems.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exa.ems.dao.UserDao;
import com.exa.ems.model.EmployeeLeaveDetailse;
import com.exa.ems.model.EmployeePersonalDetails;
import com.exa.ems.model.SalaryDetails;

@Repository
public class UserDaoImpl implements UserDao {

	
	@Autowired private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeePersonalDetails> getPersonalDetilById(String loginUser) {
			Session session = sessionFactory.getCurrentSession();
			List<EmployeePersonalDetails> employeePersonalDetails = new ArrayList<EmployeePersonalDetails>(); 
			employeePersonalDetails = (List<EmployeePersonalDetails>) session.createQuery("From EmployeePersonalDetails WHERE username =:username")
			.setParameter("username", loginUser).list();
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++= "+employeePersonalDetails.size()); 
		return employeePersonalDetails;
	}

	@SuppressWarnings({ "unchecked"})
	@Override
	public List<EmployeeLeaveDetailse> getLeaveById(String loginUser) {
		Session session = sessionFactory.getCurrentSession();
		List<EmployeeLeaveDetailse> listSingle = new ArrayList<EmployeeLeaveDetailse>();
		listSingle = session
				.createQuery("From EmployeeLeaveDetailse e WHERE e.usernameEmp =:loginUser order by e.balanceLeave desc")
				.setParameter("loginUser", loginUser).setMaxResults(0)
				.list();
		System.out.println("empId : ---------------"+listSingle.size());
		System.out.println("listSingle >>>>>>>>>"+listSingle.toString());
		for(EmployeeLeaveDetailse obj : listSingle){
	        System.out.println(obj+"  ");
	    }
		return listSingle;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SalaryDetails> getUserSalaryById(String loginUser) {
		Session session = sessionFactory.getCurrentSession();
		List<SalaryDetails> userSalary = session.createQuery("From SalaryDetails Where usernameEmp=:usernameEmp")
				.setParameter("usernameEmp", loginUser)
				.list();
		System.out.println(userSalary.toString()+"");
		return userSalary;
	}

	@Override
	public void userTakeLeave(EmployeeLeaveDetailse employeeLeaveDetailse) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(employeeLeaveDetailse);
		} catch (HibernateException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public EmployeePersonalDetails getPersonalDetilByPkId(Integer empPkId) {
		Session session = sessionFactory.getCurrentSession();
		EmployeePersonalDetails employeePersonalDetails =  (EmployeePersonalDetails) session.get(EmployeePersonalDetails.class, empPkId);
		return employeePersonalDetails;
	}

	@Override
	public void setCancelLeave(Integer empLeavePkId, EmployeeLeaveDetailse employeeLeaveDetailse) {
		Session session = sessionFactory.getCurrentSession();
		   session.saveOrUpdate(employeeLeaveDetailse);
	}
}
