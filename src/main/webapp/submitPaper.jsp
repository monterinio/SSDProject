<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Submit paper</title>
</head>
<body>
	<h1>Submit paper</h1>
	<form action="SubmitPaperService" method="post" enctype="multipart/form-data">
        First Name: <input type="text" name="firstName">
        <br>
        Last Name: <input type="text" name="lastName">
        <br>
        Subject: <input type="text" name="subject">
        <br>
        Topic: <input type="text" name="topic">
        <br>
        File: <input type="file" name="report">
        <br>
        <input type="submit" value="Send">
    </form>
</body>
</html>