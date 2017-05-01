<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--Istotna linia na dole, umożliwia korzystanie z jstl-->
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="tabele.css">
<title>Insert title here</title>
</head>
<body>
	<div style="overflow-x:auto;">
		<table>
			<tr>
				<th>Imię</th>
				<th>Nazwisko</th>
				<th>Wiek</th>
				<th>Pełnoletni/niepełnoletni</th>
			</tr>
			
			<!-- Iterujemy po liście persons i wyswietlamy w tabeli żeby było ładnie ;)-->
			<c:forEach var="person" items="${persons}">
			<!-- Poniżej taki if else w którym sprawdzamy wiek osoby, jezeli mniej niż 18 to 
			kolorujemy na czerwono, w przeciwnym wypadku nie robimy nic :P -->
				 <c:choose> 
					<c:when test="${person.age<18}">
						<tr>			
							<td style="color:red">${person.name}</td>
							<td style="color:red">${person.surname}</td>
							<td style="color:red">${person.age}</td>
							<td style="color:red">Niepełnoletni</td>
						</tr>			
					</c:when>
					<c:otherwise>
						<tr>			
							<td>${person.name}</td>
							<td>${person.surname}</td>
							<td>${person.age}</td>
							<td>Pełnoletni</td>
						</tr>	
					</c:otherwise>
				</c:choose>
							
			</c:forEach>
			
				<%--Alternatywa dla pętli powyżej ;)
				 <c:forEach var="person" items="{persons}">
				<tr>
							<td>${person.name}</td>
							<td>${person.surname}</td>
							<td<c:if test="${person.age<18}"> style="color:red"</c:if>>${person.age}</td>
				</tr> --> 
				</c:forEach>
				--%>
					
			
		</table>
	</div>
</body>
</html>