<%@page import="Tulip.Assignments.Staff"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,Tulip.Assignments.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Staff Login</title>
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
		width: 520px;
		background-color: #5dade2;
		padding: 10px;
		border-radius: 10px;
		box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
	}

	fieldset {
		background-color: #e6f2ff;
		border-radius: 8px;
		padding: 20px;
		border: none;
	}

	h1 {
		margin-top: 0;
		text-align: center;
		color: #154360;
	}

	label {
		display: block;
		margin-bottom: 5px;
		font-weight: bold;
		color: #003f5c;
	}

	input[type="text"],
	input[type="email"],
	select {
		width: 350px;
		padding: 7px;
		margin-bottom: 14px;
		border: 1px solid #ccc;
		border-radius: 4px;
	}

	.button-group {
		display: flex;
		justify-content: center;
		gap: 15px;
		margin-top: 10px;
	}

	input[type="submit"],
	input[type="reset"] {
		background-color: #2874a6;
		color: white;
		border: none;
		padding: 10px 20px;
		border-radius: 5px;
		cursor: pointer;
		font-size: 16px;
	}

	input[type="submit"]:hover,
	input[type="reset"]:hover {
		background-color: #1a5276;
	}
</style>
</head>
<body>
<div class="container">
    <form method="post" action="StaffServlet">
        <fieldset>
            <h1><b>Staff Login</b></h1>

            <label for="fullname">Full Name:</label>
            <input type="text" name="fullname" id="fullname" required>

            <label for="staffid">Staff ID:</label>
            <input type="text" name="staffid" id="staffid" required>

            <label for="role">Role:</label>
            <select name="role" id="role" required>
                <option value="warden">Warden</option>
                <option value="admin">Staff</option>
            </select>

            <label for="phone">Phone Number:</label>
            <input type="text" name="phoneNumber" id="phone" required>

            <label for="email">Email:</label>
            <input type="email" name="email" id="email" required>

            <div class="button-group">
                <input type="submit" value="Login">
                <input type="reset" value="Reset">
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>
