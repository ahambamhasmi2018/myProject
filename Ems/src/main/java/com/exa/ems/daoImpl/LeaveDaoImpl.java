package com.exa.ems.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exa.ems.dao.LeaveDao;
import com.exa.ems.model.EmployeeLeaveDetailse;

/**
 * @author Manish.Mishra
 *
 */
@Repository
public class LeaveDaoImpl implements LeaveDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	/* (non-Javadoc)
	 * @see com.exa.ems.dao.LeaveDao#getAllLeaves()
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeLeaveDetailse> getAllLeaves() {
		Session session = sessionFactory.getCurrentSession();
		List<EmployeeLeaveDetailse> leaveList = new ArrayList<EmployeeLeaveDetailse>();
		try {
			leaveList  = session.createCriteria(EmployeeLeaveDetailse.class).list();
		} catch (HibernateException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return leaveList;
	}

	/* (non-Javadoc)
	 * @see com.exa.ems.dao.LeaveDao#saveLeaves(com.exa.ems.model.EmployeeLeaveDetailse)
	 */
	@Override
	public void saveLeaves(EmployeeLeaveDetailse employeeLeaveDetailse) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(employeeLeaveDetailse);
		} catch (HibernateException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Integer getLeaveByEmpId(String usernameEmp) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<EmployeeLeaveDetailse> empLeaves = session.createQuery("From EmployeeLeaveDetailse WHERE usernameEmp=:usernameEmp")
				.setParameter("usernameEmp", usernameEmp).list();
		Integer empSalarySize = empLeaves.size();
		return empSalarySize;
	}

	@Override
	public void setAcceptLeave(Integer empLeavePkId) {
		Integer status = 2;
		String hql = "UPDATE EmployeeLeaveDetailse set status = :status WHERE empLeavePkId = :empLeavePkId";
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Query query = session.createQuery(hql);
		query.setParameter("empLeavePkId", empLeavePkId);
		query.setParameter("status", status);
		Integer result = query.executeUpdate();
		System.out.println("Rows accepted: " + result);
	}

	@Override
	public void setRejectLeave(Integer empLeavePkId,EmployeeLeaveDetailse employeeLeaveDetailse) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employeeLeaveDetailse); 
	}

	@Override
	public EmployeeLeaveDetailse getByLeaveId(Integer empLeavePkId) {
		Session session = sessionFactory.getCurrentSession();
		EmployeeLeaveDetailse employeeLeaveDetailse = (EmployeeLeaveDetailse) session.load(EmployeeLeaveDetailse.class, empLeavePkId); 
		return employeeLeaveDetailse;
	}

}
