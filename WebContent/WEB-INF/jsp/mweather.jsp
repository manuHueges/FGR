<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Employees</title>
</head>
<body>
<table border=1>
	<thead><tr>
		<th>ID</th>
		<th>City</th>
		<th>Temperature</th>
		<th>Description</th>
	</tr></thead>
	<c:forEach var="mwweather" items="${mweather.mweather}">
	<tr>
		<td>${mweather.id_weather}</td>
		<td>${mweather.city}</td>
		<td>${mweather.temperature}</td>
		<td>${mweather.description}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>