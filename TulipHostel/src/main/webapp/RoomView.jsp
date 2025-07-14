<%@ page import="java.util.List" %>
<%@ page import="Tulip.Assignments.Room.Room" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Room Availability Checker</title>
    <style>
        body {
            background-color: #5dade2;
            font-family: Arial, sans-serif;
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

        h3 {
            text-align: center;
            color: #154360;
            font-size: 28px;
        }

        .dropdown-container {
            display: flex;
            justify-content: center;
            margin: 20px 0;
        }

        select {
            padding: 8px;
            font-size: 15px;
            border-radius: 5px;
            width: 320px;
            text-align: center;
            text-align-last: center;
        }

        select option {
            white-space: normal;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #2874a6;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .total {
            margin-top: 20px;
            text-align: right;
            font-weight: bold;
            color: #154360;
        }
    </style>
</head>
<body>
<div class="container">
    <h3>Room Availability Checker</h3>

    <div class="dropdown-container">
        <form method="get" action="RoomView">
            <select name="block" onchange="this.form.submit()" required>
                <option disabled <%= (request.getAttribute("selectedBlock") == null) ? "selected" : "" %>>
                    -- Select Block To View Availability --
                </option>
                <option value="ALL" <%= "ALL".equals(request.getAttribute("selectedBlock")) ? "selected" : "" %>>
                    All Blocks
                </option>
                <%
                    List<String> blockList = (List<String>) request.getAttribute("blockList");
                    String selectedBlock = (String) request.getAttribute("selectedBlock");
                    if (blockList != null) {
                        for (String block : blockList) {
                            String selected = block.equals(selectedBlock) ? "selected" : "";
                %>
                <option value="<%= block %>" <%= selected %>><%= block %></option>
                <%
                        }
                    }
                %>
            </select>
        </form>
    </div>

    <table>
        <thead>
        <tr>
            <th>No</th>
            <th>Room No</th>
            <th>Block</th>
            <th>Furniture</th>
            <th>Occupied</th>
            <th>Available</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Room> roomList = (List<Room>) request.getAttribute("roomList");
            if (roomList != null && !roomList.isEmpty()) {
                int no = 1;
                for (Room r : roomList) {
        %>
        <tr>
            <td><%= no++ %></td>
            <td><%= r.getRoomNo() %></td>
            <td><%= r.getBlock() %></td>
            <td><%= r.getFurnitureCapacity() %></td>
            <td><%= r.getOccupied() %></td>
            <td><%= r.getAvailable() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr><td colspan="6" style="text-align:center;">No rooms found.</td></tr>
        <% } %>
        </tbody>
    </table>

    <p class="total">Total Rooms Listed: <%= (roomList != null) ? roomList.size() : 0 %></p>
</div>
</body>
</html>
