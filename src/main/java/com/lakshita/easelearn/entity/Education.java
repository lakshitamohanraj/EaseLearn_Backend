package com.lakshita.easelearn.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "education")


public class Education {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;         // Degree Name
    private String description;  // Course Details
    private LocalDate startDate;
    private LocalDate endDate;

    private boolean verified = false;  // Admin verification

    @Lob
    @Column(columnDefinition = "TEXT")
    private String proofFile;   // e.g., "IMAGE", "PDF"
    private String proofURL;    // Storage URL of proof document

//    @ManyToOne
//    @JoinColumn(name = "profile_id", nullable = false)
//    private Profile profile;

    
    
	public Education() {
		super();
		// TODO Auto-generated constructor stub
	}

	 
	public Education(Long id, String name, String description, LocalDate startDate, LocalDate endDate, boolean verified,
			String proofFile, String proofURL) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.verified = verified;
		this.proofFile = proofFile;
		this.proofURL = proofURL;
//		this.profile = profile;
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

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public String getProofFile() {
		return proofFile;
	}

	public void setProofFile(String proofFile) {
		this.proofFile = proofFile;
	}

	public String getProofURL() {
		return proofURL;
	}

	public void setProofURL(String proofURL) {
		this.proofURL = proofURL;
	}


      
    
}
