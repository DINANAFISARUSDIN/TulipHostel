package Tulip.Assignments.Student;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class registeredStudentAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
		// i. Retrieve values of form-data submitted by user and store into variables
		String studentId = request.getParameter("studentId");
		String fullName = request.getParameter("fullName");
		String gender = request.getParameter("gender");
		String course = request.getParameter("course");
		int semester = Integer.parseInt(request.getParameter("semester"));
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

        // ii. Initialize an object course using data retrieved
		Student s = new Student(studentId, fullName, gender, course, semester, phoneNumber, email, password);


        // iii. Initialize CourseDAO object
		StudentDAO studentDAO = new StudentDAO();

        // iv. Use the method addCourse() by passing object course initialized in ii.
        studentDAO.addStudent(s);

        // v. Retrieve all records using getAllStudents() and forward list to studentView.jsp
        ArrayList<Student> studentList = studentDAO.getAllStudents();
        request.setAttribute("studentList", studentList);
        RequestDispatcher rd = request.getRequestDispatcher("StudentList.jsp");
        rd.forward(request, response);
      

	}

}
