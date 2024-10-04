<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${book}
	<h1>Update Book</h1>
	<form action="updatebook" method="post">
		Title <input type="text" name="title" value="${book.title }"/> <br>
		Author <input type="text" name="author"  value="${book.author }" /> <br>
		Category <input type="text" name="category"  value="${book.category }"/> <br>
		Price <input type="text" name="price"  value="${book.price }"/> <br>
				Price <input type="text" name="bookId" readonly  value="${book.bookId }"/> <br>
		<input type="submit" value="Update Book">
	</form>
</body>
</html>