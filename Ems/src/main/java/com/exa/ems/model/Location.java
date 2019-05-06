package com.exa.ems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="location")
public class Location {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="location_pk_id")
	private Integer locationPkId;
	
	@Column(name="location_name")
	private String locationName;

	public Integer getLocationPkId() {
		return locationPkId;
	}

	public void setLocationPkId(Integer locationPkId) {
		this.locationPkId = locationPkId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	
}
