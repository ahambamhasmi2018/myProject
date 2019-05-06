package com.exa.ems.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import com.exa.ems.model.SalaryDetails;
import com.exa.ems.services.UserService;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Controller
public class UserController {
	
	@Autowired private HttpSession httpSession;
	@Autowired private UserService userService;

	
	@RequestMapping(value = {"/user/userHome","/admin/userHome"})
	public String userHome(HttpServletRequest request,Model model) throws IOException {
		model.addAttribute("uName", httpSession.getAttribute("uName"));
		model.addAttribute("role", httpSession.getAttribute("role"));
		model.addAttribute("name", httpSession.getAttribute("name"));
		String loginUser = (String) httpSession.getAttribute("uName");
		System.out.println("loginUser  : "+loginUser);
		System.out.println("First NAme : "+httpSession.getAttribute("name")); 
		if(loginUser == null) {
			return "redirect:/";
		}else {
			return "userHome";
		}
	}
	
	@RequestMapping(value = {"/user/userPersonalDetails","/admin/userPersonalDetails"},method=RequestMethod.GET)
	public String userPersonalDetails(HttpServletRequest request,Model model) throws IOException {
		model.addAttribute("uName", httpSession.getAttribute("uName"));
		String loginUser = (String) httpSession.getAttribute("uName");
		List<EmployeePersonalDetails> employeePersonalDetails = userService.getPersonalDetilById(loginUser);
		model.addAttribute("employeePersonalDetails", employeePersonalDetails);
		System.out.println("loginUser  : "+loginUser);
		if(loginUser == null) {
			return "redirect:/";
		}else {
			return "userPersonalDetails";
		}
	}
	
	@RequestMapping(value = {"/user/userLeaves","/admin/userLeaves"},method=RequestMethod.GET)
	public String userLeaves(@ModelAttribute("employeeLeaveDetailse") EmployeeLeaveDetailse employeeLeaveDetailse, HttpServletRequest request,Model model) throws IOException {
		model.addAttribute("uName", httpSession.getAttribute("uName"));
		String loginUser = (String) httpSession.getAttribute("uName");
		Integer balence = 0,leavId = 0,takeL = 0,tLeave = 0,sickL = 0, vacL = 0;
		String lType = null;
		List<EmployeeLeaveDetailse> empLeaves = userService.getLeaveById(loginUser);
		for (EmployeeLeaveDetailse employeeLeaveDetailse2 : empLeaves) { 
			System.out.println(employeeLeaveDetailse2.getBalanceLeave());
			balence = employeeLeaveDetailse2.getBalanceLeave();
			leavId = employeeLeaveDetailse2.getEmpLeavePkId();
			takeL = employeeLeaveDetailse2.getLeavetaken();
			tLeave = employeeLeaveDetailse2.getTotalLeaves();
			lType = employeeLeaveDetailse2.getLeaveType();
			vacL = employeeLeaveDetailse2.getVacationLeave();
			sickL = employeeLeaveDetailse2.getSickLeave();
			
		}
	//	System.out.println("00000000----------------------------------------- :"+empLeaves.getEmpLeavePkId());
		System.out.println(takeL+" : employeeLeaveDetailse2");
		model.addAttribute("role", httpSession.getAttribute("role"));
		List<Integer> leaves = new ArrayList<Integer>();
		try {
			for(Integer i = 0 ; i <= 12 ;i++) {
				leaves.add(i);
			}
			System.out.println("Leave size :"+leaves.size());
		} catch (Exception e) { 
			e.printStackTrace();
		}
		System.out.println("balence  :"+sickL); 
		model.addAttribute("leaves",leaves);
		model.addAttribute("empLeaves", empLeaves);
		model.addAttribute("balanceLeave", balence);
		model.addAttribute("LeaveId", leavId);
		model.addAttribute("tLeave", tLeave);
		model.addAttribute("takenLeave", takeL);
		model.addAttribute("lType", lType);
		model.addAttribute("sickL", sickL);
		model.addAttribute("vacL", vacL);
		System.out.println("loginUser  : "+loginUser);
		if(loginUser == null) {
			return "redirect:/";
		}else {
			return "userleaveDetails";
		}
	}
	
	@RequestMapping(value= {"/user/saveUserLeaves","/admin/saveUserLeaves"},method=RequestMethod.POST)
	public String saveLeaves(@ModelAttribute("employeeLeaveDetailse") EmployeeLeaveDetailse employeeLeaveDetailse,Model model ) {
			userService.userTakeLeave(employeeLeaveDetailse);
		return "redirect:/user/userLeaves";
	}
	
	@RequestMapping(value= {"/user/cancelUserLeaves","/admin/cancelUserLeaves"},method=RequestMethod.GET)
		public String CancelStatus(@RequestParam("empLeavePkId") Integer empLeavePkId) {
			userService.setCancelLeave(empLeavePkId);
		return "redirect:/user/userLeaves";
	}
	
	@RequestMapping(value= {"/user/userSalaryDetails","/admin/userSalaryDetails"},method=RequestMethod.GET)
	public ModelAndView userSalaryDetails(@ModelAttribute("salaryDetails") SalaryDetails salaryDetails,ModelAndView model ) {
		model.addObject("uName", httpSession.getAttribute("uName"));
		String loginUser = (String) httpSession.getAttribute("uName");
		List<SalaryDetails> userSalary = userService.getUserSalaryById(loginUser);
		model.addObject("userSalary", userSalary);
		model.setViewName("userSalary");
		return model;
	}
	
	@RequestMapping(value= {"user/createPdf","admin/createPdf"},method=RequestMethod.GET)
	public String getPdf(@RequestParam("empPkId") Integer empPkId,Model model) throws DocumentException, 
			URISyntaxException,BadElementException, IOException {
		String loginUser = (String) httpSession.getAttribute("uName");
		List<EmployeePersonalDetails> employeePersonalDetails = userService.getPersonalDetilById(loginUser);
		System.out.println("empPkId : "+empPkId);
		String file = "F:\\apache-tomcat-9.0.0.M26-windows-x64\\apache-tomcat-9.0.0.M26\\webapps\\pdf\\profile_"+loginUser+".pdf";
		EmployeePersonalDetails employee = userService.getPersonalDetilByPkId(empPkId);
		String name = employee.getFirstname()+ " "+employee.getLastname();
		System.out.println("employeePersonalDetails size :"+employee.getUsername());
		System.out.println("file : "+file); 
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(file));
		String path = "F:\\OxygenWorkSpace\\Ems\\src\\main\\webapp\\WEB-INF\\views\\exa.png";
		System.out.println("path : "+path); 
		document.open();
		Image img = Image.getInstance(path);
		img.setAlignment(Image.ALIGN_RIGHT);
		document.add(img);
		//String imageUrl = "F:\\exa.png";
    
		Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
		Chunk chunk = new Chunk("Name : "+name, font);
		document.add(chunk);
		document.add(new Paragraph("\n\n"));
		//document.add(new Phrase("\n"));
		PdfPTable table = new PdfPTable(2);
	//	addTableHeader(table);
		addRows(table,empPkId);
	//	addCustomRows(table);
		 
		document.add(table);
		document.close();
		model.addAttribute("employee", employee);
		model.addAttribute("employeePersonalDetails", employeePersonalDetails);
		model.addAttribute("createPDF", "Profile pdf file created successfully...");
		return "userPersonalDetails";
	}

	private void addRows(PdfPTable table,Integer empPkId) {
		EmployeePersonalDetails employee = userService.getPersonalDetilByPkId(empPkId);
		table.addCell("Employee Code");
	    table.addCell(employee.getUsername());
		table.addCell("Address");
	    table.addCell(employee.getAddress());
		table.addCell("Gender");
	    table.addCell(employee.getGenderFkId().getConstantValue());
		table.addCell("Email");
	    table.addCell(employee.getEmail());
		table.addCell("Location");
	    table.addCell(employee.getLocationFkId().getLocationName());
		table.addCell("Date of Birth");
	    table.addCell(employee.getDob());
		table.addCell("Date of Joining");
	    table.addCell(employee.getDoj());
		table.addCell("Hod Name");
	    table.addCell(employee.getHodName());
		table.addCell("Department");
	    table.addCell(employee.getDepartmentFkId().getDepartmentName());
		table.addCell("Designation");
	    table.addCell(employee.getDesignationFkId().getDesignationName());
		table.addCell("Account No");
	    table.addCell(employee.getAccNo());
		table.addCell("Employee Type");
	    table.addCell(employee.getEmpTypeFkId().getConstantValue());
		table.addCell("Contact No");
	    table.addCell(employee.getTelephone());
		table.addCell("Grade");
	    table.addCell(employee.getEmpGradeFkId().getConstantValue());
	}

	/*private void addTableHeader(PdfPTable table) {
	    Stream.of("column header 1", "column header 2")
	     .forEach(columnTitle -> {
	         PdfPCell header = new PdfPCell();
	         header.setBackgroundColor(BaseColor.LIGHT_GRAY);
	         header.setBorderWidth(2);
	         header.setPhrase(new Phrase(columnTitle));
	         table.addCell(header);
	     });
	}*/
}
