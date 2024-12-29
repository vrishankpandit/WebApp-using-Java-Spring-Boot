	<%@ include file="common/Header.jspf" %>>
	<%@ include file="common/Navigation.jspf" %>>
	<div class="container">
		<h1>  Welcome : ${NAME}</h1>
		<h2>Your Todos are : </h2>
		<table class="table">
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is Done?</th>
					<th>DELETE</th>
					<th>UPDATE</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.description}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.done}</td>
					<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE</a></td>
					<td><a href="update-todo?id=${todo.id}" class="btn btn-success">UPDATE</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	<a href="add-todo" class="btn btn-success">Add Todo</a>
	<%@ include file="common/Footer.jspf" %>>
	