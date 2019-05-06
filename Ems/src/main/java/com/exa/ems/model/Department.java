package com.exa.ems.model;

import javax.persistence.*;

@Entity
@Table(name="department")
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="department_pk_id")
	private Integer departmentPkId;
	
	@Column(name="department_name")
	private String departmentName;

	public Integer getDepartmentPkId() {
		return departmentPkId;
	}

	public void setDepartmentPkId(Integer departmentPkId) {
		this.departmentPkId = departmentPkId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
}