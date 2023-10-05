package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Item;
import uk.ac.ucl.model.ListManager;
import uk.ac.ucl.model.ListModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/search.html"})
public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ListManager listManager = ListManager.getInstance();
        String query = request.getParameter("query");

        List<Item> matchingItems = new ArrayList<>();
        List<ListModel> matchingLists = new ArrayList<>();

        for (ListModel list : listManager.getLists()) {
            if (list.getName().contains(query)) {
                matchingLists.add(list);
            }

            for (Item item : list.getItems()) {
                if (item.getContent().contains(query)) {
                    matchingItems.add(item);
                }
            }
        }

        request.setAttribute("query", query);
        request.setAttribute("matchingItems", matchingItems);
        request.setAttribute("matchingLists", matchingLists);
        request.getRequestDispatcher("searchResults.jsp").forward(request, response);
    }
}
