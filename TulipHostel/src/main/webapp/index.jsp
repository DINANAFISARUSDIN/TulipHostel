<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome to Tulip Portal</title>
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
            background-color: #e6f2ff;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.25);
            text-align: center;
            width: 450px;
        }

        h1 {
            color: #154360;
            margin-bottom: 30px;
        }

        .button {
            display: block;
            width: 100%;
            margin: 10px 0;
            padding: 12px;
            background-color: #2874a6;
            color: white;
            text-decoration: none;
            font-size: 18px;
            border-radius: 6px;
            transition: background-color 0.3s ease;
        }

        .button:hover {
            background-color: #1a5276;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to Tulip Portal</h1>

        <a href="registeredStudents.jsp" class="button">Student Registration</a>
        <a href="StaffLogin.jsp" class="button">Staff Login</a>
    </div>
</body>
</html>
