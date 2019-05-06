package com.exa.ems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp_leave_details")
public class EmployeeLeaveDetailse{
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_leave_pk_id")
	private Integer empLeavePkId;
	
	@Column(name="usernameEmp")
	private String usernameEmp;
	
	@Column(name="total_leavs")
	private Integer totalLeaves;
	
	@Column(name="balance_leave")
	private Integer balanceLeave;
	
	@Column(name="sick_leave")
	private Integer sickLeave;
	
	@Column(name="leaveType")
	private String leaveType;
	
	@Column(name="vacation_leave")
	private Integer vacationLeave;
	
	@Column(name="leave_taken")
	private Integer leavetaken;
	
	@Column(name="leave_from_date")
	private String leaveFromDate;
	
	@Column(name="leave_to_date")
	private String leaveToDate;
	
	@Column(name="status")
	private Integer status;

	public Integer getEmpLeavePkId() {
		return empLeavePkId;
	}

	public void setEmpLeavePkId(Integer empLeavePkId) {
		this.empLeavePkId = empLeavePkId;
	}

	public String getUsernameEmp() {
		return usernameEmp;
	}

	public void setUsernameEmp(String usernameEmp) {
		this.usernameEmp = usernameEmp;
	}

	public Integer getTotalLeaves() {
		return totalLeaves;
	}

	public void setTotalLeaves(Integer totalLeaves) {
		this.totalLeaves = totalLeaves;
	}

	public Integer getBalanceLeave() {
		return balanceLeave;
	}

	public void setBalanceLeave(Integer balanceLeave) {
		this.balanceLeave = balanceLeave;
	}

	public Integer getLeavetaken() {
		return leavetaken;
	}

	public void setLeavetaken(Integer leavetaken) {
		this.leavetaken = leavetaken;
	}

	public String getLeaveFromDate() {
		return leaveFromDate;
	}

	public void setLeaveFromDate(String leaveFromDate) {
		this.leaveFromDate = leaveFromDate;
	}

	public String getLeaveToDate() {
		return leaveToDate;
	}

	public void setLeaveToDate(String leaveToDate) {
		this.leaveToDate = leaveToDate;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getStatus() {
		return status;
	}

	public Integer getSickLeave() {
		return sickLeave;
	}

	public void setSickLeave(Integer sickLeave) {
		this.sickLeave = sickLeave;
	}

	public Integer getVacationLeave() {
		return vacationLeave;
	}

	public void setVacationLeave(Integer vacationLeave) {
		this.vacationLeave = vacationLeave;
	}
	
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	
	public String getLeaveType() {
		return leaveType;
	}
}
