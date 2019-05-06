package com.exa.ems.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exa.ems.model.EmployeePersonalDetails;
import com.exa.ems.services.LoginServices;

@Controller
public class LoginController {
	
	@Autowired
	private LoginServices loginServices;
	
	@RequestMapping(value="/loginAuthantication",method=RequestMethod.POST)
	public String loginAuthentication(@ModelAttribute("employeePersonalDetails") EmployeePersonalDetails employeePersonalDetails,Model model,HttpSession httpSession) {
		String username = employeePersonalDetails.getUsername();
		String password = employeePersonalDetails.getPassword();
		String name = null;
		String role = null;
		Integer check = 0;
		httpSession.setAttribute("uName", username);
		httpSession.setAttribute("role", role); 
		httpSession.setAttribute("name", name);
		List<EmployeePersonalDetails> elUser = loginServices.loginAuthEmp(username,password);
		System.out.println("hello ..................... : "+elUser.toString()); 
		
		for (EmployeePersonalDetails employeePersonalDetails2 : elUser) {
			if(employeePersonalDetails2.getRole().equals("Admin")) {
				check = 1;
				role = employeePersonalDetails2.getRole();
				name = employeePersonalDetails2.getFirstname();
			}else {
				check = 1;
				role = employeePersonalDetails2.getRole();
				name = employeePersonalDetails2.getFirstname();
			}
		}
		httpSession.setAttribute("role", role); 
		httpSession.setAttribute("name", name);
		System.out.println("Check : "+check); 
		if(check  > 0) {
			if(role.equals("Admin")) {
				return "redirect:/admin/home";
			}else if(role.equals("User")){
				return "redirect:/user/userHome";
			}
		}else {
				model.addAttribute("error", "Invalid Credentials!!!");
				return "login";
		}
		return role;
		}
}
