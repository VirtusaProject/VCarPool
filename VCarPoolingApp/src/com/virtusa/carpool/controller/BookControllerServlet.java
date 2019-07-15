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

import com.virtusa.carpool.model.Car;

/**
 * Servlet implementation class BookControllerServlet
 */
@WebServlet("/BookControllerServlet")
public class BookControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookControllerServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String carNo = request.getParameter("carno");
		String carName = request.getParameter("carname");
		String carSource = request.getParameter("carsource");
		String carDest = request.getParameter("cardest");
		String carTime = request.getParameter("cartime");
		String carSeats = request.getParameter("carseats");
		Integer seats = Integer.parseInt(carSeats);
		/*
		 * PrintWriter out= response.getWriter(); Car car= new
		 * Car(carNo,carName,seats,carSource,carDest,carTime); out.println(car);
		 */

		Car car = new Car(carNo, carName, seats, carSource, carDest, carTime);
		request.setAttribute("bookCars", car);
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		if (session.getAttribute("userid") == null) {
			dispatcher = request.getRequestDispatcher("../JSP/login.jsp");
			dispatcher.forward(request, response);
		} /*
			 * else { dispatcher = request.getRequestDispatcher("../JSP/booking.jsp");
			 * dispatcher.forward(request, response); }
			 */
			
		

	}

}
