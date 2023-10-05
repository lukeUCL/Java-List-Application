<%@ page import="java.util.UUID" %>
<% String listId = request.getParameter("listId"); %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Item</title>
    <script>
        function onItemTypeChange(itemType) {
            var combinedItemTypeFields = document.getElementById("combinedItemTypeFields");
            var listLinkFields = document.getElementById("listLinkFields");
            var secondItemTypeSelect = document.getElementById("secondItemType"); // Get the second item type select element
            if (itemType === "combined") {
                combinedItemTypeFields.style.display = "block";
                // second type can only be image
                secondItemTypeSelect.innerHTML = '<option value="image">Image</option>';
            } else {
                combinedItemTypeFields.style.display = "none";
                // second can be any type
                secondItemTypeSelect.innerHTML = '<option value="text">Text</option>' +
                    '<option value="url">URL</option>' +
                    '<option value="image">Image</option>';
            }
            listLinkFields.style.display = itemType === "listLink" ? "block" : "none";
        }
    </script>
</head>
<body>
<h1>Create Item</h1>
<form method="post" action="createItem.html">
    <input type="hidden" name="listId" value="<%= listId %>" />
    <label for="itemType">Item Type:</label>
    <select id="itemType" name="itemType" onchange="onItemTypeChange(this.value)">
        <option value="text">Text</option>
        <option value="url">URL</option>
        <option value="image">Image</option>
        <option value="combined">Combined</option>
        <option value="listLink">List Link</option>
    </select>
    <br />
    <label for="content">Content:</label>
    <input type="text" id="content" name="content" />
    <br />
    <div id="combinedItemTypeFields" style="display: none;">
        <label for="firstItemType">First Item Type:</label>
        <select id="firstItemType" name="firstItemType">
            <option value="text">Text</option>
            <option value="url">URL</option>
            <option value="image">Image</option>
            <option value="listLink">List Link</option>
        </select>
        <br />
        <label for="secondItemType">Second Item Type:</label>
        <select id="secondItemType" name="secondItemType">
            <option value="image">Image</option>
        </select>
        <br />
        <label for="secondContent">Second Content:</label>
        <input type="text" id="secondContent" name="secondContent" />
        <br />
    </div>
    <div id="listLinkFields" style="display: none;">
        <label for="linkedListId">Linked List ID:</label>
        <input type="text" id="linkedListId" name="linkedListId" />
        <br />
    </div>
    <input type="submit" value="Create Item" />
</form>
<p>
    <a href="viewListItems.html?listId=<%= listId %>">Back to List</a>
</p>
</body>
</html>
