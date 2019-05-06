package com.exa.ems.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exa.ems.dao.LeaveDao;
import com.exa.ems.model.EmployeeLeaveDetailse;
import com.exa.ems.services.LeaveService;

@Service
public class LeaveServiceImpl implements LeaveService {

	@Autowired
	private LeaveDao leaveDao;
	
	@Override
	@Transactional
	public List<EmployeeLeaveDetailse> getAllLeaves() {
		return leaveDao.getAllLeaves();
	}

	@Override
	@Transactional
	public void saveLeaves(EmployeeLeaveDetailse employeeLeaveDetailse) {

		Integer balL = 0;
		
		System.out.println(employeeLeaveDetailse.getBalanceLeave()+" : employeeLeaveDetailse.getLeavetaken()");
		 balL = employeeLeaveDetailse.getTotalLeaves() - employeeLeaveDetailse.getLeavetaken();
		 employeeLeaveDetailse.setBalanceLeave(balL);
		 employeeLeaveDetailse.setStatus(1);
		leaveDao.saveLeaves(employeeLeaveDetailse); 
	}

	@Override
	@Transactional
	public Integer getLeaveByEmpId(String usernameEmp) {
		return leaveDao.getLeaveByEmpId(usernameEmp); 
	}

	@Override
	@Transactional
	public void setAcceptLeave(Integer empLeavePkId) {
		leaveDao.setAcceptLeave(empLeavePkId);
	}

	@Override
	@Transactional
	public void setRejectLeave(Integer empLeavePkId) {
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
		leaveDao.setRejectLeave(empLeavePkId,employeeLeaveDetailse); 
	}
}
