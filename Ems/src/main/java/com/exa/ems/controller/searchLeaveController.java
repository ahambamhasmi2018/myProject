package com.exa.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.exa.ems.model.EmployeeLeaveDetailse;
import com.exa.ems.model.EmployeePersonalDetails;
import com.exa.ems.model.SalaryDetails;
import com.exa.ems.services.SearchServices;

@Controller
public class searchLeaveController {
	
	@Autowired private SearchServices searchServices;
	
	
	@RequestMapping(value="/admin/searchEmployeeLeaves",method = RequestMethod.GET,produces = "application/json") 
	public ModelAndView  searchEmployeeLeaves(@RequestParam("usernameEmp") String usernameEmp,@ModelAttribute("") EmployeeLeaveDetailse employeeLeaveDetailse,ModelAndView model){
			List<EmployeeLeaveDetailse> listOfLeavesbyId = searchServices.getSearchLeavesById(usernameEmp);
			System.out.println("size : "+listOfLeavesbyId.size()); 
			model.addObject("listOfLeavesbyId", listOfLeavesbyId);
			model.addObject("size",listOfLeavesbyId.size());
			model.setViewName("leaveDetails");
		return model;
	}
		
	@RequestMapping(value="/admin/searchEmployee/{empCode}",method = RequestMethod.GET,produces = "application/json") 
	public @ResponseBody List<EmployeePersonalDetails> searchEmployee(@PathVariable String empCode){
			List<EmployeePersonalDetails> employeeByEmpCode = searchServices.getEmployeeProfileByEmpCode(empCode);  
		return employeeByEmpCode;
	}
	
	@RequestMapping(value="/admin/searchEmployeeProfileById",method = RequestMethod.GET) 
	public ModelAndView searchEmployeeProfile(@RequestParam("username") String username,
			@ModelAttribute("EmployeePersonalDetails") EmployeePersonalDetails employeePersonalDetails,ModelAndView model){
			List<EmployeePersonalDetails> employeeByEmpCode = searchServices.getEmployeeProfileByEmpCode(username);
			String eCode = null;
			for (EmployeePersonalDetails employeePersonalDetails2 : employeeByEmpCode) {
				eCode = employeePersonalDetails2.getUsername();
			}
			if(username.equals(eCode)) {
			}else {
				model.addObject("msg", username+" Employee code does not matched");
				
			}
			model.addObject("employeeByEmpCode", employeeByEmpCode);
			System.out.println("employeeByEmpCode : "+employeeByEmpCode); 
			model.addObject("size", employeeByEmpCode.size());
		model.setViewName("EmployeeProfile");
		return model;
	}
		
	@RequestMapping(value="/admin/searchEmployeeSalary/{empCode}",method = RequestMethod.GET,produces = "application/json") 
	public @ResponseBody List<SalaryDetails> searchEmployeeSalary(@PathVariable String empCode){
			List<SalaryDetails> salaryByEcode = searchServices.getEmployeeSalaryByEmpCode(empCode);  
		return salaryByEcode;
	}
}
