package com.lakshita.easelearn.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="profile")


 public class Profile {
	 @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	     private Long id;
		 private String description;
	 
		 @OneToMany(mappedBy = "profile",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
		 private List<Review> reviews;
      
	    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Education> education; // has proof

	    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Experience> experience; // no proof
      
	    private  String location;
      
      @ElementCollection
      private List<String> language;
      
      private LocalDate date_of_join;

      
      
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profile(Long id, String description, List<Review> reviews, List<Education> education,
			List<Experience> experience, String location, List<String> language, LocalDate date_of_join) {
		super();
		this.id = id;
		this.description = description;
		this.reviews = reviews;
		this.education = education;
		this.experience = experience;
		this.location = location;
		this.language = language;
		this.date_of_join = date_of_join;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Education> getEducation() {
		return education;
	}

	public void setEducation(List<Education> education) {
		this.education = education;
	}

	public List<Experience> getExperience() {
		return experience;
	}

	public void setExperience(List<Experience> experience) {
		this.experience = experience;
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

	public LocalDate getDate_of_join() {
		return date_of_join;
	}

	public void setDate_of_join(LocalDate date_of_join) {
		this.date_of_join = date_of_join;
	}
      
      
      
      
      
}
