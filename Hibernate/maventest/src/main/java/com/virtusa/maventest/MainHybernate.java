package com.virtusa.maventest;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.virtusa.maventest.model.Address;
import com.virtusa.maventest.model.Developer;
import com.virtusa.maventest.model.Employee;
import com.virtusa.maventest.model.EmployeeDetail;

public class MainHybernate {

	public static void main(String[] args) {

		/*
		 * Employee emp = new Employee(); emp.setFirstName("krishna");
		 * emp.setLastName("Teja"); emp.setSalary(10000);
		 */

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		EmployeeDetail detail = new EmployeeDetail();
		detail.setAge(25);
		detail.setCountry("India");
		detail.setBloodGroup("B+");

		Address address = new Address();
		address.setCity("Hyderabad");
		address.setState("Telangana");
		address.setCountry("India");
		session.save(address);
		

		Employee employee = new Employee();
		employee.setAddress(address);
		employee.setEmpDetails(detail);
		employee.setFirstName("krishna");
		employee.setLastName("Kiran");
		employee.setSalary(30000);
		session.save(employee);
		
		
		Developer developer= new Developer();
		developer.setEmpid(employee);
		developer.setDetail("det1");
		
		transaction.commit();
		session.close();

	}

}
