package com.virtusa.carpool.services;

import java.util.ArrayList;

import com.virtusa.carpool.exception.VCarPoolException;
import com.virtusa.carpool.model.Car;

public interface InterfaceCar {

	public boolean addCar(Car car, int fk) throws VCarPoolException;

	public boolean updateSrcDest(String checking, String source, String destination) throws VCarPoolException;

	public boolean updateDeptTime(String regNum, String timeUpdate) throws VCarPoolException;
	
	public ArrayList<Car> showCars(String source, String destination, String time,int seats) throws VCarPoolException;
	
	public boolean bookCar(String regNo, int seats) throws VCarPoolException;

}
