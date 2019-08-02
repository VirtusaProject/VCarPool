package com.virtusa.maventest;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import com.virtusa.maventest.model.Employee;
import com.virtusa.maventest.util.HibernateUtil;

public class MainCriteriaHybernate {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Criteria criteria = session.createCriteria(Employee.class);
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("firstName"));
		projectionList.add(Projections.property("lastName"));
		projectionList.add(Projections.property("salary"));
		criteria.setProjection(projectionList);
		List<Object[]> empList = criteria.list();
		for (Object[] employee : empList) {
			for(Object obj : employee) {
				System.out.print(" " +obj+ " ");
			}
			System.out.println();
		}

		transaction.commit();
		session.close();

	}

}
