<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; UTF-8" %>
<html>
<head>
	<jsp:include page="common/stylesAndScripts.jsp"/>
</head>
<body>
	<div class="container"/>
		<div class="row">
			<h1>Registration form</h1>
			<form:form method="POST" action="/register" modelAttribute="user" class="form-horizontal">
				<div class="form-group">
					<form:label path="username" class="col-sm-2 control-label">username</form:label>
					<div class="col-sm-5">
						<form:input path="username" type="text" class="form-control" placeholder="username"/>
					</div>
					<div class="col-sm-5">
						<form:errors path="username"/>
					</div>
				</div>
				<div class="form-group">
					<form:label path="password" class="col-sm-2 control-label">Password</form:label>
					<div class="col-sm-5">
						<form:input path="password" type="password" class="form-control" placeholder="Password"/>
					</div>
				</div>
				<div class="form-group">
					<form:label path="eMail" class="col-sm-2 control-label">e-mail</form:label>
					<div class="col-sm-5">
						<form:input path="eMail" type="text" class="form-control" placeholder="e-mail"/>
					</div>
					<div class="col-sm-5">
						<form:errors path="eMail" class="alert alert-danger" role="alert"/>
					</div>
				</div>
				<div class="form-group">
					<form:label path="firstName" class="col-sm-2 control-label">first name</form:label>
					<div class="col-sm-5">
						<form:input path="firstName" type="text" class="form-control" placeholder="first name"/>
					</div>
				</div>
				<div class="form-group">
					<form:label path="familyName" class="col-sm-2 control-label">family name</form:label>
					<div class="col-sm-5">
						<form:input path="familyName" type="text" class="form-control" placeholder="family name"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-5">
						<input type="submit" class="btn btn-default" value="Submit"/>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>