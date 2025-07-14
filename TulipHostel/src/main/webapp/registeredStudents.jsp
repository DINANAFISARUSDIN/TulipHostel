<%@page import="Tulip.Assignments.Student.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,Tulip.Assignments.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration</title>
<style>
	body {
		background-color: #5dade2;
		font-family: Arial, sans-serif;
		margin: 0;
		height: 100vh;
		display: flex;
		justify-content: center;
		align-items: center;
	}

	.container {
		width: 550px;
		background-color: #5dade2;
		padding: 20px;
		border-radius: 12px;
		box-shadow: 0 0 20px rgba(0, 0, 0, 0.25);
	}

	fieldset {
		background-color: #e6f2ff;
		border-radius: 10px;
		padding: 30px;
		border: none;
	}

	h1 {
		text-align: center;
		color: #154360;
		margin-bottom: 25px;
	}

	label {
		display: block;
		margin-bottom: 6px;
		font-weight: bold;
		color: #003f5c;
	}

	input[type="text"],
	input[type="email"],
	input[type="password"],
	select {
		width: 100%;
		padding: 8px;
		margin-bottom: 16px;
		border: 1px solid #ccc;
		border-radius: 4px;
		box-sizing: border-box;
	}

	.gender-inline {
		display: flex;
		align-items: center;
		gap: 25px;
		margin-bottom: 16px;
	}

	.button-group {
		display: flex;
		justify-content: center;
		flex-wrap: wrap;
		gap: 15px;
		margin-top: 20px;
	}

	input[type="submit"],
	input[type="reset"],
	.back-button {
		background-color: #2874a6;
		color: white;
		border: none;
		padding: 10px 25px;
		border-radius: 6px;
		cursor: pointer;
		font-size: 16px;
		text-decoration: none;
		text-align: center;
		transition: background-color 0.3s;
	}

	input[type="submit"]:hover,
	input[type="reset"]:hover,
	.back-button:hover {
		background-color: #1a5276;
	}
</style>
</head>
<body>
	<div class="container">
		<form method="post" action="StudentServlet">
			<fieldset> 
				<h1><b>Student Registration Form</b></h1>

				<label for="fullname">Full Name:</label>
				<input type="text" name="fullName" id="fullname" required>

				<label for="studentid">Student ID:</label>
				<input type="text" name="studentId" id="studentid" required>

				<label for="phone">Phone Number:</label>
				<input type="text" name="phoneNumber" id="phone" required>

				<label>Gender:</label>
				<div class="gender-inline">
					<input type="radio" name="gender" value="1" id="male" required>
					<label for="male">Male</label>
					<input type="radio" name="gender" value="0" id="female">
					<label for="female">Female</label>
				</div>

				<label for="email">Email:</label>
				<input type="email" name="email" id="email" required>

				<label for="password">Password:</label>
				<input type="password" name="password" id="password" required>

				<label for="course">Course:</label>
				<input type="text" name="course" id="course" required>

				<label for="semester">Semester:</label>
				<input type="text" name="semester" id="semester" required>

				<div class="button-group">
					<input type="submit" value="Submit">
					<input type="reset" value="Reset">
					<a href="index.jsp" class="back-button">Back to Home</a>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>
