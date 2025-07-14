<%@ page import="Tulip.Assignments.Student.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Student</title>
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
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
            width: 500px;
            text-align: center;
        }

        h2 {
            color: #154360;
            margin-bottom: 20px;
        }

        p {
            font-size: 16px;
            color: #003f5c;
            margin-bottom: 25px;
        }

        .button-group {
            display: flex;
            justify-content: center;
            gap: 15px;
        }

        button, a.button-link {
            background-color: #2874a6;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            text-decoration: none;
            display: inline-block;
        }

        button:hover, a.button-link:hover {
            background-color: #1a5276;
        }

        .back-link {
            display: inline-block;
            margin-top: 20px;
            color: #154360;
            text-decoration: underline;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Confirm Delete Student</h2>
        <%
            Student s = (Student) request.getAttribute("student_data");
            if (s != null) {
        %>
        <p>Are you sure you want to delete <strong><%= s.getFullName() %></strong> (ID: <%= s.getStudentId() %>)?</p>
        <div class="button-group">
            <form method="post" action="StudentDelete">
                <input type="hidden" name="id" value="<%= s.getStudentId() %>">
                <button type="submit" name="confirm" value="yes">Yes, Delete</button>
            </form>
            <a href="StudentView" class="button-link">Cancel</a>
        </div>
        <% } else { %>
        <p>Student not found.</p>
        <a href="StudentView" class="button-link">Back to Student List</a>
        <% } %>
    </div>
</body>
</html>
