package com.virtusa.maventest.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ "]";
	}

	@Id
	//@GenericGenerator(name = "customGenerator", strategy = "com.virtusa.maventest.util.CustomGenerator")
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "salary")
	private int salary;

	@Embedded
	private EmployeeDetail empDetails;

	@OneToOne(mappedBy = "employee")
	private Address address;
	
	@OneToOne
	private Developer developer;

	public Employee(long id, String firstName, String lastName, int salary, EmployeeDetail empDetails,
			Address address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.empDetails = empDetails;
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public EmployeeDetail getEmpDetails() {
		return empDetails;
	}

	public void setEmpDetails(EmployeeDetail empDetails) {
		this.empDetails = empDetails;
	}

	public Employee() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last_name) {
		this.lastName = last_name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}