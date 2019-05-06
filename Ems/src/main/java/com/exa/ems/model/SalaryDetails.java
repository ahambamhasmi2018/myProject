package com.exa.ems.model;

import javax.persistence.*;

@Entity
@Table(name="salary_details")
public class SalaryDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="salary_pk_id")
	private Integer salaryPkId;
	
	@Column(name = "usernameEmp")
	private String usernameEmp;
	
	@Column(name="emp_salary_month")
	private Double empSalaryMonth;
	
	@Column(name="emp_salary_year")
	private Double empSalaryYear;
	
	@Column(name="salary_date")
	private String salaryDate;
	
	@Column(name="besic_salary")
	private Double besicSalary;
	
	@Column(name="pf")
	private Double pf;
	
	@Column(name="allowance")
	private Double allowance;

	@Column(name="others")
	private Double others;
	
	@Column(name="status")
	private Integer status;

	public Integer getSalaryPkId() {
		return salaryPkId;
	}

	public void setSalaryPkId(Integer salaryPkId) {
		this.salaryPkId = salaryPkId;
	}

	public String getSalaryDate() {
		return salaryDate;
	}

	public Double getEmpSalaryMonth() {
		return empSalaryMonth;
	}

	public void setEmpSalaryMonth(Double empSalaryMonth) {
		this.empSalaryMonth = empSalaryMonth;
	}

	public Double getEmpSalaryYear() {
		return empSalaryYear;
	}

	public void setEmpSalaryYear(Double empSalaryYear) {
		this.empSalaryYear = empSalaryYear;
	}

	public void setSalaryDate(String salaryDate) {
		this.salaryDate = salaryDate;
	}

	public Double getBesicSalary() {
		return besicSalary;
	}

	public void setBesicSalary(Double besicSalary) {
		this.besicSalary = besicSalary;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getUsernameEmp() {
		return usernameEmp;
	}
	
	public void setUsernameEmp(String usernameEmp) {
		this.usernameEmp = usernameEmp;
	}

	public Double getPf() {
		return pf;
	}

	public void setPf(Double pf) {
		this.pf = pf;
	}

	public Double getAllowance() {
		return allowance;
	}

	public void setAllowance(Double allowance) {
		this.allowance = allowance;
	}
	public void setOthers(Double others) {
		this.others = others;
	}
	public Double getOthers() {
		return others;
	}
	
}
