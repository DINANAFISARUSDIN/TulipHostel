package Tulip.Assignments.Student;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Tulip.Assignments.Room.Room;
import Tulip.Assignments.Room.RoomDAO;

@WebServlet("/StudentView")
public class StudentView extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		RoomDAO dao = new RoomDAO();
		ArrayList<Room> list = dao.getAllRooms();
		ArrayList<String> blockList = dao.getUniqueBlocks();  // <--- this line is required

		request.setAttribute("roomList", list);
		request.setAttribute("blockList", blockList);         // <--- this line is required

		RequestDispatcher rd = request.getRequestDispatcher("RoomView.jsp");
		rd.forward(request, response);

	}

    }
    

