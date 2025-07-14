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
        String selectedBlock = request.getParameter("block");

        ArrayList<Room> roomList;
        if (selectedBlock == null || selectedBlock.equals("ALL")) {
            roomList = dao.getAllRooms();  // Show all rooms
        } else {
            roomList = dao.getRoomsByBlock(selectedBlock);  // Filtered by block
        }

        ArrayList<String> blockList = dao.getUniqueBlocks();

        request.setAttribute("roomList", roomList);
        request.setAttribute("blockList", blockList);
        request.setAttribute("selectedBlock", selectedBlock);
        request.getRequestDispatcher("RoomView.jsp").forward(request, response);
    }
}
