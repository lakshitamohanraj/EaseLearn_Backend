package com.lakshita.easelearn.request;

import java.time.LocalDate;
import java.util.List;

public class ProfileRequest {
    private String description;
    private String location;
    private List<String> language;
    private LocalDate dateOfJoin;
    private List<EducationRequest> education;
    private List<ExperienceRequest> experience;
    
    
	public ProfileRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProfileRequest(String description, String location, List<String> language, LocalDate dateOfJoin,
			List<EducationRequest> education, List<ExperienceRequest> experience) {
		super();
		this.description = description;
		this.location = location;
		this.language = language;
		this.dateOfJoin = dateOfJoin;
		this.education = education;
		this.experience = experience;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<String> getLanguage() {
		return language;
	}
	public void setLanguage(List<String> language) {
		this.language = language;
	}
	public LocalDate getDateOfJoin() {
		return dateOfJoin;
	}
	public void setDateOfJoin(LocalDate dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	public List<EducationRequest> getEducation() {
		return education;
	}
	public void setEducation(List<EducationRequest> education) {
		this.education = education;
	}
	public List<ExperienceRequest> getExperience() {
		return experience;
	}
	public void setExperience(List<ExperienceRequest> experience) {
		this.experience = experience;
	}
    
    
}