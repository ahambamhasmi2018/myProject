package com.exa.ems.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exa.ems.dao.EmployeeSalaryDao;
import com.exa.ems.model.SalaryDetails;
import com.exa.ems.services.EmpSalaeyServices;

@Service
public class employeeSalaryServicesImpl implements EmpSalaeyServices {

	@Autowired
	private EmployeeSalaryDao employeeSalaryDao;
	
	@Override
	@Transactional
	public void saveEmpSalary(SalaryDetails salaryDetails) {
		salaryDetails.setStatus(1);
			Double ctc = salaryDetails.getEmpSalaryYear();
			Double bscSal = (ctc/100) * 10;
			Double hra = (ctc/100) * 12;
			Double allw = (ctc/100) * 5;
			Double pfs = (bscSal/100) * 12;
			Double others = ctc - (bscSal + hra + allw + pfs);
			System.out.println("CTC : "+(bscSal + hra + allw + pfs + others));
				salaryDetails.setBesicSalary(bscSal);
				salaryDetails.setEmpSalaryMonth(hra);
				salaryDetails.setAllowance(allw);
				salaryDetails.setPf(pfs); 
				salaryDetails.setOthers(others); 
		employeeSalaryDao.saveEmpSalary(salaryDetails); 
	}

	@Override
	@Transactional
	public List<SalaryDetails> getEmployeesSalary() {
		return employeeSalaryDao.getEmployeesSalary();
	}

	@Override
	@Transactional
	public Integer getSalaryByEmpId(String string) {
		return employeeSalaryDao.getSalaryByEmpId(string);  
	}

}
