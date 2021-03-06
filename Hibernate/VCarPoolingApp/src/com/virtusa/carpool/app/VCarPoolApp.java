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

	}

	static Logger log = Logger.getLogger(VCarPoolApp.class);

	public static void main(String[] args) throws VCarPoolException {

		User user = new User();
		user.setUserName("user");
		user.setEmail("krshna11@gail.com");
		user.setPassword("password");
		user.setType("provider");
		/*
		 * ServiceUser serviceUser = new ServiceUser(); if(serviceUser.login(1,
		 * "passwor")>0) System.out.println("logged in sucessfully!"); else
		 * System.out.println("error in login details");
		 */
		ServiceUser serviceUser = new ServiceUser();
		User user1 = serviceUser.getUser(1);
		User user2 = serviceUser.getUserByEmail("krshna11@gail.com");
		System.out.println(serviceUser.showUsers());
		System.out.println();

		System.out.println(user1);
		System.out.println();
		System.out.println(user2);

	}
}
