<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Book</h1>
	<form action="addbook" method="post">
		Title <input type="text" name="title" /> <br>
		Author <input type="text" name="author" /> <br>
		Category <input type="text" name="category" /> <br>
		Price <input type="text" name="price" /> <br>
		<input type="submit" value="Add Book">
	</form>
</body>
</html>