<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
<h3>Person ${id}</h3>
<c:choose>
    <c:when test="${person != null}">
        Imie: ${person.name}
        Nazwisko: ${person.surname}
        Pesel: ${person.pesel}
    </c:when>
    <c:otherwise>
        Nie ma takiej osoby
    </c:otherwise>
</c:choose>
</body>
</html>