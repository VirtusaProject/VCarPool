package com.virtusa.carpool.app;

import org.apache.log4j.Logger;

import com.virtusa.carpool.exception.VCarPoolException;
import com.virtusa.carpool.model.User;
import com.virtusa.carpool.services.ServiceUser;

public class VCarPoolApp {

	public VCarPoolApp() {
		// TODO Auto-generated constructor stub
	}

	static Logger log = Logger.getLogger(VCarPoolApp.class);

	public static void main(String[] args) throws VCarPoolException {
		User user= new User("krishna", "password","provider");
		ServiceUser s= new ServiceUser();
		System.out.println(s.insert(user));
		//user.setUserId(s.insert(user));
		//System.out.println(s.update(user, "password", "pass1"));
		//System.out.println(s.delet(user));
		
		System.out.println(s.showUsers());

		System.out.println(s.getUser(3));
}
}
