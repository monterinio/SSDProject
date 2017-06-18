<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.nio.file.Paths" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Invalid format</title>
</head>
<body>
	<%! String fileName; %>
	<% fileName = Paths.get(request.getPart("report").getSubmittedFileName()).getFileName().toString(); %>
	<p> Unfortunately, file <%= fileName %> has inappropriate file extension. <br>
	Our trolls can only deal with .doc, .docx, .odt and .pdf format </p>
	<button type="button" name="back" onclick="history.back()">back</button>
</body>
</html>