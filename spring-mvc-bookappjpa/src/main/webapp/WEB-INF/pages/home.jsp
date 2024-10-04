<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="right">
		<a href="signin">Signin</a>
	</div>
	<form action="search">
		Enter author <input type="text" name="author" /> <br>
		<input type="submit" value="Search By Author">
	</form>
	<hr>
	${books }
</body>
</html>