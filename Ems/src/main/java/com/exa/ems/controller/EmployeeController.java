package com.exa.ems.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exa.ems.model.CommonConstant;
import com.exa.ems.model.Department;
import com.exa.ems.model.Designation;
import com.exa.ems.model.EmployeePersonalDetails;
import com.exa.ems.model.Location;
import com.exa.ems.services.EmployeeService;

@Controller
public class EmployeeController {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private HttpSession httpSession;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView goLogin(@ModelAttribute("employeePersonalDetails") EmployeePersonalDetails employeePersonalDetails,HttpSession httpSession) {
		ModelAndView model = new ModelAndView();
		System.out.println("goining to Login page through the EmployeeController");
		model.addObject("msg", "Please Enter Your Login Details") ;
		model.setViewName("login");
		return model;  
	}

	@RequestMapping(value= {"/admin/logout","/user/logout"},method=RequestMethod.GET)
	public ModelAndView logout(ModelAndView model) {
		httpSession.setAttribute("uName", null);
		model.addObject("logout","Logout successfully...!!");
		model.setViewName("redirect:/"); 
		return model;
	}
	
	@RequestMapping(value = "/admin/home")
	public String adminHome(HttpServletRequest request,Model model) throws IOException {
		model.addAttribute("uName", httpSession.getAttribute("uName"));
		model.addAttribute("role", httpSession.getAttribute("role"));
		model.addAttribute("name", httpSession.getAttribute("name"));
		String loginUser = (String) httpSession.getAttribute("uName");
		System.out.println("loginUser  : "+loginUser);
		if(loginUser == null) {
			return "redirect:/";
		}else {
			return "home";
		}
	}

	@RequestMapping(value = "/admin/empPersonalDetails",method=RequestMethod.GET)
	public ModelAndView listEmployee(ModelAndView model,HttpServletRequest request) throws IOException {
		List<EmployeePersonalDetails> listEmployee = employeeService.getAllEmployees();
		//HttpSession httpSession = request.getSession();
		model.addObject("uName", httpSession.getAttribute("uName"));
		model.addObject("role", httpSession.getAttribute("role"));
		model.addObject("listEmployee",listEmployee);
		String loginUser = (String) httpSession.getAttribute("uName");
		System.out.println("loginUser  : "+httpSession.getAttribute("role"));
		if(loginUser == null) {
			model.setViewName("redirect:/");
		}else {
			model.setViewName("empPersonalDetails");
		}
		return model;
	}


	@RequestMapping(value = "/admin/newEmployee", method = RequestMethod.GET)
	public ModelAndView newContact(@ModelAttribute("employeePersonalDetails") EmployeePersonalDetails employeePersonalDetails, ModelAndView model,HttpServletRequest request) {
		List<CommonConstant> genders  = employeeService.getGenders("gender");
		List<CommonConstant> eTypes  = employeeService.getEmpType("eType");
		List<CommonConstant> grads  = employeeService.getGrades("grade");
		List<Location> locations = employeeService.getLocations();
		List<Department> departments = employeeService.getDepartments();
		List<Designation> designations = employeeService.getDesignation();
		//EmployeePersonalDetails employee = new EmployeePersonalDetails();
		model.addObject("uName", httpSession.getAttribute("uName"));
		model.addObject("employeePersonalDetails", employeePersonalDetails);
		model.addObject("eTypes",eTypes);
		model.addObject("grads",grads);
		model.addObject("locations",locations);
		model.addObject("departments",departments);
		model.addObject("genders",genders);
		model.addObject("designations",designations);
		String loginUser = (String) httpSession.getAttribute("uName");
		System.out.println("loginUser  : "+loginUser);
		if(loginUser == null) {
			model.setViewName("redirect:/");
		}else {
			model.setViewName("EmployeeForm");
		}
		return model;
	}

	@RequestMapping(value = "/admin/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("employeePersonalDetails") EmployeePersonalDetails employeePersonalDetails,ModelAndView model) {
		System.out.println("hello save employee");
		employeePersonalDetails.setStatus(1); 
		Integer empId = employeePersonalDetails.getEmpPkId();
		System.out.println("empId : "+empId); 
		if (empId == null) { // if employee id is 0 then creating the
			// employee other updating the employee
			 Integer max = employeeService.getMaxPkId();
			 max = max + 1;
			 String uniqueUsername = "E00"+max;
			 System.out.println("uniqueUsername : "+uniqueUsername); 
			
			 employeePersonalDetails.setUsername(uniqueUsername);
			 employeeService.addEmployee(employeePersonalDetails);
		} else {
			model.addObject("updateMessage","employee details update successfully...!! ");
			employeeService.updateEmployee(employeePersonalDetails);
		}
		return new ModelAndView("redirect:/admin/empPersonalDetails");
	}

	@RequestMapping(value = "/admin/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@RequestParam("empPkId") Integer empPkId,ModelAndView model) {
		int employeeId =  empPkId/*Integer.parseInt(request.getParameter("id"))*/;
		employeeService.deleteEmployee(employeeId);
		model.addObject("delMessage","One record deleted successfully...!");
		return new ModelAndView("redirect:/admin/empPersonalDetails");
	}

	@RequestMapping(value = "/admin/editEmployee", method = RequestMethod.GET)
	public ModelAndView editContact(@RequestParam("empPkId") Integer empPkId) {
		int employeeId = empPkId;
		EmployeePersonalDetails employeePersonalDetails = employeeService.getEmployee(employeeId);
		List<CommonConstant> genders  = employeeService.getGenders("gender");
		List<CommonConstant> eTypes  = employeeService.getEmpType("eType");
		List<CommonConstant> grads  = employeeService.getGrades("grade");
		List<Location> locations = employeeService.getLocations();
		List<Department> departments = employeeService.getDepartments();
		List<Designation> designations = employeeService.getDesignation();
		
		ModelAndView model = new ModelAndView("EmployeeForm");
		model.addObject("employeePersonalDetails", employeePersonalDetails);
		model.addObject("uName", httpSession.getAttribute("uName"));
		model.addObject("eTypes",eTypes);
		model.addObject("grads",grads);
		model.addObject("locations",locations);
		model.addObject("departments",departments);
		model.addObject("genders",genders);
		model.addObject("designations",designations);
		return model;
	}
	/*   To get profile  employee....*/
	@RequestMapping(value = {"/admin/employeeProfile","/user/employeeProfile"}, method = RequestMethod.GET)
	public ModelAndView ShowProfileDetails(@RequestParam("empPkId") Integer empPkId) {
		int employeeId = empPkId;
		EmployeePersonalDetails employeePersonalDetails = employeeService.getEmployee(employeeId);
		ModelAndView model = new ModelAndView("EmployeeProfile");
		model.addObject("employeePersonalDetails", employeePersonalDetails);
		model.addObject("employeeId",employeeId);
		return model;
	}
}