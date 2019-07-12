package com.virtusa.carpool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.virtusa.carpool.exception.VCarPoolException;
import com.virtusa.carpool.model.Car;
import com.virtusa.carpool.services.InterfaceCar;
import com.virtusa.carpool.util.ConnectionUtil;

public class CarDao implements InterfaceCar {
	static Logger logger = Logger.getLogger("CarDao");

	public CarDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addCar(Car car, int fk) throws VCarPoolException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		int ret = 0;
		try {
			System.out.println(connection);
			preparedStatement = connection.prepareStatement(
					"insert into car (regNo,carName,seatsAvailable,User_userId,source,destination,departureTime) values(?,?,?,?,?,?,?)");
			preparedStatement.setString(1, car.getRegNo());
			preparedStatement.setString(2, car.getCarName());
			preparedStatement.setInt(3, car.getSeatsAvailable());
			preparedStatement.setInt(4, fk);
			preparedStatement.setString(5, car.getSource());
			preparedStatement.setString(6, car.getDestination());
			preparedStatement.setString(7, car.getDeptTime());
			ret = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("error with SQL", e);
			throw new VCarPoolException("Some internal error contact to admin");
		} catch (Exception exception) {

			logger.error("error with system", exception);
			throw new VCarPoolException("Some internal error contact to admin");

		}

		finally {

			// close pstmt,connection,result set also
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				throw new VCarPoolException(" error while closing a resource contact to admin");

			}

		}
		if (ret > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateSrcDest(String checking, String source, String destination) throws VCarPoolException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		int ret = 0;
		try {
			System.out.println(connection);
			preparedStatement = connection.prepareStatement("UPDATE car SET source = ?,destination= ? where regNo= ?");
			preparedStatement.setString(1, source);
			preparedStatement.setString(2, destination);
			preparedStatement.setString(3, checking);
			ret = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("error with SQL", e);
			throw new VCarPoolException("Some internal error contact to admin");
		} catch (Exception exception) {

			logger.error("error with system", exception);
			throw new VCarPoolException("Some internal error contact to admin");

		}

		finally {

			// close pstmt,connection,result set also
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				throw new VCarPoolException(" error while closing a resource contact to admin");

			}

		}

		if (ret > 0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean updateDeptTime(String regNum, String timeUpdate) throws VCarPoolException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		int ret = 0;
		try {
			System.out.println(connection);
			preparedStatement = connection.prepareStatement("UPDATE car SET departureTime = ? where regNo= ?");
			preparedStatement.setString(1, timeUpdate);
			preparedStatement.setString(2, regNum);
			ret = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("error with SQL", e);
			throw new VCarPoolException("Some internal error contact to admin");
		} catch (Exception exception) {

			logger.error("error with system", exception);
			throw new VCarPoolException("Some internal error contact to admin");

		}

		finally {

			// close pstmt,connection,result set also
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				throw new VCarPoolException(" error while closing a resource contact to admin");

			}

		}

		if (ret > 0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public ArrayList<Car> showCars(String source, String destination, String time) throws VCarPoolException {
		ArrayList<Car> arr= new ArrayList<Car>();
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String query= "select * from car where  source=? and destination=? and departureTime=?";
		Car car= null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,source);
			preparedStatement.setString(2,destination);
			preparedStatement.setString(3,time);
			ResultSet rs= preparedStatement.executeQuery();
			while(rs.next()) {
				car= new Car();
				car.setRegNo(rs.getString("regNo"));
				car.setCarName(rs.getString("carName"));
				car.setSeatsAvailable(rs.getInt("seatsAvailable"));
				car.setSource(rs.getString("source"));
				car.setDestination(rs.getString("destination"));
				car.setDeptTime(rs.getString("departureTime"));
				arr.add(car);
				car=null;
			}
		} catch (SQLException e) {
			logger.error("error",e);
			throw new VCarPoolException(e.getMessage());
		}
		return arr;
	}
}
