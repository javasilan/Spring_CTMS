package com.example.mvccrud.ctms.DTO;


public class StudentDTO {


    private String id;
    private String Username;
    private String password;
    private String email;
    private String phone;
    private String branch;
    private String address;
    private String selectroute;
    private String gender;
	
	
    public StudentDTO() {
    	
    }

	

	public StudentDTO(String id, String username, String password, String email, String phone, String branch,
			String address, String selectroute, String gender) {
		super();
		this.id = id;
		this.Username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.branch = branch;
		this.address = address;
		this.selectroute = selectroute;
		this.gender = gender;
	}



	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the selectroute
	 */
	public String getSelectroute() {
		return selectroute;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @param branch the branch to set
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param selectroute the selectroute to set
	 */
	public void setSelectroute(String selectroute) {
		this.selectroute = selectroute;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return Username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		Username = username;
	}

	






}