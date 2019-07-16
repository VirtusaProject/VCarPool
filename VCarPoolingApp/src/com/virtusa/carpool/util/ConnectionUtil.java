package com.virtusa.carpool.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConnectionUtil {

	public ConnectionUtil() {
	}

	static Logger log = Logger.getLogger(ConnectionUtil.class);

	public static Connection getConnection() throws com.virtusa.carpool.exception.VCarPoolException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			log.error("class not found", e);
			throw new com.virtusa.carpool.exception.VCarPoolException("class not found!");

		}
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpoolDB", "root", "password");
		} catch (SQLException e) {
			throw new com.virtusa.carpool.exception.VCarPoolException("connecting failed!");
		}
		return con;

	}

}
