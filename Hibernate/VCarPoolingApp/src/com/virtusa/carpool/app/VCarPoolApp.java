package com.virtusa.carpool.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.virtusa.carpool.exception.VCarPoolException;
import com.virtusa.carpool.model.Bill;
import com.virtusa.carpool.model.Car;
import com.virtusa.carpool.model.Ride;
import com.virtusa.carpool.model.User;
import com.virtusa.carpool.services.BillService;
import com.virtusa.carpool.services.ServiceCar;
import com.virtusa.carpool.services.ServiceRide;
import com.virtusa.carpool.services.ServiceUser;
import com.virtusa.carpool.util.HibernateUtil;

public class VCarPoolApp {

	public VCarPoolApp() {
		// TODO Auto-generated constructor stub
	}

	static Logger log = Logger.getLogger(VCarPoolApp.class);

	public static void main(String[] args) throws VCarPoolException {
		
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		User user = new User();
		user.setEmail("krhnteja@gmail.com");
		user.setPassword("password");
		user.setUserName("user1");
		session.save(user);
		transaction.commit();
		session.close();
		
	}
}
