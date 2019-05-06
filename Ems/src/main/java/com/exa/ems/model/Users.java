package com.exa.ems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_pk_id")
	private Integer userPkId;
	
	@NotNull
	@Column(name="user_name")
	private String username;
	
	@NotBlank
	@Column(name="password")
	private String password;
	
	@Column(name = "contact_no")
	private String contactNo;
	
	@Column(name="role")
	private String role;

	public Integer getUserPkId() {
		return userPkId;
	}
	public void setUserPkId(Integer userPkId) {
		this.userPkId = userPkId;
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

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
