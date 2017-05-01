<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
</head>
<body>
<h1>Filter</h1>
<form:form method="get" action="/filter" modelAttribute="filter">
    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="surname">Surname</form:label></td>
            <td><form:input path="surname"/></td>
        </tr>
        <tr>
            <td><form:label path="orderBy">Order by</form:label></td>
            <td>
                <form:select path="orderBy">
                    <form:option value="name" label="by name"/>
                    <form:option value="surname" label="by surname"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form:form>
<h1>Filtered persons</h1>
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