<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp" />
<!-- Example row of columns -->
<div class="row">
	<div class="col-md-12">

		<c:choose>
			<c:when test="${task.id != null}">
				<h1>Edit task</h1>
			</c:when>
			<c:otherwise>
				<h1>Add New Task</h1>
			</c:otherwise>
		</c:choose>

		<form class="form-horizontal" method="post" action="list">

			<!-- hidden input for id -->
			<input type="hidden" name="id" value="${task.id}">

			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">Name</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" name="name"
						placeholder="name" value="${task.name}">
				</div>
			</div>
			<div class="form-group">
				<label for="description" class="col-sm-2 control-label">Description</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="description"
						name="description" placeholder="description"
						value="${task.description}">
				</div>
			</div>
			<div class="form-group">
				<label for="comment" class="col-sm-2 control-label">Comment</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="comment" name="comment"
						placeholder="comment" value="${task.comment}">
				</div>
			</div>
			<div class="form-group">
				<label for="priority" class="col-sm-2 control-label">Priority</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="priority"
						name="priority" placeholder="priority" value="${task.priority}">
				</div>
			</div>
			<c:if test="${task.id != null}">
				<div class="form-group">
					<label for="dateCreated" class="col-sm-2 control-label">Date
						created</label>
					<div class="col-sm-10">
						<c:if test="${task.dateCreated != null}">
							<c:set var="dateCreated">
								<fmt:formatDate value="${task.dateCreated}" pattern="dd-MM-yyyy" />
							</c:set>
						</c:if>
						<input type="text" class="form-control" id="dateCreated"
							name="dateCreated" placeholder="DD-MM-YYYY"
							value="${dateCreated} ">
					</div>
				</div>
			</c:if>
			<div class="form-group">
				<label for="deadline" class="col-sm-2 control-label">Deadline</label>
				<div class="col-sm-10">
					<c:if test="${task.deadline != null}">
						<c:set var="deadline">
							<fmt:formatDate value="${task.deadline}" pattern="dd-MM-yyyy" />
						</c:set>
					</c:if>
					<input type="text" class="form-control" id="deadline"
						name="deadline" placeholder="DD-MM-YYYY" value="${deadline}">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" class="btn btn-default" value="Create" />
				</div>
			</div>
		</form>

	</div>

</div>
<script>
	jQuery.validator.addMethod("customDateValidator", function(value, element) {
	   return value.match(/^(\d{1,2})-(\d{1,2})-(\d{4})$/);
	});

	$("form").validate({
		//define rules for fields
		rules : {
			name : "required",
			description : "required",
			priority : {
				required : true,
				number : true,
				max: 3,
				min: 1
			},
			<c:if test="${task.id != null}">
			dateCreated : {
				customDateValidator : true,
				required : true
			},
			</c:if>
			deadline : {
				customDateValidator : true,
				required : true
			}
		},
		// Specify validation error messages
		messages : {
			name : "Please enter name",
			description : "Please enter description",
			priority : {
				required : "Please enter priority",
				number : "Must be number",
				max: "Max value is 3",
				min: "Min value is 1"
			},
			<c:if test="${task.id != null}">
			dateCreated : {
				customDateValidator : true,
				required : true
			},
			</c:if>
			deadline : {
				customDateValidator : "Format dd-mm-yyyy",
				required : "Please enter date"
			}
		},
		//bootstrap error styles
		highlight: function(element) {
		        $(element).closest('.form-group').addClass('has-error');
		    },
		    unhighlight: function(element) {
		        $(element).closest('.form-group').removeClass('has-error');
		    },
		    errorElement: 'span',
		    errorClass: 'help-block',
		    errorPlacement: function(error, element) {
		        if(element.parent('.input-group').length) {
		            error.insertAfter(element.parent());
		        } else {
		            error.insertAfter(element);
		        }
		    },
		// Make sure the form is submitted to the destination defined
		// in the "action" attribute of the form when valid
		submitHandler : function(form) {
			form.submit();
		}
	});
</script>
<jsp:include page="footer.jsp" />
</html>