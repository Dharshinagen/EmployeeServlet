package com.employee.Business;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.employee.dao.impl.EmployeeDetailsDao;
import com.employee.model.EmployeeDetails;

public class Business {

	public int insertEmp(EmployeeDetails employee) {
		EmployeeDetailsDao empdao = new EmployeeDetailsDao();
		int i = empdao.addEmployee(employee);
		return i;
	}

	public List<EmployeeDetails> list() {

		List<EmployeeDetails> employeelist = null;
		try {
			EmployeeDetailsDao empdao = new EmployeeDetailsDao();
			employeelist = empdao.viewEmployeeDetail();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeelist;
	}

	public List<EmployeeDetails> searchList(String empcode, String city, String state, LocalDate fromDate,
			LocalDate toDate) {
		EmployeeDetailsDao employeedetails = new EmployeeDetailsDao();
		List<EmployeeDetails> employeelist = null;
		try {
			employeelist = employeedetails.searchEmployee(empcode, city, state, fromDate, toDate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeelist;
	}

	public int updateList(EmployeeDetails employee) {
		EmployeeDetailsDao empdao = new EmployeeDetailsDao();
		int i = empdao.updateEmployeeDetail(employee);
		return i;
	}

	public List<EmployeeDetails> updateDetails(String empcode) {
		EmployeeDetailsDao empdao = new EmployeeDetailsDao();
		List<EmployeeDetails> list = empdao.getEmployeeDetails(empcode);
		return list;
	}

}
