package com.virtusa.maventest;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.virtusa.maventest.model.Employee;

public class MainHybernateHQL {

	public static void main(String[] args) {

		Employee emp = new Employee();
		emp.setFirstName("krishna");
		emp.setLastName("Teja");
		emp.setSalary(10000);

		Employee emp1 = new Employee();
		emp1.setFirstName("krishna");
		emp1.setLastName("Sandeep");
		emp1.setSalary(20000);

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		/*
		 * Query query = session.createQuery("from Employee"); query.setFirstResult(1);
		 * query.setMaxResults(2); List<Employee> empList = query.list(); for (Employee
		 * employee : empList) { System.out.println(employee); System.out.println(); }
		 * 
		 */	
		Object obj= session.load(Employee.class, 5);
		Employee e= (Employee)obj;
		System.out.println(e);

		transaction.commit();
		session.close();

	}

}
