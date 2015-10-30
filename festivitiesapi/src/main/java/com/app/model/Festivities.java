package com.app.model;

import java.util.Date;

public class Festivities {
	
	private String id;
	private String name;
	private String startDate;
	private String endDate;
	private String place;
	
	
	
	public Festivities(String name, String startDate, String endDate,
			String place) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.place = place;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	
	

}
