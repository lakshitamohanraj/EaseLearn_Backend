package com.lakshita.easelearn.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name="teacher")
public class Teacher {
	@Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
     Long id;
     String name;
     
     @OneToMany
     List<Course> course;
     @OneToOne
     Profile profile;
     @OneToOne
     User user;
     // contructor included email , password to create user record
	public Teacher(Long id, String name,String email,String password, List<Course> course, Profile profile, User user) {
		super();
		setUser(new User(id,email,name,password,"teacher"));
		this.id = id;
		this.name = name;
		this.course = course;
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
	public List<Course> getCourse() {
		return course;
	}
	public void setCourse(List<Course> course) {
		this.course = course;
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
