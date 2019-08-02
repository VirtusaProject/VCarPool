package com.virtusa.maventest.model;

import javax.persistence.*;

@Entity
@Table(name="developer")
public class Developer {
	
	@Id
	private String id;
	
	@OneToOne
	@JoinColumn(name = "empid")
	@MapsId
	private Employee empid;
	
	@Column(name = "detail")
	private String detail;

	public Employee getEmpid() {
		return empid;
	}

	public void setEmpid(Employee empid) {
		this.empid = empid;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
