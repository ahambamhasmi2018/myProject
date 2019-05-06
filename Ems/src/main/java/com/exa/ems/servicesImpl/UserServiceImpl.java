package com.exa.ems.servicesImpl;

import java.util.List;

import javax.transaction.Transactional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exa.ems.dao.LeaveDao;
import com.exa.ems.dao.UserDao;
import com.exa.ems.model.EmployeeLeaveDetailse;
import com.exa.ems.model.EmployeePersonalDetails;
import com.exa.ems.model.SalaryDetails;
import com.exa.ems.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired private UserDao userDao;
	@Autowired private LeaveDao leaveDao;
	
	@Transactional
	public List<EmployeePersonalDetails> getPersonalDetilById(String loginUser) {
		return userDao.getPersonalDetilById(loginUser);  
	}

	@Override
	@Transactional
	public List<EmployeeLeaveDetailse> getLeaveById(String loginUser) {
		return userDao.getLeaveById(loginUser);  
	}

	@Override
	@Transactional
	public List<SalaryDetails> getUserSalaryById(String loginUser) {
		return userDao.getUserSalaryById(loginUser); 
	}

	@Override
	@Transactional
	public void userTakeLeave(EmployeeLeaveDetailse employeeLeaveDetailse) {
		Integer balL = 0,vBalL = 0,sBalL = 0;
		String typeL = employeeLeaveDetailse.getLeaveType();
		System.out.println(employeeLeaveDetailse.getVacationLeave()+" : employeeLeaveDetailse.getVacationLeave()");
		if(employeeLeaveDetailse.getBalanceLeave() >= 1) {
			if(employeeLeaveDetailse.getLeavetaken() <= employeeLeaveDetailse.getBalanceLeave()) 
			{ 
				balL = employeeLeaveDetailse.getTotalLeaves() - employeeLeaveDetailse.getLeavetaken();
				System.out.println("balL : "+balL);
				employeeLeaveDetailse.setBalanceLeave(balL);
				employeeLeaveDetailse.setTotalLeaves(balL);
				
				if(typeL.equals("vacation")) {
					vBalL = employeeLeaveDetailse.getVacationLeave() - employeeLeaveDetailse.getLeavetaken();
					employeeLeaveDetailse.setVacationLeave(vBalL);
				}else {
					sBalL = employeeLeaveDetailse.getSickLeave() - employeeLeaveDetailse.getLeavetaken();
					employeeLeaveDetailse.setSickLeave(sBalL);
				}
				
			}else{
			System.out.println("balance leave shuld be greater than taking leave");
		}}else {
			System.out.println("Out of box");
		}
		employeeLeaveDetailse.setStatus(0);
		userDao.userTakeLeave(employeeLeaveDetailse);  
	}

	@Override
	@Transactional
	public EmployeePersonalDetails getPersonalDetilByPkId(Integer empPkId) {
		return userDao.getPersonalDetilByPkId(empPkId);
	}

	@Override
	@Transactional
	public void setCancelLeave(Integer empLeavePkId) {
		EmployeeLeaveDetailse employeeLeaveDetailse = leaveDao.getByLeaveId(empLeavePkId);
		  Integer status = 4,bL =0,takL = 0,totBalL = 0,sL = 0,vL = 0;
		   try {
			   	bL = employeeLeaveDetailse.getBalanceLeave();
			   	takL = employeeLeaveDetailse.getLeavetaken();
			   	vL = employeeLeaveDetailse.getVacationLeave();
			   	sL = employeeLeaveDetailse.getSickLeave();
			    totBalL = bL + takL;
			    if("vacation".equals(employeeLeaveDetailse.getLeaveType())) {
			    	vL = vL + takL;
			    	employeeLeaveDetailse.setVacationLeave(vL);
			    }else {
			    	sL =sL + takL;
			    	employeeLeaveDetailse.setSickLeave(sL);
			    }
			    
				employeeLeaveDetailse.setBalanceLeave(totBalL);
				employeeLeaveDetailse.setTotalLeaves(totBalL);
				employeeLeaveDetailse.setLeavetaken(takL - takL);
				employeeLeaveDetailse.setStatus(status);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		userDao.setCancelLeave(empLeavePkId, employeeLeaveDetailse); 
	}

}
