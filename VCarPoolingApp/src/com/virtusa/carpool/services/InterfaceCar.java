package com.virtusa.carpool.services;

import com.virtusa.carpool.exception.VCarPoolException;
import com.virtusa.carpool.model.Car;

public interface InterfaceCar {

	public boolean addCar(Car car, int fk) throws VCarPoolException;

	public boolean updateSrcDest(String checking, String source, String destination) throws VCarPoolException;

	public boolean updateDeptTime(String regNum, String timeUpdate) throws VCarPoolException;

}
