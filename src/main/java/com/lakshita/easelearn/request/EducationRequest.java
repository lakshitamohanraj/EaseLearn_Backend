package com.lakshita.easelearn.request;

import java.time.LocalDate;



public class EducationRequest {
	
	    private Long id;
	    private String name;         // Degree Name
	    private String description;  // Course Details
	    private LocalDate startDate;
	    private LocalDate endDate;

	    private boolean verified = false;  // Admin verification

	    private byte[] proofFile;   // e.g., "IMAGE", "PDF"
	    private String proofURL;    // Storage URL of proof document
	    
	    public EducationRequest() {
			super();
			// TODO Auto-generated constructor stub
		}

		 
		public EducationRequest(Long id, String name, String description, LocalDate startDate, LocalDate endDate, boolean verified,
				byte[] proofFile, String proofURL) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.startDate = startDate;
			this.endDate = endDate;
			this.verified = verified;
			this.proofFile = proofFile;
			this.proofURL = proofURL;
			
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

		public byte[] getProofFile() {
			return proofFile;
		}

		public void setProofFile(byte[] proofFile) {
			this.proofFile = proofFile;
		}

		public String getProofURL() {
			return proofURL;
		}

		public void setProofURL(String proofURL) {
			this.proofURL = proofURL;
		}

	
	
    
}