package uk.ac.ucl.servlets;

import uk.ac.ucl.model.ListManager;
import uk.ac.ucl.model.ListModel;
import uk.ac.ucl.model.Item;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewItems.html")
public class ItemServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ListManager listManager = ListManager.getInstance();
        String listId = request.getParameter("listId");
        ListModel listModel = listManager.getList(listId);
        List<Item> items = listModel.getItems();
        request.setAttribute("items", items);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/viewItems.jsp");
        dispatch.forward(request, response);
    }
}
