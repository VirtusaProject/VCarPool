package com.virtusa.carpool.services;

import java.util.List;

import com.virtusa.carpool.dao.RideDao;
import com.virtusa.carpool.exception.VCarPoolException;
import com.virtusa.carpool.model.Ride;
import com.virtusa.carpool.model.User;

public class ServiceRide {

	public ServiceRide() {
		// TODO Auto-generated constructor stub
	}

	static RideDao dao = new RideDao();

	public int insert(Ride r) throws VCarPoolException {
		// TODO Auto-generated method stub
		return dao.insert(r);
	}

	public int update(Ride r, String feild, String value) throws VCarPoolException {
		// TODO Auto-generated method stub
		return dao.update(r, feild, value);
	}

	public User delet(Ride r) throws VCarPoolException {
		// TODO Auto-generated method stub
		return dao.delet(r);
	}

	public List<Ride> showRides() throws VCarPoolException {
		// TODO Auto-generated method stub
		return dao.showRides();
	}

}
