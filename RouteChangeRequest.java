package com.example.mvccrud.ctms.model;

import jakarta.persistence.*;

@Entity
public class RouteChangeRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String requestText;
    private String requesterEmail;
    private boolean approved;
    
    
    
    
    public RouteChangeRequest() {
    	
    }
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @return the requestText
	 */
	public String getRequestText() {
		return requestText;
	}
	/**
	 * @return the requesterEmail
	 */
	public String getRequesterEmail() {
		return requesterEmail;
	}
	/**
	 * @return the approved
	 */
	public boolean isApproved() {
		return approved;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @param requestText the requestText to set
	 */
	public void setRequestText(String requestText) {
		this.requestText = requestText;
	}
	/**
	 * @param requesterEmail the requesterEmail to set
	 */
	public void setRequesterEmail(String requesterEmail) {
		this.requesterEmail = requesterEmail;
	}
	/**
	 * @param approved the approved to set
	 */
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public RouteChangeRequest(Long id, String name, String email, String requestText, String requesterEmail,
			boolean approved) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.requestText = requestText;
		this.requesterEmail = requesterEmail;
		this.approved = approved;
	}

    // Getters and setters

    // Constructors
}
