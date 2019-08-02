package com.virtusa.carpool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.virtusa.carpool.exception.VCarPoolException;
import com.virtusa.carpool.model.User;
import com.virtusa.carpool.services.InterfaceUser;
import com.virtusa.carpool.util.ConnectionUtil;
import com.virtusa.carpool.util.HibernateUtil;

public class UserDao implements InterfaceUser {
	static Logger log = Logger.getLogger(UserDao.class);
	public static UserDao dao = null;

	private UserDao() {
		// TODO Auto-generated constructor stub
	}

	public static UserDao getDao() {
		if (dao == null) {
			dao = new UserDao();
		}
		return dao;
	}

	@Override
	public int insert(User u) throws VCarPoolException {
		int result = 0;
		Session session = HibernateUtil.getFactory().openSession();
		Transaction transaction = session.beginTransaction();
		result = (int) session.save(u);
		transaction.commit();
		session.close();
		return result;
	}

	@Override
	public int update(User u, String feild, String value) throws VCarPoolException {
		int result = 0;
		Session session = HibernateUtil.getFactory().openSession();
		Transaction transaction = session.beginTransaction();

		User user = (User) session.load(User.class, u.getUserId());

		transaction.commit();
		session.close();
		return result;
	}

	@Override
	public User delet(User u) throws VCarPoolException {
		User result = null;
		Session session = HibernateUtil.getFactory().openSession();
		Transaction transaction = session.beginTransaction();

		session.delete(u);

		transaction.commit();
		session.close();
		return result;
	}

	@Override
	public List<User> showUsers() throws VCarPoolException {
		List<User> arr = null;
		
		
		
		
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
				user.setEmail(rs.getString("email"));
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
		PreparedStatement pst = null;
		ResultSet rs = null;
		int result = 0;

		try {
			pst = con.prepareStatement(query);
			pst.setString(1, email);
			rs = pst.executeQuery();
			if (rs.next())
				result = 1;
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new VCarPoolException(e.getMessage());
		}
		return result;
	}

}
