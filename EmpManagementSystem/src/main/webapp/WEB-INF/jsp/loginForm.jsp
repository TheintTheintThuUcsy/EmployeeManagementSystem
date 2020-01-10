
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>
<link rel="stylesheet" type="text/css"
	href="../lib/css/bootstrap.min.css" />
<script src="../lib/js/jquery.min.js"></script>
<script src="../lib/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1>Login</h1>
		</div>
		<form class="form-horizontal" action="/login" method="post">
			<div class="form-group">
				<div class="col-sm-2"></div>
				<div class="col-sm-4">
					<font color="#ff0000">${msg}</font>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="empId">Employee
					Id</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="empId"
						placeholder="Employee Id" value="${empId}"><span
						style="color: #ff0000">${errEmpId}</span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="Password">Password</label>
				<div class="col-sm-4">
					<input type="password" class="form-control" name="password"
						placeholder="Password" value="${password}"><span
						style="color: #ff0000">${errPassword}</span>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success">Login</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
