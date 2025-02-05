package com.lakshita.easelearn.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "course")


public class Course {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String description;
	    private LocalDate startDate;
	    private LocalDate endDate;
	    private boolean isSelected;

	    @ManyToOne
	    @JoinColumn(name = "teacher_id", nullable = false)
	    private Teacher teacher;

	    // Many students can enroll in many courses
	    @ManyToMany(mappedBy = "courses")
	    private List<Student> students;
	    
	    

		
		public Course() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Course(Long id, String description, LocalDate startDate, LocalDate endDate, boolean isSelected,
				Teacher teacher,List<Student> students) {
			super();
			this.id = id;
			this.description = description;
			this.startDate = startDate;
			this.endDate = endDate;
			this.isSelected = isSelected;
			this.teacher = teacher;
			this.students = students;
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
		public List<Student> getStudents() {
			return students;
		}

		public void setStudents(List<Student> students) {
			this.students = students;
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

		public boolean isSelected() {
			return isSelected;
		}

		public void setSelected(boolean isSelected) {
			this.isSelected = isSelected;
		}

		public Teacher getTeacher() {
			return teacher;
		}

		public void setTeacher(Teacher teacher) {
			this.teacher = teacher;
		}
	    
	    
       
}
