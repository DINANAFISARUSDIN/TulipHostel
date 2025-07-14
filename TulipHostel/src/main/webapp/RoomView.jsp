<%@ page import="java.util.List" %>
<%@ page import="Tulip.Assignments.Room.Room" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Room List</title>
    <style>
        body { background-color: #5dade2; font-family: Arial, sans-serif; padding: 20px; }
        .container {
            background-color: #e6f2ff; padding: 20px; border-radius: 10px;
            max-width: 1000px; margin: auto; box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
        }
        h1 { text-align: center; color: #154360; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }
        th { background-color: #2874a6; color: white; }
        tr:nth-child(even) { background-color: #f2f2f2; }
        .total { margin-top: 20px; text-align: right; font-weight: bold; color: #154360; }
    </style>
</head>
<body>
<div class="container">
    <h1>List of Rooms</h1>
    <table>
        <thead>
        <tr>
            <th>No</th>
            <th>Room No</th>
            <th>Block</th>
            <th>Furniture</th>
            <th>Capacity</th>
            <th>Occupied</th>
            <th>Available</th>
        </tr>
        </thead>
        <tbody>
        <% List<Room> roomList = (List<Room>) request.getAttribute("roomList");
           if (roomList != null && !roomList.isEmpty()) {
               int no = 1;
               for (Room r : roomList) {
        %>
        <tr>
            <td><%= no++ %></td>
            <td><%= r.getRoomNo() %></td>
            <td><%= r.getBlock() %></td>
            <td><%= r.getFurniture() %></td>
            <td><%= r.getCapacity() %></td>
            <td><%= r.getOccupied() %></td>
            <td><%= r.getAvailable() %></td>
        </tr>
        <%   } } else { %>
        <tr><td colspan="7" style="text-align:center;">No rooms found.</td></tr>
        <% } %>
        </tbody>
    </table>
    <p class="total">Total Rooms Listed: <%= (roomList != null) ? roomList.size() : 0 %></p>
</div>
</body>
</html>
