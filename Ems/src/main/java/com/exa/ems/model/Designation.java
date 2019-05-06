package com.exa.ems.model;

import javax.persistence.*;


@Entity
@Table(name="designation")
public class Designation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="designation_pk_id")
	private Integer designationPkId;
	
	@Column(name="designation_name")
	private String designationName;
	
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}
	public String getDesignationName() {
		return designationName;
	}
	
	public Integer getDesignationPkId() {
		return designationPkId;
	}
	public void setDesignationPkId(Integer designationPkId) {
		this.designationPkId = designationPkId;
	}

}
