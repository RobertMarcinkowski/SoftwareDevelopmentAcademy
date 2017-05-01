<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp" />
<!-- Example row of columns -->
<div class="row">
	<div class="col-md-12">
	
		<h3>Number of tasks: ${fn:length(tasks)}</h3>
	</div>

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
		<a href="new"><button type="button" class="btn btn-success">New
				Task</button></a>

	</div>
</div>
<jsp:include page="footer.jsp"/>
</html>