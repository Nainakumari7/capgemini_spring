<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Add Task</title>

<link rel="stylesheet" href="/resources/css/style.css">

</head>

<body>

<div class="container">

<h2>Add New Task</h2>

<form:form method="post"
action="/tasks/save"
modelAttribute="task"
enctype="multipart/form-data">

<label>Title</label>
<form:input path="title"/>
<form:errors path="title" cssClass="error"/>

<br><br>

<label>Description</label>
<form:textarea path="description"/>
<form:errors path="description" cssClass="error"/>

<br><br>

<label>Due Date</label>
<form:input path="dueDate" type="date"/>
<form:errors path="dueDate" cssClass="error"/>

<br><br>

<label>Priority</label>

<form:select path="priority">

<form:option value="">Select</form:option>
<form:option value="LOW">LOW</form:option>
<form:option value="MEDIUM">MEDIUM</form:option>
<form:option value="HIGH">HIGH</form:option>

</form:select>

<form:errors path="priority" cssClass="error"/>

<br><br>

<label>Image</label>

<input type="file" name="imageFile"/>

<br><br>

<button type="submit">Save Task</button>

<a href="/tasks">Cancel</a>

</form:form>

</div>

</body>
</html>