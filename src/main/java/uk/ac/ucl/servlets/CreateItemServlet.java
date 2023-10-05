package uk.ac.ucl.servlets;
import uk.ac.ucl.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "CreateItemServlet", urlPatterns = {"/createItem.html"})
public class CreateItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String listId = request.getParameter("listId");
        String itemType = request.getParameter("itemType");
        String content = request.getParameter("content");
        String secondContent = request.getParameter("secondContent");
        String firstItemType = request.getParameter("firstItemType");

        ListManager listManager = ListManager.getInstance();
        ListModel listModel = listManager.getList(listId);
        if (listModel != null) {
            Item item = null;
            // Create the appropriate Item instance based on the itemType
            String itemId = UUID.randomUUID().toString();
            switch (itemType) {
                case "text":
                    item = new TextItem(itemId, content);
                    break;
                case "url":
                    item = new UrlItem(itemId, content);
                    break;
                case "image":
                    item = new ImageItem(itemId, content);
                    break;
                case "combined":
                    Item firstItem = null;
                    Item secondItem = new ImageItem(UUID.randomUUID().toString(), secondContent);

                    switch (firstItemType) {
                        case "text":
                            firstItem = new TextItem(UUID.randomUUID().toString(), content);
                            break;
                        case "url":
                            firstItem = new UrlItem(UUID.randomUUID().toString(), content);
                            break;
                        case "listLink":
                            String linkedListId = content;
                            firstItem = new ListLinkItem(linkedListId, UUID.randomUUID().toString());
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid first item type");
                    }

                    item = new CombinedItem(itemId, firstItem, (ImageItem) secondItem);
                    break;
                    
                case "listLink":
                    String linkedListId = request.getParameter("linkedListId");
                    item = new ListLinkItem(linkedListId, itemId);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid item type");
            }
            if (item != null) {
                listModel.addItem(item);
            }
        }

        response.sendRedirect("viewLists.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
