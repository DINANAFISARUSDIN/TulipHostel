package Tulip.Assignments.Room;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/RoomView")
public class RoomView extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RoomDAO dao = new RoomDAO();
        ArrayList<Room> list = dao.getAllRooms();
        request.setAttribute("roomList", list);
        RequestDispatcher rd = request.getRequestDispatcher("RoomView.jsp");
        rd.forward(request, response);
    }
}
