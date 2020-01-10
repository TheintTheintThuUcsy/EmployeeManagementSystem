<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Employee Data</title>
<link rel="stylesheet" type="text/css"
	href="../lib/css/bootstrap.min.css" />
<script src="../lib/js/jquery.min.js"></script>
<script src="../lib/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="../lib/css/table.css" />
</head>
<body>
	<div class="page-header">
		<h1>All Employee Data</h1>
	</div>
	<div class="table-responsive">
		<table class="class" id="myTable">
			<tr class="header">
				<th>Employee Id</th>
				<th>Employee Name</th>
				<th>Position</th>
				<th>Role</th>
				<th>Team Name</th>
				<th>Basic Salary</th>
			</tr>
			<c:forEach var="emp" items="${empList}">
				<tr>
					<td><a href="/showEmpData/${emp.empId}">${emp.empId}</a></td>
					<td>${emp.name}</td>
					<td>${emp.position}</td>
					<td><c:choose>
							<c:when test="${emp.role=='0'}">Employee</c:when>
							<c:otherwise>Admin</c:otherwise>
						</c:choose></td>
					<td>${emp.teamName}</td>
					<td>${emp.basicSalary}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br />
	<a href="/showAddNewEmplyeePage" class="btn btn-info" role="button">Add
		New Employee</a>
	<a href="/showChangePasswordPage/${loginEmpId}" class="btn btn-info" role="button">Change
		Password</a>
</body>
</html>