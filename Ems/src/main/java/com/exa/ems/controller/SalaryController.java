package com.exa.ems.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exa.ems.model.EmployeePersonalDetails;
import com.exa.ems.model.SalaryDetails;
import com.exa.ems.services.EmpSalaeyServices;
import com.exa.ems.services.EmployeeService;

@Controller
public class SalaryController {
	
	@Autowired private EmpSalaeyServices empSalaeyServices;
	
	@Autowired private EmployeeService employeeService;
	
	@Autowired private HttpSession httpSession;
	
	@RequestMapping(value="admin/empSalaryDetails",method=RequestMethod.GET)
	public ModelAndView goSalary(@ModelAttribute("salaryDetails") SalaryDetails salaryDetails,ModelAndView model) {
		
		List<EmployeePersonalDetails> employees = null;
		List<SalaryDetails> salaryList  = null;
		try {
			employees = employeeService.getAllEmployees();
			salaryList = empSalaeyServices.getEmployeesSalary(); 
		} catch (Exception e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addObject("employees",employees);
		model.addObject("salaryList",salaryList);
		model.addObject("uName", httpSession.getAttribute("uName"));
		model.setViewName("salaryDetails");
		return model;
	}
	
	@RequestMapping(value="/admin/saveEmployeeSalary")
	public String saveSalary(@ModelAttribute("salaryDetails") SalaryDetails salaryDetails,Model m) {
		try {
			System.out.println("salaryDetails.getUsernameEmp() : "+ salaryDetails.getUsernameEmp()); 
			if(salaryDetails.getUsernameEmp() != null) {
				Integer empSalarySize = empSalaeyServices.getSalaryByEmpId(salaryDetails.getUsernameEmp());
				if(empSalarySize > 0) 
				{
					System.out.println("Please select employee code"); 
				}else {
					empSalaeyServices.saveEmpSalary(salaryDetails);	
				}
			}else {
				m.addAttribute("empcode","Please select employee code");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/empSalaryDetails"; 
	}
	
	@RequestMapping(value="/admin/employeeSalaryList")
	public String saveSalary(ModelAndView model) {
		empSalaeyServices.getEmployeesSalary(); 
		return "redirect:/admin/empSalaryDetails";
	}

}
