package uk.ac.ucl.servlets;
import uk.ac.ucl.model.ListManager;
import uk.ac.ucl.model.ListModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteItem.html", name = "DeleteItem")
public class DeleteItemServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String listId = request.getParameter("listId");
        String itemId = request.getParameter("itemId");

        ListManager listManager = ListManager.getInstance();
        ListModel list = listManager.getList(listId);

        list.removeItem(itemId);

        response.sendRedirect("viewListItems.html?listId=" + listId);
    }
}

