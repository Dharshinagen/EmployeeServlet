<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>search</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
.t1 {
	margin-right: 370px;
	font-size: 15px;
}

.cls {
	border-radius: 3px;
	padding: 2px 2px 2px 2px;
	Background-color: transparent;
}

a {
	text-decoration: none;
	color: black;
}

.div1 {
	padding-left: 460px;
}

.btn2 {
	padding: 5px;
	color: white;
	background-color: green;
	margin-right: 30px;
	border: 0;
	border-radius: 3px;
}

.btn3 {
	margin-left: 90px;
}

body {
	background-color: rgba(198, 208, 214, .9);
}

.tabled {
	padding-left: 20px;
	text-align: justify;
	padding-bottom: 8px;
}

.tableh {
	text-align: justify;
	padding-left: 30px;
	padding-bottom: 8px;
}
</style>
</head>
<body>
	 
	<form action="SearchServ" method="post">
	<fieldset>
	<legend>Search Detail</legend>
		<table>
			<tr>
				<th class="tableh"><label for="empcode">Employee Code</label></th>
				<td class="tabled"><input type="text" class="cls"
					name="empcode" id="empcode"></td>
			</tr>
			<tr>
				<th class="tableh"><label for="city">City</label></th>
				<td class="tabled"><input type="text" class="cls" name="city"
					id="city"></td>
			</tr>
			<tr>
				<th class="tableh"><label for="state">State</label></th>
				<td class="tabled"><input type="text" class="cls" name="state"
					id="state"></td>
			</tr>
			<tr>
				<th class="tableh"><label for="joiningDateFrom">Joining
						Date From</label></th>
				<td class="tabled"><input type="date" class="cls"
					name="joiningDateFrom" id="joiningDateFrom"></td>

				<th class="tableh"><label for="joiningDateTo"> To</label></th>
				<td class="tabled"><input type="date" class="cls"
					name="joiningDateTo" id="joiningDateTo"></td>
			</tr>
		</table>
		<br>
		<div class="btn3">
			<button>Search</button>
			<button><a href="employee.jsp">Back</a></button>
		</div>
		</fieldset>
	</form>
	<div class="container mt-4 mb-4">
		<table class="table table-hover table-striped">
			<caption>
				<thead>
					<tr>
						<th>S.no</th>
						<th>Employee name</th>
						<th>Employee code</th>
						<th>Email Id</th>
						<th>city</th>
						<th>state</th>
						<th>Joining Date</th>
					</tr>
				</thead>

				<tbody>

					<c:set var="i" value="0" />
					<c:forEach items="${searchlist}" var="viewEmployee">
						<c:set var="i" value="${i+1}" />
						<tr>

							<td>${i}</td>
							<td><a
								href="UpdateServ?employcode=${viewEmployee.employeeCode}">${viewEmployee.employeeName}</a></td>
							<td><a
								href="UpdateServ?employcode=${viewEmployee.employeeCode}">${viewEmployee.employeeCode}</a></td>
							<td><a
								href="UpdateServ?employcode=${viewEmployee.employeeCode}">${viewEmployee.email}</a></td>
							<td><a
								href="UpdateServ?employcode=${viewEmployee.employeeCode}">${viewEmployee.city}</a></td>
							<td><a
								href="UpdateServ?employcode=${viewEmployee.employeeCode}">${viewEmployee.state}</a></td>
							<td><a
								href="UpdateServ?employcode=${viewEmployee.employeeCode}">${viewEmployee.joiningDate}</a></td>
						</tr>

					</c:forEach>
				</tbody>
			</caption>
		</table>
	</div>
</body>
</html>

