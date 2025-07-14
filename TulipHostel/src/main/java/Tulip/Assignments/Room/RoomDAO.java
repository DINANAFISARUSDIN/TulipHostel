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
                        rs.getString("furnitureCapacity"),
                        rs.getInt("occupied"),
                        rs.getInt("available")
                );
                rooms.add(r);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public ArrayList<Room> getRoomsByBlock(String block) {
        ArrayList<Room> list = new ArrayList<>();
        try {
            initJDBC();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM room WHERE block = ?");
            ps.setString(1, block);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Room(
                    rs.getString("roomNo"),
                    rs.getString("block"),
                    rs.getString("furnitureCapacity"),
                    rs.getInt("occupied"),
                    rs.getInt("available")
                ));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<String> getUniqueBlocks() {
        ArrayList<String> blocks = new ArrayList<>();
        try {
            initJDBC();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT block FROM room");
            while (rs.next()) {
                blocks.add(rs.getString("block"));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return blocks;
    }}

