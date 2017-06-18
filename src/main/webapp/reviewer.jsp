<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Panel administracyjny</title>
</head>
<body>
	<h1>Witaj w panelu reviewera</h1>
	<table>
		<tr>
			<th>Last Name</th>
			<th>First Name</th>
			<th>Subject</th>
			<th>Topic</th>
		</tr>
		<c:forEach items="${sessionScope.reportModelList}" var="reportModel" varStatus="status">
			<tr>
				<td>${reportModel.lastName}</td>
				<td>${reportModel.firstName}</td>
				<td>${reportModel.subject}</td>
				<td>${reportModel.topic}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="http://localhost:8080/SSD/LogoutService">Wyloguj</a>
</body>
</html>