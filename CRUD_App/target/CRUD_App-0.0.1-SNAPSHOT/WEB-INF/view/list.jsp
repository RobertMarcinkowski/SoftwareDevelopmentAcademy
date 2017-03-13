<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<jsp:include page="header.jsp" />
<div class="row">
	<div class="col-md-12">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>id</th>
					<th>Task Name</th>
					<th>Date Created</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="task" items="${tasks}">
					<tag:taskRow task="${task}" />
				</c:forEach>
			</tbody>
		</table>
	</div>
	<hr>
	<div class="col-md-12">
		<a href="/CRUD_App/newtask"><button type="button" class="btn btn-success">New Task</button></a>
	</div>
</div>
<jsp:include page="footer.jsp"/>