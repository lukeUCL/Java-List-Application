<%@ page import="uk.ac.ucl.model.ListManager" %>
<%@ page import="uk.ac.ucl.model.ListModel" %>
<%@ page import="uk.ac.ucl.model.Item" %>
<%@ page import="uk.ac.ucl.model.UrlItem" %>
<%@ page import="uk.ac.ucl.model.ImageItem" %>
<%@ page import="uk.ac.ucl.model.TextItem" %>
<%@ page import="uk.ac.ucl.model.CombinedItem" %>
<%@ page import="uk.ac.ucl.model.ListLinkItem" %>

<%
  ListManager listManager = ListManager.getInstance();
  String listId = request.getParameter("listId");
  ListModel listModel = listManager.getList(listId);
  java.util.List<Item> items = listModel.getItems();
%>
<!DOCTYPE html>
<html>
<head>
  <title>View List Items</title>
</head>
<body>
<h1>Items in <%= listModel.getName() %></h1>
<table>
  <% for (Item item : items) { %>
  <tr>
    <td>
      <% if (item instanceof TextItem) { %>
      <%= ((TextItem) item).getContent() %>
      <% } else if (item instanceof UrlItem) { %>
      <%= ((UrlItem) item).getContent() %>
      <% } else if (item instanceof ImageItem) { %>
      <%= ((ImageItem) item).getContent() %>
      <% } else if (item instanceof CombinedItem) { %>
      <% out.print(((CombinedItem) item).getContent()); %>
      <% } else if (item instanceof ListLinkItem) { %>
      <a href="viewListItems.html?listId=<%= ((ListLinkItem) item).getLinkedListId() %>">Linked List</a>
      <% } %>
    </td>
    <td>
      <a href="editItem.jsp?listId=<%= listModel.getId() %>&itemId=<%= item.getId() %>">Edit</a> |
      <a href="deleteItem.html?listId=<%= listModel.getId() %>&itemId=<%= item.getId() %>">Delete</a>
    </td>
  </tr>
  <% } %>
</table>
<p><a href="viewLists.html">Back to Lists</a></p>


</body>
</html>