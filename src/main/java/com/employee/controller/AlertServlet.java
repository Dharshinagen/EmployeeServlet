package com.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.connectionUtil.ConnectionUtil;

/**
 * Servlet implementation class AlertServlet
 */
@WebServlet("/AlertServlet")
public class AlertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = null;
		PreparedStatement ps = null;

		String empName = request.getParameter("EmployeeCode");
		System.out.println(empName);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
			ps = con.prepareStatement("select * from employee_Details where Emp_Code= ?");
			ps.setString(1, empName);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				PrintWriter write = response.getWriter();
				write.println("Employee is Already Registered");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, ps);
		}
	}
}
