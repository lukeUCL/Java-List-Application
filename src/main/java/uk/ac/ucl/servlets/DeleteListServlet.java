package uk.ac.ucl.servlets;

import uk.ac.ucl.model.ListManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteListServlet", urlPatterns = {"/deleteList.html"})
public class DeleteListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String listId = request.getParameter("listId");
        ListManager listManager = ListManager.getInstance();
        listManager.deleteList(listId);

        response.sendRedirect("viewLists.html");
    }
}
