<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Spring MVC</title>
	</head>
	<body>
	<div>
		Nombre d'applis : ${nombreApplications}
	</div>
		<table>
			<c:forEach items="${listeApplications}" var="application">
				<tr>
					<td>${application.id}</td>
					<td>${application.nom}</td>
					<td>${application.description}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>