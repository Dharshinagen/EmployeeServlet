<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>search</title>
</head>
<body>
	<h2>Employee List </h2>
	  <button><a href="searchList.jsp">Search</a></button>
	  <table>
		<caption>
			<thead>
				<tr>
					<th>S.no</th>
					<th>Employee name</th>
					<th>Employee code</th>
					<th>Emailid</th>
					<th>Address1</th>
					<th>Address2</th>
					<th>city</th>
					<th>state</th>
					<th>DOB</th>
					<th>DOJ</th>
				</tr>
			</thead>

			<tbody>

				<c:set var="i" value="0" />
				<c:forEach items="${employeeList}" var="viewEmployee">
					<c:set var="i" value="${i+1}" />
					<tr>

						<td>${i}</td>
						<td>${viewEmployee.employeeName}</td>
						<td>${viewEmployee.employeeCode}</td>
						<td>${viewEmployee.email}</td>
						<td>${viewEmployee.address1}</td>
						<td>${viewEmployee.address2}</td>
						<td>${viewEmployee.city}</td>
						<td>${viewEmployee.state}</td>
						<td>${viewEmployee.dateOfBirth}</td>
						<td>${viewEmployee.joiningDate}</td>

					</tr>

				</c:forEach>
			</tbody>
		</caption>
	</table>
</body>
</html>

