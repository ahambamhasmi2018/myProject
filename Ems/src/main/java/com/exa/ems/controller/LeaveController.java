package com.exa.ems.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exa.ems.model.EmployeeLeaveDetailse;
import com.exa.ems.model.EmployeePersonalDetails;
import com.exa.ems.services.EmployeeService;
import com.exa.ems.services.LeaveService;

@Controller
public class LeaveController {
	
	@Autowired private EmployeeService employeeService;
	
	@Autowired private LeaveService leaveService;
	
	@Autowired private HttpSession httpSession;
	
	@RequestMapping(value="/admin/empLeaves",method=RequestMethod.GET)
	public ModelAndView goLeaveDetails(@ModelAttribute("employeeLeaveDetailse") EmployeeLeaveDetailse employeeLeaveDetailse,ModelAndView model ) 
	{
		
		List<EmployeePersonalDetails> employees = null;
		List<EmployeeLeaveDetailse> leaveList  = null;
		List<Integer> leaves = new ArrayList<Integer>();
		try {
			employees = employeeService.getAllEmployees();
			leaveList = leaveService.getAllLeaves();
			for(Integer i = 0 ; i <= 12 ;i++) {
				leaves.add(i);
			}
		} catch (Exception e) { 
			e.printStackTrace();
		}
		model.addObject("employees",employees);
		model.addObject("leaveList",leaveList);
		model.addObject("leaves",leaves);
		model.addObject("uName", httpSession.getAttribute("uName"));
		model.setViewName("leaveDetails");
		return model;
	}
	
	@RequestMapping(value="/admin/saveEmployeeLeaves",method=RequestMethod.POST)
	public String saveLeaves(@ModelAttribute("employeeLeaveDetailse") EmployeeLeaveDetailse employeeLeaveDetailse,Model model ) {
			
		try {
			System.out.println("employeeLeaveDetailse.getUsernameEmp() : "+ employeeLeaveDetailse.getUsernameEmp()); 
			if(employeeLeaveDetailse.getUsernameEmp() != null) {
				Integer empLeaveSize = leaveService.getLeaveByEmpId(employeeLeaveDetailse.getUsernameEmp());
				if(empLeaveSize > 0) 
				{
					System.out.println("Please select employee code"); 
					//leaveService.saveLeaves(employeeLeaveDetailse);
				}else {
					leaveService.saveLeaves(employeeLeaveDetailse);
				}
			}else {
				System.out.println("Please select employee code.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/empLeaves";
	}
	
	@RequestMapping(value = "/admin/acceptStatus", method = RequestMethod.GET)
	public String AcceptStatus(@RequestParam("empLeavePkId") Integer empLeavePkId) {
			leaveService.setAcceptLeave(empLeavePkId);
		return "redirect:/admin/empLeaves";
	}
	@RequestMapping(value = "/admin/rejectStatus", method = RequestMethod.GET)
	public String RejectStatus(@RequestParam("empLeavePkId") Integer empLeavePkId) {
			leaveService.setRejectLeave(empLeavePkId);
		return "redirect:/admin/empLeaves";
	}
}
