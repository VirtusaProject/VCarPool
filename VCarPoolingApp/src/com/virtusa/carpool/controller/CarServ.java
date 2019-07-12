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

import com.virtusa.carpool.exception.VCarPoolException;
import com.virtusa.carpool.services.ServiceCar;

/**
 * Servlet implementation class CarServ
 */
@WebServlet("/CarServ")
public class CarServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CarServ() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		com.virtusa.carpool.model.Car car=new com.virtusa.carpool.model.Car();
		car.setRegNo(request.getParameter("regno"));
		car.setCarName(request.getParameter("carname"));
		String number=request.getParameter("seat");
		int num=Integer.parseInt(number);
		car.setSeatsAvailable(num);
		car.setSource(request.getParameter("source"));
		car.setDestination(request.getParameter("destination"));
		ServiceCar c=new ServiceCar();
		HttpSession session= request.getSession();
		Integer check= Integer.parseInt((String) session.getAttribute("userid"));
		boolean checking=false;
		RequestDispatcher dispatcher = null;
		try {
			 checking=c.addCar(car,check );
		} catch (VCarPoolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(checking) {
			
			
		session.setAttribute("userid", check);
		dispatcher= request.getRequestDispatcher("/JSP/regSucess.jsp");
		}
		else {
			out.println("car not added");
		}
			
		dispatcher.forward(request,response);
		
		
	}

}
