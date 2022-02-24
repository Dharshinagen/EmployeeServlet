package com.employee.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.dao.impl.EmployeeDetailsDao;
import com.employee.model.EmployeeDetails;

@WebServlet("/SearchServ")
public class SearchServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String empcode = request.getParameter("empcode");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			//System.out.println(state);

			String localDate=request.getParameter("joiningDateFrom");
			LocalDate fromDate = null;
			if (!localDate.equals(""))
			{
				fromDate=LocalDate.parse(request.getParameter("joiningDateFrom"));
			}
			String localDateTo= request.getParameter("joiningDateTo");
			LocalDate toDate =null;
			if(!localDateTo.equals(""))
					{
			           toDate= LocalDate.parse(request.getParameter("joiningDateTo"));
					}
			//System.out.println(fromDate);
			EmployeeDetailsDao employeedetails = new EmployeeDetailsDao();

			List<EmployeeDetails> employeelist = employeedetails.searchEmployee(empcode, city, state, fromDate, toDate);
			System.out.println(employeelist);
			request.setAttribute("searchlist", employeelist);

			RequestDispatcher requestdispatcher = request.getRequestDispatcher("searchList.jsp");
			requestdispatcher.forward(request, response);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
