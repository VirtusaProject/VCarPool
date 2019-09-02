package com.virtusa.carpool.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.virtusa.carpool.exception.VCarPoolException;
import com.virtusa.carpool.model.User;
import com.virtusa.carpool.services.InterfaceUser;
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
	public int update(User u) throws VCarPoolException {
		int result = 0;
		Session session = HibernateUtil.getFactory().openSession();
		Transaction transaction = session.beginTransaction();

		User user = (User) session.load(User.class, u.getUserId());
		System.out.println("before: " + user);
		user = u;
		System.out.println("after: " + user);
		session.saveOrUpdate(user);
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
		List arr = null;
		Session session = HibernateUtil.getFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hqlQuery = "from User U";
		Query query = session.createQuery(hqlQuery);
		arr = query.list();

		transaction.commit();
		session.close();
		return arr;
	}

	@Override
	public int login(int userId, String pass) throws VCarPoolException {
		int ret = 0;
		Session session = HibernateUtil.getFactory().openSession();
		Transaction transaction = session.beginTransaction();
		/* String sqlQuery = "select * from user where userId=" + userId; */
		String hqlQuery = "from User U where U.userId = " + userId;
		Query query = session.createQuery(hqlQuery);
		List res = query.list();
		User user = (User) res.get(0);

		if (user.getPassword().equals(pass))
			ret = 1;
		else
			ret = 0;
		transaction.commit();
		session.close();
		return ret;
	}

	@Override
	public User getUser(int userId) throws VCarPoolException {
		User user = null;
		Session session = HibernateUtil.getFactory().openSession();
		Transaction transaction = session.beginTransaction();

		user = (User) session.get(User.class, userId);

		transaction.commit();
		session.close();
		return user;
	}

	@Override
	public User getUserByEmail(String email) throws VCarPoolException {

		User res = null;
		Session session = HibernateUtil.getFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "from User U where U.email= ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, email);
		List list = query.list();
		res = (User) list.get(0);
		transaction.commit();
		session.close();

		return res;
	}

}
