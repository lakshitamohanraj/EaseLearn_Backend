package com.lakshita.easelearn.request;

import java.time.LocalDate;

import com.lakshita.easelearn.entity.Profile;

public class ExperienceRequest {
 
    private Long id;

    private String name;         // Job Title
    private String description;  // Job Description
    private LocalDate startDate;
    private LocalDate endDate;
    
    public ExperienceRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ExperienceRequest(Long id, String name, String description, LocalDate startDate, LocalDate endDate) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	
    
    
    
}