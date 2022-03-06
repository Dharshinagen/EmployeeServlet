package com.employee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.handler.EmployeeHandler;
import com.employee.model.EmployeeDetails;

@WebServlet("/SearchServ")
public class SearchServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			EmployeeHandler employeeHand=new EmployeeHandler();
   			List<EmployeeDetails> list = null;
			list = employeeHand.searchEmployee(request);
			request.setAttribute("searchlist", list);
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("searchList.jsp");
			requestdispatcher.forward(request, response);

	}
}
