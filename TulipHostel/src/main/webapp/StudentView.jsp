<%@ page import="java.util.List" %>
<%@ page import="Tulip.Assignments.Student.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student List</title>
    <style>
        body {
            background-color: #5dade2;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }
        .container {
            background-color: #e6f2ff;
            padding: 20px;
            border-radius: 10px;
            max-width: 1000px;
            margin: auto;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
        }
        h1 {
            text-align: center;
            color: #154360;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #2874a6;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        form {
            display: inline;
        }
        .total {
            margin-top: 20px;
            text-align: right;
            font-weight: bold;
            color: #154360;
        }
        a.button, input[type="submit"] {
            background-color: #3498db;
            color: white;
            padding: 6px 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
        }
        a.button:hover, input[type="submit"]:hover {
            background-color: #21618c;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>List of Registered Students</h1>
    <table>
        <thead>
        <tr>
            <th>No</th>
            <th>Student ID</th>
            <th>Full Name</th>
            <th>Email</th>
            <th>Phone Number</th>
            <th>Course</th>
            <th>Semester</th>
            <th colspan="2">Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Student> studentList = (List<Student>) request.getAttribute("studentList");
            if (studentList != null && !studentList.isEmpty()) {
                int no = 1;
                for (Student s : studentList) {
        %>
        <tr>
            <td><%= no++ %></td>
            <td><%= s.getStudentId() %></td>
            <td><%= s.getFullName() %></td>
            <td><%= s.getEmail() %></td>
            <td><%= s.getPhoneNumber() %></td>
            <td><%= s.getCourse() %></td>
            <td><%= s.getSemester() %></td>
            <td>
                <form action="StudentUpdate" method="GET">
                    <input type="hidden" name="studentId" value="<%= s.getStudentId() %>">
                    <input type="submit" value="Update">
                </form>
            </td>
            <td>
                <form action="StudentDelete" method="POST">
                    <input type="hidden" name="id" value="<%= s.getStudentId() %>">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
        <%      }
            } else {
        %>
        <tr>
            <td colspan="9" style="text-align:center;">No students found.</td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <p class="total">Total Students Registered: <%= (studentList != null) ? studentList.size() : 0 %></p>
</div>
</body>
</html>
