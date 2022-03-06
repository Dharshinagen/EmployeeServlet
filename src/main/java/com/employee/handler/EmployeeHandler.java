package com.employee.handler;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.employee.Business.Business;
import com.employee.model.EmployeeDetails;

public class EmployeeHandler {

	public int insertEmployee(HttpServletRequest request) {
		String empname = request.getParameter("empname");
		String empcode = request.getParameter("empcode");
		String emailid = request.getParameter("email");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		LocalDate dob = LocalDate.parse(request.getParameter("date"));
		LocalDate doj = LocalDate.parse(request.getParameter("doj"));
		EmployeeDetails employee = new EmployeeDetails(empname, empcode, emailid, address1, address2, city, state, dob,
				doj);
		Business employ = new Business();
		int i = employ.insertEmp(employee);

		System.out.println("hand" + i);
		return i;

	}

	public List<EmployeeDetails> listEmployee(HttpServletRequest request) {
		List<EmployeeDetails> employeelist = null;
		Business employ = new Business();
		employeelist = employ.list();
		return employeelist;
	}

	public List<EmployeeDetails> searchEmployee(HttpServletRequest request) {
		String empcode = request.getParameter("empcode");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String localDate = request.getParameter("joiningDateFrom");
		LocalDate fromDate = null;
		if (!localDate.equals("")) {
			fromDate = LocalDate.parse(request.getParameter("joiningDateFrom"));
		}

		String localDateTo = request.getParameter("joiningDateTo");
		LocalDate toDate = null;
		if (!localDateTo.equals("")) {
			toDate = LocalDate.parse(request.getParameter("joiningDateTo"));
		}

		List<EmployeeDetails> employeelist = null;
        Business employ=new Business();
        employeelist= employ.searchList(empcode, city, state, fromDate, toDate);

		return employeelist;

	}

	public List<EmployeeDetails> updateDetails(HttpServletRequest request) {
		String empcode = request.getParameter("employcode");
		Business employee=new Business();
		List<EmployeeDetails> list=employee.updateDetails(empcode);

		return list;

	}

	public int updateEmployeeDetails(HttpServletRequest request) {
		String empname = request.getParameter("empname");
		String empcode = request.getParameter("empcode");
		String emailid = request.getParameter("email");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		LocalDate dob = LocalDate.parse(request.getParameter("date"));
		LocalDate doj = LocalDate.parse(request.getParameter("doj"));

		EmployeeDetails employee = new EmployeeDetails(empname, empcode, emailid, address1, address2, city, state, dob,
				doj);
		Business employ=new Business();
		int i=employ.updateList(employee);

		System.out.println("hand" + i);
		return i;

	}

}
