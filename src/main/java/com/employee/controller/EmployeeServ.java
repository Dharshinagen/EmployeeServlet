package com.employee.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employee.handler.EmployeeHandler;

@WebServlet("/EmployeeServ")
public class EmployeeServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         EmployeeHandler empHandler=new EmployeeHandler();
        int i= empHandler.insertEmployee(request);

        	if(i == 1)
    		{
        		 System.out.println("serv"+i);
    			response.sendRedirect("searchList.jsp");
    		}else {
    			HttpSession session = request.getSession();
    			session.setAttribute("add", "Not Inserted");
    			 System.out.println("serv"+i);
    			response.sendRedirect("employee.jsp");
    		}

	}

}
