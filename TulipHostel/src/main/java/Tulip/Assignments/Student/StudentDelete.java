package Tulip.Assignments.Student;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentDelete")
public class StudentDelete extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String studentId = request.getParameter("id");
        String confirm = request.getParameter("confirm");

        StudentDAO studentDAO = new StudentDAO();

        if (confirm == null) {
            // Step 1: Show confirmation page
            Student student = studentDAO.getStudentById(studentId);
            request.setAttribute("student_data", student);
            RequestDispatcher dispatcher = request.getRequestDispatcher("StudentDelete.jsp");
            dispatcher.forward(request, response);
        } else if ("yes".equals(confirm)) {
            // Step 2: Perform delete
            int rowsDeleted = studentDAO.deleteStudentById(studentId);

            if (rowsDeleted == 1) {
                request.setAttribute("success", "The student record was successfully deleted.");
            } else {
                request.setAttribute("danger", "Delete failed. Student not found.");
            }

            ArrayList<Student> studentList = studentDAO.getAllStudents();
            request.setAttribute("studentList", studentList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("StudentView.jsp");
            dispatcher.forward(request, response);
        }
    }
}
