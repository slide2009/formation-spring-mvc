<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Spring MVC</title>
	</head>
	<body>
		<div>
			Comptage : ${comptage}
		</div>
		<div>
		Message : ${message}
		</div>
		<form:form action="applications/enregistrer" modelAttribute="application">
			<label for="id">Id</label>
			<form:input id="id" path="id"/>
			<br/>
			<label for="nom">Nom</label>
			<form:input id="nom" path="nom"/>
			<br/>
			<label for="description">Description </label>
			<form:input id="description" path="description"/>  
			<br/>
			<button type="submit">Enregistrer</button>
		</form:form>
	</body>
</html>