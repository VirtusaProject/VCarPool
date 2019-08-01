package com.virtusa.carpool.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.virtusa.carpool.exception.VCarPoolException;
import com.virtusa.carpool.model.Bill;
import com.virtusa.carpool.util.ConnectionUtil;

public class BillDao implements com.virtusa.carpool.services.InterfaceBill {

	Logger logger = Logger.getLogger(BillDao.class);

	@Override
	public int insert(Bill bill) throws VCarPoolException {

		ResultSet resultSet = null;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		int userNo = 0;
		try {
			System.out.println(connection);
			preparedStatement = connection.prepareStatement("insert into bill(status,fare,Ride_rideId) values(?,?,?)",
					Statement.RETURN_GENERATED_KEYS

			);
			// preparedStatement.setInt(1, bill.getTxnId());
			preparedStatement.setString(1, bill.getStatus());
			preparedStatement.setDouble(2, bill.getFare());
			preparedStatement.setInt(3, bill.getRideId().getRideId());
			preparedStatement.executeUpdate();

			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {

				userNo = resultSet.getInt(1);
				System.out.println(userNo);
			}

		} catch (SQLException e) {

			logger.error("sql error", e);
			throw new VCarPoolException(e.getMessage());
		} catch (Exception e) {
			
			logger.error("internal error", e);
			throw new VCarPoolException(e.getMessage());
		}

		finally {

			// close pstmt,connection,result set also
			try {

				if (resultSet != null) {

					resultSet.close();
				}

				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {

				logger.error("sql error", e);
				// TODO: handle exception
				throw new VCarPoolException(" error while closing a resource contact to admin");

			} catch (Exception e) {
				// TODO: handle exception

				logger.error("internal error", e);
				throw new VCarPoolException("  contact to admin");

			}

		}

		return userNo;
	}

	@Override
	public int delete(Bill bill) throws VCarPoolException {
		// TODO Auto-generated method stub

		ResultSet resultSet = null;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		int userNo = 0;
		try {
			System.out.println(connection);
			preparedStatement = connection.prepareStatement("delete table bill where txnId=?",
					Statement.RETURN_GENERATED_KEYS

			);
			preparedStatement.setInt(1, bill.getTxnId());
			// preparedStatement.setString(2, bill.getStatus());
			// preparedStatement.setDouble(3, bill.getFare());
			// preparedStatement.setInt(4, bill.getRideId());

			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {

				userNo = resultSet.getInt(1);
				System.out.println(userNo);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("sql error", e);
			throw new VCarPoolException(e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("internal error", e);
			throw new VCarPoolException(e.getMessage());
		}

		finally {

			// close pstmt,connection,result set also
			try {

				if (resultSet != null) {

					resultSet.close();
				}

				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {

				logger.error("sql error", e);
				// TODO: handle exception
				throw new VCarPoolException(" error while closing a resource contact to admin");

			} catch (Exception e) {
				// TODO: handle exception

				logger.error("internal error", e);
				throw new VCarPoolException("contact to admin");

			}

		}
		return userNo;

	}

	@Override
	public int update(Bill b, String field, String value) throws VCarPoolException {

		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		int key = 0;
		String query = "update bill set " + field + "=? where txnId= ?";

		System.out.println(query);
		try {
			pst = con.prepareStatement(query);

			pst.setString(1, value);
			pst.setInt(2, b.getTxnId());
			key = pst.executeUpdate();
		} catch (SQLException e) {
			logger.error("update error- dao", e);
			throw new VCarPoolException("error-dao-update");
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					throw new VCarPoolException();
				}
			if (pst != null)
				try {
					pst.close();
				} catch (SQLException e) {
					throw new VCarPoolException();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					throw new VCarPoolException();
				}
		}

		return key;

	}

}
