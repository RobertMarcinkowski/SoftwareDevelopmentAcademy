<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp" />
<div class="row">



<form action="list" method="post" class="form-horizontal">

  <div class="form-group">
    <label for="inputId" class="col-sm-2 control-label">Id</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="inputId" placeholder="Id" value="${task.id}">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputName" class="col-sm-2 control-label">Name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="inputName" placeholder="Name" value="${task.name}">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputDescription" class="col-sm-2 control-label">Description</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="inputDescription" placeholder="Description" value="${task.description}">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputComment" class="col-sm-2 control-label">Comment</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="inputComment" placeholder="Comment" value="${task.comment}">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputPriority" class="col-sm-2 control-label">Priority</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="inputPriority" placeholder="Priority" value="${task.priority}">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputDateCreated" class="col-sm-2 control-label">DateCreated</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="inputDateCreated" placeholder="dd-MM-yyyy" value="${task.dateCreated}">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputDeadline" class="col-sm-2 control-label">Deadline</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="inputDeadline" placeholder="dd-MM-yyyy" value="${task.deadline}">
    </div>
  </div>
  
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <a href="list"><button type="submit" class="btn btn-success">Apply</button></a>
      <a href="/CRUD_App/list"><button type="button" class="btn btn-default">Return</button></a>
    </div>
  </div>
</form>






</div>
<jsp:include page="footer.jsp"/>
</html>