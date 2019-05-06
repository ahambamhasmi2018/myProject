package com.exa.ems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emp_personal_details")
public class EmployeePersonalDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_pk_id")
	private Integer empPkId;

	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;

	@Column(name="email")
	private String email;

	@Column(name="address")
	private String address;

	@ManyToOne
	@JoinColumn(name="location_fk_id")
	private Location locationFkId;
	
	@Column(name="doj")
	private String doj;
	
	@Column(name="hod_name")
	private String hodName;
	
	@ManyToOne
	@JoinColumn(name="designation_fk_id")
	private Designation designationFkId;
	
	@ManyToOne
	@JoinColumn(name="department_fk_id")
	private Department departmentFkId;
	
	@Column(name="besic_salary")
	private Double besicSalary;
	
	@Column(name="acc_no")
	private String accNo;
	
	@Column(name="telephone")
	private String telephone;
	
	@ManyToOne
	@JoinColumn(name="emp_type")
	private CommonConstant empTypeFkId;
	
	@Column(name="dob")
	private String dob;
	
	@ManyToOne
	@JoinColumn(name="emp_grade")
	private CommonConstant empGradeFkId;
	
	@ManyToOne
	@JoinColumn(name="gender_fk_id")
	private CommonConstant genderFkId;
	
	@Column(name="aadhar_card_no")
	private String aadharCardNo;
	
	@Column(name="pan_card_no")
	private String panCardNo;
	
	@Column(name="status")
	private Integer status;
	
	@Column(name="role")
	private String role;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;

	public Integer getEmpPkId() {
		return empPkId;
	}

	public void setEmpPkId(Integer empPkId) {
		this.empPkId = empPkId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Location getLocationFkId() {
		return locationFkId;
	}

	public void setLocationFkId(Location locationFkId) {
		this.locationFkId = locationFkId;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getHodName() {
		return hodName;
	}

	public void setHodName(String hodName) {
		this.hodName = hodName;
	}

	public Designation getDesignationFkId() {
		return designationFkId;
	}

	public void setDesignationFkId(Designation designationFkId) {
		this.designationFkId = designationFkId;
	}

	public Department getDepartmentFkId() {
		return departmentFkId;
	}

	public void setDepartmentFkId(Department departmentFkId) {
		this.departmentFkId = departmentFkId;
	}

	public Double getBesicSalary() {
		return besicSalary;
	}

	public void setBesicSalary(Double besicSalary) {
		this.besicSalary = besicSalary;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public CommonConstant getEmpTypeFkId() {
		return empTypeFkId;
	}

	public void setEmpTypeFkId(CommonConstant empTypeFkId) {
		this.empTypeFkId = empTypeFkId;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public CommonConstant getEmpGradeFkId() {
		return empGradeFkId;
	}

	public void setEmpGradeFkId(CommonConstant empGradeFkId) {
		this.empGradeFkId = empGradeFkId;
	}

	public CommonConstant getGenderFkId() {
		return genderFkId;
	}

	public void setGenderFkId(CommonConstant genderFkId) {
		this.genderFkId = genderFkId;
	}

	public String getPanCardNo() {
		return panCardNo;
	}

	public void setPanCardNo(String panCardNo) {
		this.panCardNo = panCardNo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public void setAadharCardNo(String aadharCardNo) {
		this.aadharCardNo = aadharCardNo;
	}
	public String getAadharCardNo() {
		return aadharCardNo;
	}
}