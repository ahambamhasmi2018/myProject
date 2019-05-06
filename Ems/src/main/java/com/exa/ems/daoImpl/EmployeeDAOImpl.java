package com.exa.ems.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exa.ems.dao.EmployeeDAO;
import com.exa.ems.model.CommonConstant;
import com.exa.ems.model.Department;
import com.exa.ems.model.Designation;
import com.exa.ems.model.EmployeePersonalDetails;
import com.exa.ems.model.Location;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addEmployee(EmployeePersonalDetails employeePersonalDetails) {
		sessionFactory.getCurrentSession().saveOrUpdate(employeePersonalDetails);

	}

	@SuppressWarnings("unchecked")
	public List<EmployeePersonalDetails> getAllEmployees() {
		Integer status = 1;
		return sessionFactory.getCurrentSession().createQuery("from EmployeePersonalDetails WHERE status=:status")
				.setParameter("status", status) 
				.list();
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		Integer status = 0;
		String hql = "UPDATE EmployeePersonalDetails set status = :status WHERE empPkId = :employeeId";
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Query query = session.createQuery(hql);
		query.setParameter("employeeId", employeeId);
		query.setParameter("status", status);
		Integer result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
	}

	public EmployeePersonalDetails getEmployee(int empid) {
		return (EmployeePersonalDetails) sessionFactory.getCurrentSession()
				.get(EmployeePersonalDetails.class, empid);
	}

	@Override
	public EmployeePersonalDetails updateEmployee(EmployeePersonalDetails employeePersonalDetails) {
		sessionFactory.getCurrentSession().update(employeePersonalDetails);
		return employeePersonalDetails;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CommonConstant> getGenders(String string) {
		Session session = sessionFactory.getCurrentSession();
		List<CommonConstant> genders = new ArrayList<CommonConstant>();
		try {
				Criteria cr = session.createCriteria(CommonConstant.class);
				cr.add(Restrictions.eq("constantType", string));
				genders = cr.list();
				System.out.println("list genders : "+genders.toString()); 
				
		} catch (HibernateException he) {
			he.printStackTrace();
		}
		return genders;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CommonConstant> getGrades(String string) {
		Session session = sessionFactory.getCurrentSession();
		List<CommonConstant> grads = new ArrayList<CommonConstant>();
		try {
				Criteria cr = session.createCriteria(CommonConstant.class);
				cr.add(Restrictions.eq("constantType", string));
				grads = cr.list();
				System.out.println("list grads : "+grads.size()); 
				
		} catch (HibernateException he) {
			he.printStackTrace();
		}
		return grads;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CommonConstant> getEmpType(String string) {
		Session session = sessionFactory.getCurrentSession();
		List<CommonConstant> eType = new ArrayList<CommonConstant>();
		try {
				Criteria cr = session.createCriteria(CommonConstant.class);
				cr.add(Restrictions.eq("constantType", string));
				eType = cr.list();
				System.out.println("list genders : "+eType.size()); 
				
		} catch (HibernateException he) {
			he.printStackTrace();
		}
		return eType;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getDepartments() {
		Session session = sessionFactory.getCurrentSession();
		List<Department> departments = new ArrayList<Department>();
		try {
				Criteria cr = session.createCriteria(Department.class);
				departments = cr.list();
				System.out.println("list Department : "+departments.size()); 
				
		} catch (HibernateException he) {
			he.printStackTrace();
		}
		return departments;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> getLocations() {
		Session session = sessionFactory.getCurrentSession();
		List<Location> locations = new ArrayList<Location>();
		try {
				Criteria cr = session.createCriteria(Location.class);
				locations = cr.list();
				System.out.println("list Location : "+locations.size()); 
				
		} catch (HibernateException he) {
			he.printStackTrace();
		}
		return locations;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Designation> getDesignation() {
		Session session = sessionFactory.getCurrentSession();
		List<Designation> designations = new ArrayList<Designation>();
		try {
				Criteria cr = session.createCriteria(Designation.class);
				designations = cr.list();
				System.out.println("list Designation : "+designations.size()); 
				
		} catch (HibernateException he) {
			he.printStackTrace();
		}
		return designations;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer getMaxPkId() {
		Session session = sessionFactory.getCurrentSession();
		
	       Criteria criteria=session.createCriteria(EmployeePersonalDetails.class);
	       Integer maxId = 0;
	        criteria.setProjection(Projections.max("empPkId"));
			List<EmployeePersonalDetails> employeeList = (List<EmployeePersonalDetails>)criteria.list();
	        for(Object employee: employeeList){
	        	maxId = (Integer) employee;
	            System.out.println(employee+" uyutresedfghjkl "+maxId);
	        }

		return maxId;
	}
}