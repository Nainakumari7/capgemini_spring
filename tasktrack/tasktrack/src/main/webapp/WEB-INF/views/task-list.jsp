<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TaskTrack</title>

<link rel="stylesheet" href="/resources/css/style.css">

</head>

<body>

<nav class="navbar">

<div>
<h1>TaskTrack</h1>
<p>Team Task Manager</p>
</div>

<a href="/tasks/new" class="btn btn-primary">+ Add Task</a>

</nav>

<div class="container">

<table>

<thead>
<tr>
<th>Image</th>
<th>Title</th>
<th>Description</th>
<th>Due Date</th>
<th>Priority</th>
<th>Status</th>
<th>Actions</th>
</tr>
</thead>

<tbody>

<c:forEach var="task" items="${taskList}">

<tr>

<td>
<img class="task-img" src="/tasks/image/${task.id}">
</td>

<td>${task.title}</td>

<td>${task.description}</td>

<td>${task.dueDate}</td>

<td>${task.priority}</td>

<td>${task.status}</td>

<td>

<a href="/tasks/toggle/${task.id}" class="btn btn-complete">✔</a>

<a href="/tasks/delete/${task.id}" class="btn btn-delete">🗑</a>

</td>

</tr>

</c:forEach>

</tbody>

</table>

</div>

</body>
</html>