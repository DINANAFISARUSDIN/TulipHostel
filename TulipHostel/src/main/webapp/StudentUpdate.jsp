<%@ page import="Tulip.Assignments.Student.Student" %>
<%
    Student s = (Student) request.getAttribute("student_data");
    if (s == null) {
%>
    <p>No student found. <a href="StudentView">Back to List</a></p>
<% return; } %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Student</title>
    <style>
        body {
            background-color: #5dade2;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }
        .form-container {
            background-color: #e6f2ff;
            padding: 20px;
            border-radius: 10px;
            max-width: 500px;
            margin: auto;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
        }
        h2 {
            text-align: center;
            color: #154360;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            margin-top: 10px;
            font-weight: bold;
        }
        input, select {
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .actions {
            margin-top: 20px;
            display: flex;
            justify-content: space-between;
        }
        input[type="submit"], a.button {
            background-color: #3498db;
            color: white;
            padding: 10px;
            border: none;
            text-align: center;
            border-radius: 5px;
            text-decoration: none;
            cursor: pointer;
        }
        input[type="submit"]:hover, a.button:hover {
            background-color: #21618c;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h2>Update Student Information</h2>
    <form action="StudentUpdate" method="post">
        <input type="hidden" name="action" value="update" />
        <input type="hidden" name="studentId" value="<%= s.getStudentId() %>" />

        <label>Full Name:</label>
        <input type="text" name="fullName" value="<%= s.getFullName() %>" required />

        <label>Gender:</label>
        <select name="gender">
            <option value="Male" <%= s.getGender().equals("Male") ? "selected" : "" %>>Male</option>
            <option value="Female" <%= s.getGender().equals("Female") ? "selected" : "" %>>Female</option>
        </select>

        <label>Course:</label>
        <input type="text" name="course" value="<%= s.getCourse() %>" required />

        <label>Semester:</label>
        <input type="number" name="semester" value="<%= s.getSemester() %>" required />

        <label>Phone Number:</label>
        <input type="text" name="phoneNumber" value="<%= s.getPhoneNumber() %>" required />

        <label>Email:</label>
        <input type="email" name="email" value="<%= s.getEmail() %>" required />

        <label>Password:</label>
        <input type="password" name="password" value="<%= s.getPassword() %>" required />

        <div class="actions">
            <input type="submit" value="Update Student" />
            <a class="button" href="StudentView">Cancel</a>
        </div>
    </form>
</div>
</body>
</html>
