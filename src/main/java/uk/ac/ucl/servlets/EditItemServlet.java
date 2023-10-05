package uk.ac.ucl.servlets;

import uk.ac.ucl.model.ListManager;
import uk.ac.ucl.model.ListModel;
import uk.ac.ucl.model.Item;
import uk.ac.ucl.model.UrlItem;
import uk.ac.ucl.model.TextItem;
import uk.ac.ucl.model.CombinedItem;
import uk.ac.ucl.model.ImageItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.logging.Level;

@WebServlet(urlPatterns = "/editItem.html", name = "EditItem")
public class EditItemServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String itemId = request.getParameter("itemId");
        String listId = request.getParameter("listId");

        if (itemId == null || listId == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing required parameters");
            return;
        }

        request.getRequestDispatcher("/editItem.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String itemId = request.getParameter("itemId");
        String listId = request.getParameter("listId");
        String newContent = request.getParameter("newContent");

        if (itemId == null || listId == null || newContent == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing required parameters");
            return;
        }

        ListManager listManager = ListManager.getInstance();
        ListModel list = listManager.getList(listId);
        Item item = list.getItem(itemId);

        if (item instanceof TextItem) {
            TextItem textItem = (TextItem) item;
            textItem.setContent(newContent);
        } else if (item instanceof UrlItem) {
            UrlItem urlItem = (UrlItem) item;
            urlItem.setUrl(newContent);
        } else if (item instanceof ImageItem) {
            ImageItem imageItem = (ImageItem) item;
            imageItem.setImagePath("data/" + newContent);
        } else if (item instanceof CombinedItem) {
            CombinedItem combinedItem = (CombinedItem) item;
            String[] parts = newContent.split("\\|", 2); // NOTE THIS CODE DOES NOT WORK- edit only works for non combined item types
            if (parts.length == 2) {
                TextItem newTextItem = new TextItem(combinedItem.getFirstItem().getId(), parts[0]);
                ImageItem newImageItem = new ImageItem(combinedItem.getImageItem().getId(), parts[1]);
                combinedItem.setFirstItem(newTextItem);
                combinedItem.setImageItem(newImageItem);
            }
        }

        response.sendRedirect("viewListItems.html?listId=" + listId);
    }
}
