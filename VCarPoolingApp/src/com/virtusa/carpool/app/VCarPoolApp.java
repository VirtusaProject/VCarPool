package com.virtusa.carpool.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.virtusa.carpool.exception.VCarPoolException;
import com.virtusa.carpool.model.Ride;
import com.virtusa.carpool.model.User;
import com.virtusa.carpool.services.ServiceRide;
import com.virtusa.carpool.services.ServiceUser;

public class VCarPoolApp {

	public VCarPoolApp() {
		// TODO Auto-generated constructor stub
	}

	static Logger log = Logger.getLogger(VCarPoolApp.class);

	public static void main(String[] args) throws VCarPoolException {
		ServiceUser s = new ServiceUser();
		User user = new User("krishna", "password", "provider");

		user.setEmail("eppppS@gmail.com");
		int id = s.insert(user);
		user.setUserId(id);
		/*
		 * int id=s.insert(user); user.setUserId(id);
		 */

		Ride r = new Ride("done", user, user);
		ServiceRide ride = new ServiceRide();
		System.out.println(ride.insert(r));

		// System.out.println(s.insert(user));
		// user.setUserId(s.insert(user));
		// System.out.println(s.update(user, "password", "pass1"));
		// System.out.println(s.delet(user));

		List<Ride> arr = ride.showRides();
		Iterator<Ride> it = arr.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
			System.out.println();
		}

		System.out.println(s.getUser(3));
	}
}
