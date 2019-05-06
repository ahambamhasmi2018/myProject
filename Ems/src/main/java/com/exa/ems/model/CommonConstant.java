package com.exa.ems.model;

import javax.persistence.*;


@Entity
@Table(name="common_constant")
public class CommonConstant {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = -4037514607101222025L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="common_constant_pk_id")
	private Integer commonConstantPkId;
	
	@Column(name="constant_type")
	private String constantType;
	
	@Column(name="constant_value")
	private String constantValue;

	public Integer getCommonConstantPkId() {
		return commonConstantPkId;
	}

	public void setCommonConstantPkId(Integer commonConstantPkId) {
		this.commonConstantPkId = commonConstantPkId;
	}

	public String getConstantType() {
		return constantType;
	}

	public void setConstantType(String constantType) {
		this.constantType = constantType;
	}

	public String getConstantValue() {
		return constantValue;
	}

	public void setConstantValue(String constantValue) {
		this.constantValue = constantValue;
	}
	
	
}
