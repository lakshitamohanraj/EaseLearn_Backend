package com.lakshita.easelearn.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "experience")


public class Experience {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;         // Job Title
	    private String description;  // Job Description
	    private LocalDate startDate;
	    private LocalDate endDate;

	
//	    @ManyToOne
//	    @JoinColumn(name = "profile_id", nullable = false)
//	    private Profile profile;

	    

		public Experience() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Experience(Long id, String name, String description, LocalDate startDate, LocalDate endDate) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.startDate = startDate;
			this.endDate = endDate;
//			this.profile = profile;
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


//		public Profile getProfile() {
//			return profile;
//		}
//
//
//		public void setProfile(Profile profile) {
//			this.profile = profile;
//		}
//	    
	    
}
