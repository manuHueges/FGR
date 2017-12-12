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
		<th>id_weather</th>
		<th>id_city</th>
		<th>date</th>
		<th>max</th>
		<th>min</th>
		<th>temperature</th>
		<th>description</th>
		<th>wind</th>
		<th>atm</th>
		<th>id_day</th>
	</tr></thead>
	<c:forEach var="weather" items="${weather.weather}">
	<tr>
		<td>${weather.id_weather}</td>
		<td>${weather.id_city}</td>
		<td>${weather.date}</td>
		<td>${weather.max}</td>
		<td>${weather.min}</td>
		<td>${weather.temperature}</td>
		<td>${weather.description}</td>
		<td>${weather.wind}</td>
		<td>${weather.atm}</td>
		<td>${weather.id_day}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>
