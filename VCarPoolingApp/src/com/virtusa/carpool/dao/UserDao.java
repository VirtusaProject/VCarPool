package com.virtusa.carpool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.virtusa.carpool.exception.VCarPoolException;
import com.virtusa.carpool.model.User;
import com.virtusa.carpool.services.InterfaceUser;
import com.virtusa.carpool.util.ConnectionUtil;

public class UserDao implements InterfaceUser {
	static Logger log = Logger.getLogger(UserDao.class);

	public UserDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int insert(User u) throws VCarPoolException {

		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		int key = 0;
		String query = "insert into user(userName, password, type, email) values(?,?,?,?)";
		try {
			pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, u.getUserName());
			pst.setString(2, u.getPassword());

			pst.setString(3, u.getType());
			pst.setString(4, u.getEmail());
			pst.executeUpdate();
			rs = pst.getGeneratedKeys();
			if (rs.next())
				key = rs.getInt(1);
		} catch (SQLException e) {
			log.error("error-dao", e);
			throw new VCarPoolException("exception-dao");
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

	@Override
	public int update(User u, String feild, String value) throws VCarPoolException {

		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		int key = 0;
		String query = "update user set " + feild + "=? where userId= ?";

		System.out.println(query);
		try {
			pst = con.prepareStatement(query);

			pst.setString(1, value);
			pst.setInt(2, u.getUserId());
			key = pst.executeUpdate();
		} catch (SQLException e) {
			log.error("update error- dao", e);
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

	@Override
	public User delet(User u) throws VCarPoolException {
		User temp = u;

		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pst = null;
		int key = 0;
		String query = "delete from user where userId=?";
		try {
			pst = con.prepareStatement(query);
			pst.setInt(1, u.getUserId());
			key = pst.executeUpdate();
			if (key > 0)
				return temp;
			else
				return null;
		} catch (SQLException e) {
			log.error("deletion error- dao", e);
			throw new VCarPoolException("error in deleting data");
		} finally {

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

	}

	@Override
	public List<User> showUsers() throws VCarPoolException {
		ArrayList<User> arr = new ArrayList<User>();
		ResultSet rs = null;
		Connection con = ConnectionUtil.getConnection();
		Statement st = null;
		String query = "select * from user";
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			if (rs == null)
				return null;
			else {
				User user = null;
				while (rs.next()) {
					user = new User();
					user.setUserId(rs.getInt("userId"));
					user.setUserName(rs.getString("userName"));
					user.setPassword(rs.getString("password"));
					user.setType(rs.getString("type"));
					arr.add(user);
					user = null;
				}
			}
		} catch (SQLException e) {
			log.error("selection error- dao", e);
			throw new VCarPoolException("error in selecting data");
		}

		return arr;
	}

	@Override
	public int login(int userId, String password) throws VCarPoolException {

		Connection con = ConnectionUtil.getConnection();
		String query = "select * from user";
		Statement st = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user = getUser(userId);

		try {
			st = con.createStatement();
			pst = con.prepareStatement("select * from user", Statement.RETURN_GENERATED_KEYS);
			pst.execute();
			rs = st.executeQuery(query);

			while (rs.next()) {
				if (rs.getString("password").equals(password) && (rs.getInt("userId") == user.getUserId()
						|| rs.getString("userName").equals(user.getUserName())))

					return 1;
			}

		} catch (SQLException e) {
			log.error("login- dao", e);
			throw new VCarPoolException("login- error");
		}

		finally {
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
		return 0;

	}

	@Override
	public User getUser(int userId) throws VCarPoolException {

		Connection con = ConnectionUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		User user = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from user where userId=" + userId);
			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setType(rs.getString("type"));
			}

		} catch (SQLException e) {
			log.error("get -eeror", e);
			throw new VCarPoolException("error-getting user");
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					throw new VCarPoolException();
				}
			if (st != null)
				try {
					st.close();
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

		return user;
	}

	@Override
	public int getUserEmail(String email) throws VCarPoolException {
		Connection con = ConnectionUtil.getConnection();
		String query = "select email from user where email=?";
		PreparedStatement pst=null;
		ResultSet rs=null;
		int result=0;
		
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, email);
			rs=pst.executeQuery();
			if(rs.next())
				result=1;
		} catch (SQLException e) {
			log.error(e.getMessage(),e);
			throw new VCarPoolException(e.getMessage());
		}
		return result;
	}

}
