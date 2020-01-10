<!DOCTYPE html>
<html lang="en">
<head>
<title>New Employee</title>
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
			<h1>New Employee</h1>
		</div>
		<form class="form-horizontal" action="/insertEmployee" method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="employeeId">Employee
					Id:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="empId"
						value="${userInputedID}" placeholder="Enter employee id"
						name="empId"><span id="errEmpId" style="color: #ff0000">${errEmpId}</span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="employeeName">Employee
					Name:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="empName"
						value="${userInputedName}" placeholder="Enter employee name"
						name="name"><span id="errEmpName" style="color: #ff0000">${errEmpName}</span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="position">Role:</label>
				<div class="col-sm-4">
					<select class="form-control" name="role">
						<option value="Employee"
							${userSelectedRole == 'Employee' ? 'selected' : ''}>Employee</option>
						<option value="Admin"
							${userSelectedRole == 'Admin' ? 'selected' : ''}>Admin</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="position">Position:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="position"
						value="${userInputedPosition}" placeholder="Enter position"
						name="position"><span id="errPosition"
						style="color: #ff0000">${errPosition}</span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="teamName">Team
					Name:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="teamName"
						value="${userInputedTeamName}" placeholder="Enter team name"
						name="teamName"><span id="errTeamName"
						style="color: #ff0000">${errTeamName}</span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="basicSalary">Basic
					Salary:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="basicSalary"
						value="${userInputedBasicSalary}" placeholder="Enter basic salary"
						name="basicSalary"> <span id="errBasicSalary"
						style="color: #ff0000">${errBasicSalary}</span>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success">Add</button>
					<button type="button" class="btn btn-primary" name="back" onclick="history.back()">Back</button> 
				</div>
			</div>
		</form>
	</div>
</body>
</html>
