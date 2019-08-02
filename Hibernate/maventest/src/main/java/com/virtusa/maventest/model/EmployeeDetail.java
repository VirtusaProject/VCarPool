package com.virtusa.maventest.model;

import javax.persistence.Embeddable;

@Embeddable
public class EmployeeDetail {

	public EmployeeDetail() {

	}

	private String bloodGroup;

	private int age;

	private String country;

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
