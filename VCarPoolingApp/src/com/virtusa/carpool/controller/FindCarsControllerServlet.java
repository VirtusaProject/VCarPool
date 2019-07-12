package com.virtusa.carpool.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.carpool.exception.VCarPoolException;
import com.virtusa.carpool.model.Car;
import com.virtusa.carpool.services.ServiceCar;

/**
 * Servlet implementation class FindCarsControllerServlet
 */
@WebServlet("/FindCarsControllerServlet")
public class FindCarsControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindCarsControllerServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ServiceCar c= new ServiceCar();
		 String source=request.getParameter("source");
		 String destination=request.getParameter("destination");
		 String time=request.getParameter("time");
		 request.setAttribute("source",source);
		 request.setAttribute("destination",destination);
		 request.setAttribute("time",time);
		 RequestDispatcher dispatcher = null; 
		 try {
			ArrayList<Car> arr= c.showCars(source, destination, time);
			if(arr.size()>0) {
				request.setAttribute("resultArray", arr);
				dispatcher =request.getRequestDispatcher("/JSP/result.jsp");	
			}
			else {
				dispatcher =request.getRequestDispatcher("/HTML/error.html");
			}
			
		} catch (VCarPoolException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}
		 dispatcher.forward(request,response);
		 
	}

}
