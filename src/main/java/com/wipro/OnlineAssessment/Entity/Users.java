package com.wipro.OnlineAssessment.Entity;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Users {
	@Id
	private String email;
	private String password;
	private String firstname;
	private String lastname;
	private String usertype;
	public Users() {
	}
	public Users(String firstname, String lastname, String email, String password,String usertype) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.usertype = usertype;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	
}
