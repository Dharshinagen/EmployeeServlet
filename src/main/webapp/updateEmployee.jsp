<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update</title>
<style>
.t1 {
	margin-right: 370px;
	font-size: 18px;
}

.cls {
	border-radius: 3px;
	padding: 5px 5px 5px 5px;
	Background-color: transparent;
}

a {
	text-decoration: none;
	color: white;
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

td {
	padding-left: 20px;
	text-align: justify;
	padding-bottom: 8px;
}

th {
	text-align: justify;
	padding-left: 30px;
	padding-bottom: 8px;
}
</style>
</head>
<body>
	<h1>Update Details</h1>
	<form action="UpdateDetailsServ" method="post">
		<div class="t1">
			<table>
				<c:forEach items="${upList}" var="UpdateDetails">
					<tr>
						<th><label for="empname">Employee Name</label></th>
						<td><input type="text" id="empname" name="empname" class="cls"
							value='<c:out value="${UpdateDetails.employeeName}"></c:out>'
							autofocus pattern="[A-Za-z]{5,}" required></td>
					</tr>

					<tr>
						<th><label for="empcode">Employee Code</label></th>
						<td><input type="text" name="empcode" id="empcode" class="cls"
							value='<c:out value="${UpdateDetails.employeeCode}"></c:out>'
							readonly required></td>
					</tr>
					<tr>
						<th><label for="email">Email Address</label></th>
						<td><input type="email" name="email" id="email" class="cls"
							value='<c:out value="${UpdateDetails.email}"></c:out>' required></td>
					</tr>
					<tr>
						<th><label for="address1">Address Line1</label></th>
						<td><input type="text" name="address1" id="address1" class="cls"
							value='<c:out value="${UpdateDetails.address1}"></c:out>'
							required></td>
					</tr>
					<tr>
						<th><label for="address2">Address Line2</label></th>
						<td><input type="text" name="address2" id="address2" class="cls"
							value='<c:out value="${UpdateDetails.address2}"></c:out>'
							required></td>
					</tr>
					<tr>
						<th><label for="city">City</label></th>
						<td><input type="text" name="city" id="city" class="cls"
							value='<c:out value="${UpdateDetails.city}"></c:out>' required></td>
					</tr>
					<tr>
						<th><label for="state">State</label></th>
						<td><input type="text" name="state" id="state" class="cls"
							value='<c:out value="${UpdateDetails.state}"></c:out>' required></td>
					</tr>
					<tr>
						<th><label for="date">Date Of Birth</label></th>
						<td><input type="date" name="date" id="date" class="cls"
							value='<c:out value="${UpdateDetails.dateOfBirth}"></c:out>'
							required></td>
					</tr>
					<tr>
						<th><label for="doj">Date Of Joining</label></th>
						<td><input type="date" name="doj" id="doj" class="cls"
							value='<c:out value="${UpdateDetails.joiningDate}"></c:out>'
							required></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<button>Submit</button>
</body>
</html>