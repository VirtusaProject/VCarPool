package com.virtusa.carpool.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.virtusa.carpool.exception.VCarPoolException;
import com.virtusa.carpool.model.Car;
import com.virtusa.carpool.services.ServiceCar;

/**
 * Servlet implementation class FindCarsControllerServlet
 */
@WebServlet("/FindCarsControllerServlet")
public class FindCarsControllerServlet extends HttpServlet {
	Logger log = Logger.getLogger(FindCarsControllerServlet.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindCarsControllerServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServiceCar c = new ServiceCar();
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String time = request.getParameter("time");
		String seats = request.getParameter("seats");
		Integer seat = Integer.parseInt(seats);
		HttpSession session= request.getSession();
		session.setAttribute("source", source);
		session.setAttribute("destination", destination);
		session.setAttribute("time", time);
		session.setAttribute("seats", seat);
		RequestDispatcher dispatcher = null;
		// PrintWriter out= response.getWriter();
		// out.println(source+destination+time);
		try {
			ArrayList<Car> arr = c.showCars(source, destination, time, seat);
			session.setAttribute("resultArray", arr);
			if (arr.size() > 0) {
				log.info("cars returned: ");
				log.info(arr);
			}
			dispatcher = request.getRequestDispatcher("/JSP/result.jsp");
			
		} catch (VCarPoolException e) {

			System.out.println(e.getMessage());
		}
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			log.error("error", e);
			System.out.println(e.getMessage());
		}

	}

}
