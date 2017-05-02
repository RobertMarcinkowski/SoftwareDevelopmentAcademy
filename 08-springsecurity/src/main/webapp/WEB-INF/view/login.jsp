<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; UTF-8" %>
<html>
<head>
	<jsp:include page="common/stylesAndScripts.jsp"/>
</head>
<div>
<div class="container"/>
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<h1>login page</h1>
			<%--Błąd logowania--%>
			<c:if test="${param.error != null}">
				<div style="color: red">
					Login error
				</div>
			</c:if>
			<%--Wylogowanie--%>
			<c:if test="${param.logout != null}">
				<div style="color: green">
					You have been logged out.
				</div>
			</c:if>
			<%--Formularz logowania--%>
			<%--<form action="/login" method="post">--%>
			<%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">--%>
			<%--username: <input type="text" name="username"><br>--%>
			<%--password: <input type="password" name="password"><br>--%>
			<%--<input type="submit" value="Login">--%>
			<%--</form>--%>

			<form action="/login" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
				<div class="form-group">
					<label for="exampleInputEmail1">User</label>
					<input type="text" name="username" class="form-control" id="exampleInputEmail1" placeholder="username">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Password</label>
					<input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="password">
				</div>
				<input type="submit" class="btn btn-primary" value="Login"/>
			</form>
		</div>
		<div class="col-md-3"></div>
	</div>
</div>
</body>
</html>