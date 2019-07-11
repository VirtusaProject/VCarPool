package com.virtusa.carpool.services;

import java.util.List;

import com.virtusa.carpool.exception.VCarPoolException;
import com.virtusa.carpool.model.Ride;
import com.virtusa.carpool.model.User;

public interface InterfaceRide {

	public int insert(Ride r) throws VCarPoolException;

	public int update(Ride r, String feild, String value) throws VCarPoolException;

	public Ride delet(Ride r) throws VCarPoolException;
	
	public List<Ride> showRides() throws VCarPoolException;
	
	
}
