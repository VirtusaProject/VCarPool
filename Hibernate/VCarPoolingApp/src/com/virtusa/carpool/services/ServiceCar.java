package com.virtusa.carpool.services;

import java.util.ArrayList;

import com.virtusa.carpool.dao.CarDao;
import com.virtusa.carpool.exception.VCarPoolException;
import com.virtusa.carpool.model.Car;

public class ServiceCar {
	static CarDao dao = new CarDao();

	public ServiceCar() {
		// TODO Auto-generated constructor stub
	}

	public boolean addCar(Car car, int fk) throws VCarPoolException {
		return dao.addCar(car, fk);
	}

	public boolean updateSrcDest(String checking, String source, String destination) throws VCarPoolException {
		return dao.updateSrcDest(checking, source, destination);
	}

	public boolean updateDeptTime(String regNum, String timeUpdate) throws VCarPoolException {
		return dao.updateDeptTime(regNum, timeUpdate);
	}

	public ArrayList<Car> showCars(String source, String destination, String time, int seats) throws VCarPoolException {
		return dao.showCars(source, destination, time, seats);
	}
	
	public boolean bookCar(String regNo, int seats) throws VCarPoolException {
		return dao.bookCar(regNo,seats);
	}
}
