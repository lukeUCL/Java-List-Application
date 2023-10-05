<%@ page import="uk.ac.ucl.model.ListModel" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Lists</title>
</head>
<body>
<form action="search.html" method="get">
    <label for="query">Search: </label>
    <input type="text" id="query" name="query" required>
    <button type="submit">Search</button>
</form>
<h1>My Lists</h1>
<% List<ListModel> lists = (List<ListModel>) request.getAttribute("lists");
    String query = (String) request.getParameter("query");
    boolean noResults = true; %>
<% for (ListModel list : lists) { %>
<% if (query == null || query.isEmpty() || list.getName().toLowerCase().contains(query.toLowerCase())) {
    noResults = false; %>
<table>
    <tr>
        <th>List Name</th>
        <th>Create Item</th>
        <th>Action</th>
        <th>List ID</th>
    </tr>
    <tr>
        <td><a href="viewListItems.html?listId=<%= list.getId() %>"><%= list.getName() %></a></td>
        <td><a href="createItem.jsp?listId=<%= list.getId() %>">Create Item</a></td>
        <td>
            <a href="deleteList.html?listId=<%= list.getId() %>">Delete</a> |
            <a href="renameList.jsp?listId=<%= list.getId() %>&listName=<%= list.getName() %>">Rename</a>
        </td>
        <td><%= list.getId() %></td>
    </tr>
</table>
<% } %>
<% } %>
<% if (noResults) { %>
<p>No lists found that match your search query.</p>
<% } %>
<p>
    <a href="index.jsp">Back to Main Page</a>
</p>
</body>
</html>
