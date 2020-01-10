<!DOCTYPE html>
<html lang="en">
<head>
<title>Employee Data</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="../lib/css/bootstrap.min.css" />
<script src="../lib/js/jquery.min.js"></script>
<script src="../lib/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<div class="page-header">
			<h1>Employee Data</h1>
		</div>
		<form class="form-horizontal" action="/edit/${emp.id}" method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="position">Employee
					Id:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" value="${emp.empId}"
						id="empId" name="empId" readonly="true">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="employeeName">Employee
					Name:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" value="${emp.name}"
						id="name" name="name" readonly="true">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="position">Position:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" value="${emp.position}"
						id="position" placeholder="Enter position" name="position"
						${emp.role == 0 ? 'readonly' : ''}> <span
						style="color: #ff0000">${errPosition}</span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="teamName">Role:</label>
				<div class="col-sm-4">
					<select class="form-control" name="role"
						${loginRole == 0 ? 'readonly' : ''}>
						<option value="Employee" ${emp.role == 0 ? 'selected' : ''}>Employee</option>
						<option value="Admin" ${emp.role == 1 ? 'selected' : ''}>Admin</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="teamName">Team
					Name:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" value="${emp.teamName}"
						id="teamName" placeholder="Enter team name" name="teamName"
						${emp.role == 0 ? 'readonly' : ''}> <span
						style="color: #ff0000">${errTeamName}</span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="basicSalary">Basic
					Salary:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" value="${emp.basicSalary}"
						id="basicSalary" placeholder="Enter basic salary"
						name="basicSalary" ${emp.role == 0 ? 'readonly' : ''}> <span
						style="color: #ff0000">${errBasicSalary}</span>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success"
						${loginRole == 0 ? 'disabled' : ''}>Edit</button>
					<a href="/showChangePasswordPage/${loginEmpId}"
						class="btn btn-info" role="button">Change Password</a>
					<button type="button" class="btn btn-primary" name="back" onclick="history.back()" ${loginRole == 0 ? 'disabled' : ''}>Back</button> 
				</div>
			</div>
		</form>
	</div>
</body>
</html>
