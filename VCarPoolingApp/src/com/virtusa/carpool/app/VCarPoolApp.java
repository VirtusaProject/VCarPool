package com.virtusa.carpool.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.virtusa.carpool.exception.VCarPoolException;
import com.virtusa.carpool.model.Car;
import com.virtusa.carpool.model.Ride;
import com.virtusa.carpool.model.User;
import com.virtusa.carpool.services.ServiceCar;
import com.virtusa.carpool.services.ServiceRide;
import com.virtusa.carpool.services.ServiceUser;

public class VCarPoolApp {

	public VCarPoolApp() {
		// TODO Auto-generated constructor stub
	}

	static Logger log = Logger.getLogger(VCarPoolApp.class);

	public static void main(String[] args) throws VCarPoolException {
		ServiceUser s = new ServiceUser();
		ServiceCar c= new ServiceCar();
		/*
		 * User user = new User("krishna", "password", "provider");
		 * 
		 * user.setEmail("enew2o@gmail.com"); int id = s.insert(user);
		 * user.setUserId(id); Car car= new Car("TS08GP0730", "car1",4, "source",
		 * "destination", "12:12:12:12"); System.out.println(c.addCar(car, id));
		 */
		
		System.out.println(c.updateDeptTime("TS08GP0732", "12:1:1:7"));
		System.out.println(c.updateSrcDest("TS08GP0732", "src", "dest"));
		
		
	}
}
