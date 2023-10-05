package uk.ac.ucl.servlets;

import uk.ac.ucl.model.ListManager;
import uk.ac.ucl.model.ListModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/viewListItems.html")
public class ViewListItemsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String listId = request.getParameter("listId");
        System.out.println("List ID: " + listId); // Debugging statement
        ListManager listManager = ListManager.getInstance();

        ListModel listModel = listManager.getList(listId);

        if (listModel != null) {
            System.out.println("List found: " + listModel.getName()); // Debugging statement
            request.setAttribute("listModel", listModel);
            ServletContext context = getServletContext();
            RequestDispatcher dispatch = context.getRequestDispatcher("/viewListItems.jsp");
            dispatch.forward(request, response);
        } else {
            System.out.println("List not found"); // Debugging statement
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "List not found");
        }
    }
}


