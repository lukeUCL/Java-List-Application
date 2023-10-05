<!DOCTYPE html>
<html>
<head>
  <title>Rename List</title>
</head>
<body>
<h1>Rename List</h1>
<%
  String listId = request.getParameter("listId");
  String listName = request.getParameter("listName");
%>
<form action="renameList.html" method="post">
  <input type="hidden" name="listId" value="<%= listId %>" />
  <label for="newListName">New List Name:</label>
  <input type="text" name="newListName" id="newListName" value="<%= listName %>" />
  <input type="submit" value="Rename" />
</form>
<p>
  <a href="viewLists.html">Back to Lists</a>
</p>
</body>
</html>
