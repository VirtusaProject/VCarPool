package com.virtusa.carpool.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.log4j.Logger;

import com.virtusa.carpool.exception.VCarPoolException;
import com.virtusa.carpool.model.Car;
import com.virtusa.carpool.services.ServiceCar;

/**
 * Servlet implementation class ConfirmControllerServlet
 */
@WebServlet("/ConfirmControllerServlet")
public class ConfirmControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log= Logger.getLogger(ConfirmControllerServlet.class);
	static ServiceCar carserv= new ServiceCar();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		String regNo=request.getParameter("bCarNo");
		int seats=Integer.parseInt(request.getParameter("bSeatsAvailable"));
		RequestDispatcher dispatcher = null;
		try {
			boolean status=carserv.bookCar(regNo,seats );
			if(status) {
				dispatcher = request.getRequestDispatcher("/JSP/bookingSucess.jsp");
				dispatcher.forward(request, response);
			}
			else out.println("<h1>failed</h1>");
		} catch (VCarPoolException e) {
			log.error("error",e);
			e.printStackTrace();
		}
	}

}
