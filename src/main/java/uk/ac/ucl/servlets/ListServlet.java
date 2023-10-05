package uk.ac.ucl.servlets;

import uk.ac.ucl.model.ListManager;
import uk.ac.ucl.model.ListModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListServlet", urlPatterns = {"/listServlet"})
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String listId = request.getParameter("listId");
        String newName = request.getParameter("newName");

        ListManager listManager = ListManager.getInstance();

        switch (action) {
            case "create":
                listManager.createList(newName);
                break;
            case "delete":
                listManager.deleteList(listId);
                break;
            case "rename":
                ListModel listModel = listManager.getList(listId);
                if (listModel != null) {
                    listModel.setName(newName);
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid action");
        }

        response.sendRedirect("viewLists.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
