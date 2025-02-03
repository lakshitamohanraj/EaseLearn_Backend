package com.lakshita.easelearn.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	  
	  @ManyToMany
	    @JoinTable(
	        name = "student_course",
	        joinColumns = @JoinColumn(name = "student_id"),
	        inverseJoinColumns = @JoinColumn(name = "course_id")  //many to many bidirectional join
	    )
	  private List<Course> courses;
	  
	  @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 private List<Note> notes;
	  
	  
	  private LocalDate date_of_join;
	  
	     @OneToOne(cascade = CascadeType.ALL)
	     @JoinColumn(name = "user_id", referencedColumnName = "id")
	     private User user;
	     
	     

		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}
   
		public Student(Long id, String name, List<Course> courses, List<Note> notes, LocalDate date_of_join,
				User user) {
			super();
			this.id = id;
			this.name = name;
			this.courses = courses;
			this.notes = notes;
			this.date_of_join = date_of_join;
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

		public List<Note> getNotes() {
			return notes;
		}

		public void setNotes(List<Note> notes) {
			this.notes = notes;
		}

		public LocalDate getDate_of_join() {
			return date_of_join;
		}

		public void setDate_of_join(LocalDate date_of_join) {
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
