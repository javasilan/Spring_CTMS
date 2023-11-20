package com.example.mvccrud.ctms.DTO;

public class FacultyLoginDto {
	private String email;
	private String password;
	
	public FacultyLoginDto() {
		
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public FacultyLoginDto(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
}
