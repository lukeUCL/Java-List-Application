<%@ page import="uk.ac.ucl.model.ListManager" %>
<%@ page import="uk.ac.ucl.model.ListModel" %>
<%@ page import="uk.ac.ucl.model.Item" %>
<%
  ListManager listManager = ListManager.getInstance();
  String listId = request.getParameter("listId");
  String itemId = request.getParameter("itemId");
  ListModel list = listManager.getList(listId);
  Item item = list.getItem(itemId);
%>
<!DOCTYPE html>
<html>
<head>
  <title>Edit Item</title>
</head>
<body>
<h1>Edit Item</h1>
<form action="editItem.html" method="post">
  <input type="hidden" name="listId" value="<%= listId %>" />
  <input type="hidden" name="itemId" value="<%= itemId %>" />
  <label for="newContent">Content:</label>
  <input type="text" id="newContent" name="newContent" value="<%= item.getContent() %>" required />
  <br>
  <input type="submit" value="Save" />
</form>
<p><a href="viewListItems.html?listId=<%= listId %>">Back to List Items</a></p>
</body>
</html>
