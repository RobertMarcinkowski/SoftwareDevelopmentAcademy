<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="task" type="model.Task" required="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<tr>
	<th scope="row">${task.id}</th>
	<td>${task.name}</td>
	<td><fmt:formatDate value="${task.dateCreated}"
			pattern="d-MM-yyyy" /></td>
	<td><a href="view?id=${task.id}"><button type="button" class="btn btn-default">View</button></a>
		<a href="edit?id=${task.id}"><button type="button" class="btn btn-primary">Edit</button></a>
		<a href="delete?id=${task.id}"><button type="button" class="btn btn-danger">Delete</button></a>
	</td>
</tr>
