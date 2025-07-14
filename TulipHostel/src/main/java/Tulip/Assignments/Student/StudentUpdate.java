package Tulip.Assignments.Student;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/StudentUpdate")
public class StudentUpdate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public StudentUpdate() {
        super();
    }

    // Load update form
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String studentId = request.getParameter("studentId");
        if (studentId != null) {
            StudentDAO dao = new StudentDAO();
            Student s = dao.getStudentById(studentId);
            request.setAttribute("student_data", s);
            RequestDispatcher rd = request.getRequestDispatcher("StudentUpdate.jsp");
            rd.forward(request, response);
        } else {
            response.sendRedirect("StudentView");
        }
    }

    // Handle update form submission
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if ("update".equals(action)) {
            String studentId = request.getParameter("studentId");
            String fullName = request.getParameter("fullName");
            String gender = request.getParameter("gender");
            String course = request.getParameter("course");
            int semester = Integer.parseInt(request.getParameter("semester"));
            String phoneNumber = request.getParameter("phoneNumber");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            Student updatedStudent = new Student(studentId, fullName, gender, course, semester, phoneNumber, email, password);
            StudentDAO dao = new StudentDAO();
            dao.updateStudent(updatedStudent);

            request.setAttribute("studentList", dao.getAllStudents());
            RequestDispatcher rd = request.getRequestDispatcher("StudentView.jsp");
            rd.forward(request, response);
        }
    }
}
