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
 * Servlet implementation class UpdateSourceDestination
 */
@WebServlet("/UpdateSourceDestination")
public class UpdateSourceDestination extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSourceDestination() {
        super();
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
		PrintWriter out=response.getWriter();
		String source=request.getParameter("source");
		String destination=request.getParameter("destination");
		ServiceCar carservice=new ServiceCar();
		String check="RJ07CA7496";
		boolean checking=false;
		 try {
			checking=carservice.updateSrcDest(check,source,destination);
		} catch (VCarPoolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 if(checking)
			 out.println("updated");
		 else
			 out.println("not updated");
			 
				
	}

}
