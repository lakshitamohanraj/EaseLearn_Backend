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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Table(name="profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

 public class Profile {
	 @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Long id;
	 private String description;
	 private List<Review> reviews;
      
	 @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 private List<Knowledge> education;
      
	 @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 private List<Knowledge> experience;
      
	 private  String location;
      
      @ElementCollection
      private List<String> language;
      
      private LocalDate date_of_join;
}
