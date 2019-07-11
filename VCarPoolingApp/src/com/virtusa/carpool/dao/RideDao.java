package com.virtusa.carpool.dao;

import java.util.List;

import com.virtusa.carpool.exception.VCarPoolException;
import com.virtusa.carpool.model.Ride;
import com.virtusa.carpool.model.User;
import com.virtusa.carpool.services.InterfaceRide;

public class RideDao implements InterfaceRide {

	public RideDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int insert(Ride r) throws VCarPoolException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Ride r, String feild, String value) throws VCarPoolException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User delet(Ride r) throws VCarPoolException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ride> showRides() throws VCarPoolException {
		// TODO Auto-generated method stub
		return null;
	}

}
