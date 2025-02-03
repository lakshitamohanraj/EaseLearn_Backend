package com.lakshita.easelearn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="note")



public class Note {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
    private String subject;
    
    private String content ; // can be enhanced later
	
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
    
    

	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Note(Long id, String subject, String content, Student student) {
		super();
		this.id = id;
		this.subject = subject;
		this.content = content;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
    
    
    
}
