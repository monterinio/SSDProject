<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Size Exceeded</title>
</head>
<body>
	<%! double fileSize; %>
	<% fileSize = request.getPart("report").getSize()/(1024*1024); %>
	<h1>Hold on!</h1><br>
	<p>The file you are trying to upload has a size of <%= fileSize %> mb<br>
		Our servers can store only files whose size does not exceed 50 mb </p>
	
	<button type="button" name="back" onclick="history.back()">back</button>
</body>
</html>