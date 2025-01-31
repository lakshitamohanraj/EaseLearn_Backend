package com.lakshita.easelearn.response;


public class AuthResponse {
	
	private String jwt;
	
	private boolean status;
	
	private String role;
	
	

	public AuthResponse() {
		// TODO Auto-generated constructor stub
	}

	public AuthResponse(String jwt, boolean status,String role) {
		super();
		this.jwt = jwt;
		this.status = status;
		this.role = role;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}