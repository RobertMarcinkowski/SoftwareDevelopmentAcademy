<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp" />
<div class="row">

<ul>
  <li>${task.id}</li>
  <li>${task.name}</li>
  <li>${task.description}</li>
  <li>${task.comment}</li>
  <li>${task.priority}</li>
  <li>${task.dateCreated}</li>
  <li>${task.deadline}</li>
</ul>

<div class="col-md-12">
		<a href="/CRUD_App/list"><button type="button" class="btn btn-success">Return</button></a>

	</div>
</div>
<jsp:include page="footer.jsp"/>
</html>