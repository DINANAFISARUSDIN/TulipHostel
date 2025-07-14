package Tulip.Assignments.Student;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/StudentView")
public class StudentView extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StudentDAO dao = new StudentDAO();
        ArrayList<Student> list = dao.getAllStudents();
        request.setAttribute("studentList", list);
        RequestDispatcher rd = request.getRequestDispatcher("StudentView.jsp");
        rd.forward(request, response);
    }
}
