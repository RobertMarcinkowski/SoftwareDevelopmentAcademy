<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="date" uri="/WEB_INF/tld/localDate.tld" %>
<%--@elvariable id="person" type="com.example.model.Person"--%>
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
            <td>${date:formatLocalDate(person.dateCreated,'d-M-yyyy')}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>