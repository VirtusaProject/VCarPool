
package com.virtusa.carpool.services;

import com.virtusa.carpool.exception.VCarPoolException;
import com.virtusa.carpool.model.Bill;

public interface InterfaceBill {

	public int insert(Bill bill) throws VCarPoolException;

	public int update(Bill bill, String field, String value) throws VCarPoolException;

	public int delete(Bill bill) throws VCarPoolException;

}
