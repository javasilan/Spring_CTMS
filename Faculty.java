package com.example.mvccrud.ctms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Faculty {

	
	
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String username;
	    private String password;
	    private String email;
	    private String phone;
	    private String dept;
	    private String address;
	    private String selectroute;
	    private String gender;
		
		
	    public Faculty() {
	    	
	    }


		public Faculty(Long id, String username, String password, String email, String phone, String dept,
				String address, String selectroute, String gender) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.email = email;
			this.phone = phone;
			this.dept = dept;
			this.address = address;
			this.selectroute = selectroute;
			this.gender = gender;
		}


		/**
		 * @return the id
		 */
		public Long getId() {
			return id;
		}


		/**
		 * @return the username
		 */
		public String getUsername() {
			return username;
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
		 * @return the dept
		 */
		public String getDept() {
			return dept;
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
		public void setId(Long id) {
			this.id = id;
		}


		/**
		 * @param username the username to set
		 */
		public void setUsername(String username) {
			this.username = username;
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
		 * @param dept the dept to set
		 */
		public void setDept(String dept) {
			this.dept = dept;
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
	    
}
