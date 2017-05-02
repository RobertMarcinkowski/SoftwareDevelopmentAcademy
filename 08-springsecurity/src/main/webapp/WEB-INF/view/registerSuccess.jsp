<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; UTF-8" %>
<html>
<head>
	<jsp:include page="common/stylesAndScripts.jsp"/>
</head>
<body>
<div class="container"/>
<div class="row">
	<c:choose>
		<c:when test="${empty message}">
			<h3>
				Wyslano wiadomosc e-mail na adres ${eMail}.<br>
				W celu potwierdzenia rejestracji klinknij link walidacyjny z wiadomosci.<br>
					${validationCode}
			</h3>
		</c:when>
		<c:otherwise>
			<h3>
					${message}
			</h3>
		</c:otherwise>
	</c:choose>
</div>
</div>
</body>
</html>