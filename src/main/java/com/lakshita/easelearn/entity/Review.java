package com.lakshita.easelearn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="review")

public class Review {
   Long id;
   
   @ManyToOne
   Student student; // many students
   Rating rate;
   String comment;
		public Review(Long id, Student student, Rating rate, String comment) {
			super();
			this.id = id;
			this.student = student;
			this.rate = rate;
			this.comment = comment;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Student getStudent() {
			return student;
		}
		public void setStudent(Student student) {
			this.student = student;
		}
		public Rating getRate() {
			return rate;
		}
		public void setRate(Rating rate) {
			this.rate = rate;
		}
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
		}
   
} 
