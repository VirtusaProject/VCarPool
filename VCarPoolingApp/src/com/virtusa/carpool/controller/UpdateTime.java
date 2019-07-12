package com.virtusa.carpool.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.carpool.exception.VCarPoolException;
import com.virtusa.carpool.services.ServiceCar;


/**
 * Servlet implementation class UpdateTime
 */
@WebServlet("/UpdateTime")
public class UpdateTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTime() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String time = request.getParameter("time");
		System.out.println(time);
		//String addition=":00";
		//String finalTime=time+addition;
		//System.out.println(finalTime);
		ServiceCar carservice=new ServiceCar();
		boolean check=false;
		String regNum="RJO7CA7496";
		try {
			check=carservice.updateDeptTime(regNum, time);
		} catch (VCarPoolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(check)
			System.out.println("updated time ");
		else
			System.out.println("time not updated ");
	}

}
