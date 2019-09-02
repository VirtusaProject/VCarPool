package com.virtusa.carpool.services;

import java.util.List;

import com.virtusa.carpool.exception.VCarPoolException;
import com.virtusa.carpool.model.User;

public interface InterfaceUser {
	public int insert(User u) throws VCarPoolException;

	public int update(User u) throws VCarPoolException;

	public User delet(User u) throws VCarPoolException;
	
	public List<User> showUsers() throws VCarPoolException;
	
	public int login(int userId, String password) throws VCarPoolException;
	
	public User getUser(int userId) throws VCarPoolException;
	
	public User getUserByEmail(String email) throws VCarPoolException;
}
