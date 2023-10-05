package uk.ac.ucl.servlets;

import uk.ac.ucl.model.ListModel;
import uk.ac.ucl.model.ListManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/viewLists.html")
public class ViewListsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ListManager listManager = ListManager.getInstance();
        List<ListModel> lists = listManager.getLists();
        request.setAttribute("lists", lists);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/viewLists.jsp");
        dispatch.forward(request, response);
    }
}
