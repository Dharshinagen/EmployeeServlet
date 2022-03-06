package com.employee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employee.handler.EmployeeHandler;
import com.employee.model.EmployeeDetails;


@WebServlet("/UpdateServ")
public class UpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
          EmployeeHandler empHand=new EmployeeHandler();
         List<EmployeeDetails>empList=empHand.updateDetails(request);
         request.setAttribute("upList",empList);
         RequestDispatcher rd=request.getRequestDispatcher("updateEmployee.jsp");
         rd.forward(request, response);
	}

}
