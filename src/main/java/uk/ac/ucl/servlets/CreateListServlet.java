package uk.ac.ucl.servlets;
import uk.ac.ucl.model.ListManager;
import uk.ac.ucl.model.ListModel;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/createList.html")
public class CreateListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String listName = request.getParameter("listName");
        String listId = UUID.randomUUID().toString(); // Generate a unique ID using UUID
        ListManager listManager = ListManager.getInstance();
        listManager.addList(new ListModel(listId, listName)); // Pass the generated ID and list name to the constructor

        response.sendRedirect("viewLists.html");
    }
}
