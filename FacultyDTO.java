package com.example.mvccrud.ctms.DTO;

public class FacultyDTO {
	 private String id;
	    private String Username;
	    private String password;
	    private String email;
	    private String phone;
	    private String dept;
	    private String address;
	    private String selectroute;
	    private String gender;
		
		
	    public FacultyDTO() {
	    	
	    }


		public FacultyDTO(String id, String username, String password, String email, String phone, String dept,
				String address, String selectroute, String gender) {
			super();
			this.id = id;
			Username = username;
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
		public String getId() {
			return id;
		}


		/**
		 * @return the username
		 */
		public String getUsername() {
			return Username;
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


		
		public String getSelectroute() {
			return selectroute;
		}


		
		public String getGender() {
			return gender;
		}


		
		public void setId(String id) {
			this.id = id;
		}


		
		public void setUsername(String username) {
			Username = username;
		}

		public void setPassword(String password) {
			this.password = password;
		}


		/**
		 * @param email the email to set
		 */
		public void setEmail(String email) {
			this.email = email;
		}


		
		public void setPhone(String phone) {
			this.phone = phone;
		}


		
		public void setDept(String dept) {
			this.dept = dept;
		}


		
		public void setAddress(String address) {
			this.address = address;
		}


		
		public void setSelectroute(String selectroute) {
			this.selectroute = selectroute;
		}


		
		public void setGender(String gender) {
			this.gender = gender;
		}
	    
}
