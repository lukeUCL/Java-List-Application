package uk.ac.ucl.servlets;

import uk.ac.ucl.model.ListManager;
import uk.ac.ucl.model.ListModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/renameList.html", name = "RenameList")
public class RenameListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the listId and new name from the request parameters
        String listId = request.getParameter("listId");
        String newListName = request.getParameter("newListName");

        // Get the ListManager instance
        ListManager listManager = ListManager.getInstance();

        // Get the ListModel by unique ID
        ListModel list = listManager.getList(listId);

        // rename the list
        list.setName(newListName);

        // Redirect to the viewLists page
        response.sendRedirect("viewLists.html");
    }
}
