<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="uk.ac.ucl.model.Item" %>
<%@ page import="uk.ac.ucl.model.ListModel" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
  <title>Search Results</title>
</head>
<body>
<h1>Search results for '<%= request.getAttribute("query") %>'</h1>
<h2>Matching Lists</h2>
<% List<ListModel> matchingLists = (List<ListModel>) request.getAttribute("matchingLists"); %>
<ul>
  <% for (ListModel list : matchingLists) { %>
  <li><a href="viewListItems.html?listId=<%= list.getId() %>"><%= list.getName() %></a></li>
  <% } %>
</ul>
<h2>Matching Items</h2>
<% List<Item> matchingItems = (List<Item>) request.getAttribute("matchingItems"); %>
<ul>
  <% for (Item item : matchingItems) { %>
  <li><%= item.getContent() %></li>
  <% } %>
</ul>
<p>
  <a href="viewLists.html">Back to Lists</a>
</p>
</body>
</html>
