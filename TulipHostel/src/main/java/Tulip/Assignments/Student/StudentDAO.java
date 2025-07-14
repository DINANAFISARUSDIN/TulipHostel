package Tulip.Assignments.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {
    private Statement statement;
    private Connection connection;

    public StudentDAO() {
        super();
        this.statement = statement;
        this.connection = connection;
    }


    private void initJDBC() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/tulipdb", "root", "");
    }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            initJDBC();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                Student s = new Student(
                        rs.getString("studentId"),
                        rs.getString("fullName"),
                        rs.getString("gender"),
                        rs.getString("course"),
                        rs.getInt("semester"),
                        rs.getString("phoneNumber"),
                        rs.getString("email"),
                        rs.getString("password")
                );
                students.add(s);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }


    // insert student
    public int addStudent(Student s) {
        int status = -1;
        try {
            initJDBC();
            String sql = "INSERT INTO students (studentId, fullName, gender, course, semester, phoneNumber, email, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, s.getStudentId());
            ps.setString(2, s.getFullName());
            ps.setString(3, s.getGender());
            ps.setString(4, s.getCourse());
            ps.setInt(5, s.getSemester());
            ps.setString(6, s.getPhoneNumber());
            ps.setString(7, s.getEmail());
            ps.setString(8, s.getPassword());

            status = ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // get by id
    public Student getStudentById(String id) {
        Student s = null;
        try {
            initJDBC();
            String sql = "SELECT * FROM students WHERE studentId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                s = new Student(
                    rs.getString("studentId"),
                    rs.getString("fullName"),
                    rs.getString("gender"),
                    rs.getString("course"),
                    rs.getInt("semester"),
                    rs.getString("phoneNumber"),
                    rs.getString("email"),
                    rs.getString("password")
                );
            }
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    // update
    public int updateStudent(Student s) {
        int status = -1;
        try {
            initJDBC();
            String sql = "UPDATE students SET fullName = ?, gender = ?, course = ?, semester = ?, phoneNumber = ?, email = ?, password = ? WHERE studentId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, s.getFullName());
            ps.setString(2, s.getGender());
            ps.setString(3, s.getCourse());
            ps.setInt(4, s.getSemester());
            ps.setString(5, s.getPhoneNumber());
            ps.setString(6, s.getEmail());
            ps.setString(7, s.getPassword());
            ps.setString(8, s.getStudentId());

            status = ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    // delete
    public int deleteStudentById(String studentId) {
        int status = -1;
        try {
            initJDBC();
            String sql = "DELETE FROM students WHERE studentId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, studentId);

            status = ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
