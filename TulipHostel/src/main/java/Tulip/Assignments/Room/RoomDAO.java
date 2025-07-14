package Tulip.Assignments.Room;

import java.sql.*;
import java.util.ArrayList;

public class RoomDAO {
    private Connection connection;

    private void initJDBC() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/tulipdb", "root", "");
    }

    public ArrayList<Room> getAllRooms() {
        ArrayList<Room> rooms = new ArrayList<>();
        try {
            initJDBC();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM room");
            while (rs.next()) {
                Room r = new Room(
                			    rs.getString("roomNo"),
                			    rs.getString("block"),
                			    rs.getString("furniture"),
                			    rs.getInt("capacity"),
                			    rs.getInt("occupied")
                			);
                r.setAvailable(r.getCapacity() - r.getOccupied());
                rooms.add(r);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }
}