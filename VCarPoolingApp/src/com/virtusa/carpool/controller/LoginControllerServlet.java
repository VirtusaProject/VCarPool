package com.virtusa.carpool.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.virtusa.carpool.exception.VCarPoolException;
import com.virtusa.carpool.model.User;
import com.virtusa.carpool.services.ServiceUser;

/**
 * Servlet implementation class LoginControllerServlet
 */
@WebServlet("/LoginControllerServlet")
public class LoginControllerServlet extends HttpServlet {
	static Logger log= Logger.getLogger(LoginControllerServlet.class);
	static ServiceUser usr = new ServiceUser();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uName=Integer.parseInt(request.getParameter("userid"));
		PrintWriter out= response.getWriter();
		String password= request.getParameter("password");
		RequestDispatcher dispatcher=null;
		try {
			if(usr.login(uName, password)==1) {
				out.println("login sucess!");
				User user= usr.getUser(uName);
				HttpSession session=request.getSession();
				session.setAttribute("userid", user.getUserName());
				session.setAttribute("username", user.getUserId());
				session.setAttribute("usertype", user.getType());
				session.setAttribute("useremail", user.getEmail());
				out.print(user.getUserName()+user.getEmail()+user.getType());
				
				dispatcher= request.getRequestDispatcher("/JSP/home.jsp");
				
			}
			else {
				request.setAttribute("message", "username / password incorrect");
				out.println("not sucess");
				dispatcher= request.getRequestDispatcher("/JSP/login.jsp");
				
			}
		} catch (VCarPoolException e) {
			// TODO Auto-generated catch block
			dispatcher= request.getRequestDispatcher("/HTML/error.html");
			
			log.error("error-login controller", e);
			e.getMessage();
		}
		//dispatcher.forward(request, response);
	}

}
