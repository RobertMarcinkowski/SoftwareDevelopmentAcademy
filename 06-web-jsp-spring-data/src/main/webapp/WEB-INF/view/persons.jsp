<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<table>
    <c:forEach var="person" items="${persons}">
        <tr>
            <td>${person.name}</td>
            <td>${person.surname}</td>
            <td>${person.pesel}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>