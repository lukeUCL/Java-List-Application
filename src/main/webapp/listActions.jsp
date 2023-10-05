<!DOCTYPE html>
<html>
<head>
    <title>List Actions</title>
</head>
<body>
<h1>List Actions</h1>
<form method="post" action="listServlet">
    <label for="action">Action:</label>
    <select id="action" name="action">
        <option value="create">Create</option>
        <option value="delete">Delete</option>
        <option value="rename">Rename</option>
    </select>
    <br/>
    <label for="listId">List ID:</label>
    <input type="text" id="listId" name="listId"/>
    <br/>
    <label for="newName">New Name:</label>
    <input type="text" id="newName" name="newName"/>
    <br/>
    <input type="submit" value="Submit"/>
</form>
<p>
    <a href="viewLists.html">Back to Lists</a>
</p>
</body>
</html>
