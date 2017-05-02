<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; UTF-8" %>
<h1>Restricted resource</h1>

Number of roles: ${fn:length(roles)} <br>
You're logged as: ${username} [<c:forEach var="role" items="${roles}" varStatus="loop">
	<c:if test="${loop.index > 0}">, </c:if>${role}
</c:forEach>]
<a href="/logout">logout</a>