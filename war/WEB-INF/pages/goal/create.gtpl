<% include '/WEB-INF/includes/header.gtpl' %>

<h1>Create a new goal</h1>

<form action="save" method="post">
    <label for="summary">Summary</label><input type="text" name="summary" id="summary"/>
    <label for="dueDate">Due date</label><input type="text" name="dueDate" id="dueDate"/>
    <input type="submit" value="create"/>
</form>
<% include '/WEB-INF/includes/footer.gtpl' %>

