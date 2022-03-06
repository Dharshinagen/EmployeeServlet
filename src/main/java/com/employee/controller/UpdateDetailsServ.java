package com.employee.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.handler.EmployeeHandler;

/**
 * Servlet implementation class UpdateDetailsServ
 */
@WebServlet("/UpdateDetailsServ")
public class UpdateDetailsServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         EmployeeHandler empHand=new EmployeeHandler();
         int flag=empHand.updateEmployeeDetails(request);
         if(flag==1) {
        	 RequestDispatcher requestdispatcher = request.getRequestDispatcher("employee.jsp");
     		 requestdispatcher.forward(request, response);
         }
         else {
        	 RequestDispatcher requestdispatcher = request.getRequestDispatcher("searchList.jsp");
     		 requestdispatcher.forward(request, response);
         }
	}

}
