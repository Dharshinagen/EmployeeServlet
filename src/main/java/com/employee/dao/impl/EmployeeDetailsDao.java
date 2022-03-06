package com.employee.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.employee.connectionUtil.ConnectionUtil;
import com.employee.model.EmployeeDetails;

public class EmployeeDetailsDao {
	public int addEmployee(EmployeeDetails employee) {
		String insertEmployee = "insert into employee_details (employee_name, employee_code, email, address1, address2, city, state, date_of_birth, joining_date) values(?,?,?,?,?,?,?,?,?)";
		int flag = 0;
		Connection con = null;
		PreparedStatement preStatement = null;
		try {
			con = ConnectionUtil.getDbConnection();
			preStatement = con.prepareStatement(insertEmployee);
			preStatement.setString(1, employee.getEmployeeName());
			preStatement.setString(2, employee.getEmployeeCode());
			preStatement.setString(3, employee.getEmail());
			preStatement.setString(4, employee.getAddress1());
			preStatement.setString(5, employee.getAddress2());
			preStatement.setString(6, employee.getCity());
			preStatement.setString(7, employee.getState());
			preStatement.setDate(8, java.sql.Date.valueOf(employee.getDateOfBirth()));
			preStatement.setDate(9, java.sql.Date.valueOf(employee.getJoiningDate()));
			preStatement.executeUpdate();
			flag = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatement(preStatement, con);
		}
		return flag;
	}

	public List<EmployeeDetails> viewEmployeeDetail() throws SQLException {
		List<EmployeeDetails> list = new ArrayList<>();

		String query = "select  employee_name,employee_code,email,address1,address2,city,state,date_of_birth,joining_date from employee_details order by employee_code";
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.createStatement();
			rs = statement.executeQuery(query);
			while (rs.next()) {
				EmployeeDetails empDetail = new EmployeeDetails(rs.getString("Employee_Name"),
						rs.getString("employee_code"), rs.getString("email"), rs.getString("address1"),
						rs.getString("address2"), rs.getString("city"), rs.getString("state"),
						rs.getDate("date_of_birth").toLocalDate(), rs.getDate("joining_date").toLocalDate());
				list.add(empDetail);

			}
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			if (rs != null)
				rs.close();
			if (statement != null) {
				statement.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return list;
	}

	@SuppressWarnings("resource")
	public List<EmployeeDetails> searchEmployee(String empCode, String city, String state, LocalDate fromDate,
			LocalDate toDate) throws SQLException {
		Connection con = null;
		Statement prestatement = null;
		Statement statement = null;
		ResultSet rs = null;
		ResultSet reset = null;
		LocalDate date = null;
		LocalDate todaydate=null;
		List<EmployeeDetails> list = new ArrayList<>();
		String dateQuery = "select sysdate from dual";

		StringBuilder query = new StringBuilder();
		query.append(" select employee_code,employee_name,email,city,state,joining_date from employee_Details ");
		if (!empCode.equals("") && !city.equals("") && !state.equals("") && !fromDate.equals("")
				&& !toDate.equals("")) {
			query.append(" where employee_code= " + "'" + empCode + "'" + "and city=" + "'" + city + "'" + "and state ="
					+ "'" + state + "'");
			query.append(" and to_char(joining_date,'yyyy-mm-dd') between  " + "'" + fromDate + "'" + " and " + "'"
					+ toDate + "'");
		} else if (!empCode.equals("") || !city.equals("") || !state.equals("") || !fromDate.equals("")
				|| !toDate.equals("")) {
			query.append(" where ");

			if (!empCode.equals("")) {
				query.append(" employee_code= " + "'" + empCode + "'");
			}

			if (!city.equals("")) {
				if (empCode.equals("")) {
					query.append(" lower(city) like " + "'" + city.toLowerCase() + "%'");
				} else {
					query.append(" and lower(city) like " + "'" + city.toLowerCase() + "%'");
				}

			}
			if (!state.equals("")) {
				if (empCode.equals("") && city.equals("")) {
					query.append(" lower(state) like " + "'" + state.toLowerCase() + "%'");
				} else if (empCode.equals("") || city.equals("")) {
					query.append(" and lower(state) like " + "'" + state.toLowerCase() + "%'");
				} else {
					query.append("and lower(state) like " + "'" + state.toLowerCase() + "%'");
				}

			}
//			if (toDate.equals("")) {
//				System.out.println("date"+date);
//				toDate = date;
//				System.out.println("to"+toDate);
//			}
			System.out.println("todate"+toDate);
			if (fromDate != null && toDate != null) {

				if (empCode.equals("") && (city.equals("")) && (state.equals(""))) {

					query.append(" to_char(joining_date,'yyyy-mm-dd') between  " + "'" + fromDate + "' and '" + toDate
							+ "'");
				} else {
					query.append("and to_char(joining_date,'yyyy-mm-dd') between  " + "'" + fromDate + "' and '"
							+ toDate + "'");
				}
			} else if (fromDate != null) {
               System.out.println("elseif");
				if (empCode.equals("") && (city.equals("")) && (state.equals(""))) {

					query.append(" to_char(joining_date,'yyyy-mm-dd') between " + "'" + fromDate + "' and '" + todaydate
							+ "'");
				} else {
					query.append("and to_char(joining_date,'yyyy-mm-dd') between  " + "'" + fromDate + "' and '" + todaydate
							+ "'");
				}
			}

		}

		String sql = query.toString();

		try {
			con = ConnectionUtil.getDbConnection();
		 	if (toDate ==null) {
				prestatement = con.createStatement();
				reset = prestatement.executeQuery(dateQuery);
				if (reset.next()) {
					date = reset.getDate("sysdate").toLocalDate();
					System.out.println("sys"+date);

			   	todaydate=date;
			   	System.out.println("todate"+todaydate);
				}
			}
			statement = con.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				EmployeeDetails employee = new EmployeeDetails(rs.getString("employee_name"),
						rs.getString("employee_code"), rs.getString("email"), rs.getString("city"),
						rs.getString("state"), rs.getDate("joining_date").toLocalDate());
				list.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (statement != null)
				statement.close();
			if (prestatement != null)
				prestatement.close();
			if (con != null)
				con.close();

		}
		return list;
	}

	public int updateEmployeeDetail(EmployeeDetails employee) {
		String updateQuery = "update employee_details set employee_name=?,email=?,address1=?,address2=?,city=?,state=?,date_of_birth=?,joining_date=? where employee_code=?";
		int flag = 0;
		Connection con = null;
		PreparedStatement preStatement = null;
		try {
			con = ConnectionUtil.getDbConnection();
			preStatement = con.prepareStatement(updateQuery);
			preStatement.setString(1, employee.getEmployeeName());
			preStatement.setString(2, employee.getEmail());
			preStatement.setString(3, employee.getAddress1());
			preStatement.setString(4, employee.getAddress2());
			preStatement.setString(5, employee.getCity());
			preStatement.setString(6, employee.getState());
			preStatement.setDate(7, java.sql.Date.valueOf(employee.getDateOfBirth()));
			preStatement.setDate(8, java.sql.Date.valueOf(employee.getJoiningDate()));
			preStatement.setString(9, employee.getEmployeeCode());
			preStatement.executeUpdate();
			flag = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatement(preStatement, con);
		}
		return flag;
	}

	public List<EmployeeDetails> getEmployeeDetails(String empcode) {
		String query = "select employee_name,employee_code,email,address1,address2,city,state,date_of_birth,joining_date from employee_details where employee_code=?";
		List<EmployeeDetails> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, empcode);
			rs = ps.executeQuery();
			while (rs.next()) {
				EmployeeDetails empDetail = new EmployeeDetails(rs.getString("Employee_Name"),
						rs.getString("employee_code"), rs.getString("email"), rs.getString("address1"),
						rs.getString("address2"), rs.getString("city"), rs.getString("state"),
						rs.getDate("date_of_birth").toLocalDate(), rs.getDate("joining_date").toLocalDate());
				list.add(empDetail);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

}
