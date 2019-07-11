package com.virtusa.carpool.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.mysql.cj.Session;
import com.virtusa.carpool.exception.VCarPoolException;
import com.virtusa.carpool.model.User;
import com.virtusa.carpool.services.ServiceUser;

/**
 * Servlet implementation class RegControllerServlet
 */
@WebServlet("/RegControllerServlet")
public class RegControllerServlet extends HttpServlet {

	static Logger log = Logger.getLogger(RegControllerServlet.class);
	static ServiceUser usr = new ServiceUser();

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		user.setUserName(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));

		user.setEmail(request.getParameter("email"));
		user.setType(request.getParameter("type"));
		RequestDispatcher dispatcher = null;
		log.info(user);
		int key = 0;
		
		try {
				if ((key = usr.insert(user)) > 0) {
					if (user.getType().equals("provider")) {
						// System.out.println("provider block");
						response.addCookie(new Cookie("username", user.getUserName()));
						dispatcher = request.getRequestDispatcher("/JSP/addCar.jsp");
					} else {
						HttpSession session = request.getSession();
						session.setAttribute("userid", key);
						dispatcher = request.getRequestDispatcher("/JSP/regSucess.jsp");
					}
				} else
					request.setAttribute("message", "failed to register, you may have alredy registered");
					dispatcher = request.getRequestDispatcher("/JSP/register.jsp");

			}

		catch (VCarPoolException e) {
			// TODO Auto-generated catch block
			log.error("reg-error", e);
			e.printStackTrace();
		}
		dispatcher.forward(request, response);
	}

}
