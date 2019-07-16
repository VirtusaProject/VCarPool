package com.virtusa.carpool.services;

import java.util.List;

import com.virtusa.carpool.dao.UserDao;
import com.virtusa.carpool.exception.VCarPoolException;
import com.virtusa.carpool.model.User;

public class ServiceUser {

	public ServiceUser() {
		// TODO Auto-generated constructor stub
	}
	 public static UserDao dao=  new UserDao();
	public int insert(User u) throws VCarPoolException {
		// TODO Auto-generated method stub
		return dao.insert(u);
	}

	
	public int update(User u, String feild, String value) throws VCarPoolException {
		// TODO Auto-generated method stub
		return dao.update(u, feild, value);
	}

	
	public User delet(User u) throws VCarPoolException {
		// TODO Auto-generated method stub
		return dao.delet(u);
	}
	
	public List<User> showUsers() throws VCarPoolException {
		return dao.showUsers();
	}
	
	public int login(int userId, String password) throws VCarPoolException {
		return dao.login(userId, password);
	}
	
	public User getUser(int userId) throws VCarPoolException {
		return dao.getUser(userId);
	}
	
	public int getUserEmail(String email) throws VCarPoolException {
		return dao.getUserEmail(email);
	}

	
}
