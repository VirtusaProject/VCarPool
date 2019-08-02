package com.virtusa.carpool.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

	public User() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long userId;
	@Column(name = "name")
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "email", unique = true)
	private String email;

	@OneToOne
	private Rider rider;
	/*
	 * @OneToOne private Provider provider;
	 */

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ "]";
	}

	public User(String userName, String password, String type) {
		super();
		this.userName = userName;
		this.password = password;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
