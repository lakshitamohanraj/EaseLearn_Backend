package com.lakshita.easelearn.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;




@Entity
@Table(name = "teacher")

public class Teacher {
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
     private String name;
     
     @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
     private List<Course> courses;
     
     @OneToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "profile_id", referencedColumnName = "id")
     private Profile profile;
     
     @OneToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "user_id", referencedColumnName = "id")
     private User user;
     
    
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Teacher(Long id, String name, List<Course> courses, Profile profile, User user) {
		super();
		this.id = id;
		this.name = name;
		this.courses = courses;
		this.profile = profile;
		this.user = user;
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

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
     
     
}
