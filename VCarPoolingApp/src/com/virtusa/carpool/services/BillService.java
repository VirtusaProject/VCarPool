package com.virtusa.carpool.services;

import com.virtusa.carpool.dao.BillDao;
import com.virtusa.carpool.exception.VCarPoolException;
import com.virtusa.carpool.model.Bill;

public class BillService {

	private BillDao billDao = new BillDao();

	public int insert(Bill bill) throws VCarPoolException {
		// TODO Auto-generated method stub
		return billDao.insert(bill);
	}

	public int update(Bill bill, String field, String value) throws VCarPoolException {

		return billDao.update(bill, field, value);
	}

	public int delete(Bill bill) throws VCarPoolException {
		// TODO Auto-generated method stub
		return billDao.delete(bill);
	}
}
