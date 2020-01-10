<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
<link rel="stylesheet" type="text/css"
	href="../lib/css/bootstrap.min.css" />
<script src="../lib/js/jquery.min.js"></script>
<script src="../lib/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
		<div class="page-header">
			<h1>Change Password</h1>
		</div>
		<form class="form-horizontal" action="/changePassword/${loginEmpId}" method="post">
			<div class="form-group">
				<div class="col-sm-2"></div>
				<div class="col-sm-4">
					<font color="#ff0000">${msg}</font>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="oldPassword">Old Password</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="oldPassword"
						placeholder="Old Password" value="${oldPassword}"><span
						style="color: #ff0000">${errOldPassword}</span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="newPassword">New Password</label>
				<div class="col-sm-4">
					<input type="password" class="form-control" name="newPassword"
						placeholder="New Password" value="${newPassword}"><span
						style="color: #ff0000">${errNewPassword}</span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="confirmNewPassword">Confirm New Password</label>
				<div class="col-sm-4">
					<input type="password" class="form-control" name="confirmNewPassword"
						placeholder="Confirm New Password" value="${confirmNewPassword}"><span
						style="color: #ff0000">${errConfirmNewPassword}</span>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success">Change Password</button>
					<button type="button" class="btn btn-primary" name="back" onclick="history.back()">Back</button> 
				</div>
			</div>
		</form>
	</div>
</body>
</html>