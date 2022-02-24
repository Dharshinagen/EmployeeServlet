package com.employee.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.dao.impl.EmployeeDetailsDao;
import com.employee.model.EmployeeDetails;

@WebServlet("/EmployeeList")
public class EmployeeList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
		 List<EmployeeDetails> employeelist;
		 EmployeeDetailsDao empdao=new EmployeeDetailsDao();
		 employeelist = empdao.viewEmployeeDetail();
 	   	request.setAttribute("employeeList", employeelist);
		RequestDispatcher requestdispatcher = request.getRequestDispatcher("employeeList.jsp");
		requestdispatcher.forward(request, response);
		 } catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
