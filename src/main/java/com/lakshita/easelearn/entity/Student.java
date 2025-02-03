package com.lakshita.easelearn.entity;

import java.util.Date;
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
@Table(name="student")

public class Student {
	
	private static final long serialVersionUID = 1L;
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private Long id;
	  
	  private String name;
	  
	  @OneToMany
	  List<Course> course;
	  List<Note> notes;
	  Date date_of_join;
	  
	  @OneToOne
	  User user;

	  // contructor included email , password to create user record
	public Student(Long id, String name, String email,
			String password,List<Course> studies, List<Note> notes, Date date_of_join) {
		super();
		setUser(new User(id,email,name,password,"student")); // creating new user with assigned role - lil confused but followed this way in git 
		this.id = id;
		this.name = name;
		this.course = studies;
		this.notes = notes;
		this.date_of_join = date_of_join;
		
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

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public Date getDate_of_join() {
		return date_of_join;
	}

	public void setDate_of_join(Date date_of_join) {
		this.date_of_join = date_of_join;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	  
}
