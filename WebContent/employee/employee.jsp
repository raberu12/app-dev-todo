<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>
</head>
<body>
	<h2>Add Employee Details</h2>
	<form action="addEmployee" method="post">
		<label for="employeeId">Employee ID:</label><br> <input
			type="text" id="employeeId" name="employeeId" required><br>
		<br> <label for="firstName">First Name:</label><br> <input
			type="text" id="firstName" name="firstName" required><br>
		<br> <label for="lastName">Last Name:</label><br> <input
			type="text" id="lastName" name="lastName" required><br>
		<br> <label for="department">Department:</label><br> <input
			type="text" id="department" name="department" required><br>
		<br> <label for="position">Position:</label><br> <input
			type="text" id="position" name="position" required><br>
		<br> <input type="submit" value="Add Employee">
	</form>
</body>
</html>
