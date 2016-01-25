<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Books</title>
</head>
<body>
<h3><font color="red">My Ordered Books</font> </h3>
<table style="width: 100%" border="1">
		<tr>
			<th>Book Id</th>
			<th>Action</th>
			
		</tr>
		<c:forEach items="${bookList}" var="book">
		
			<tr>

				<td>${book.bookId}</td>
				<td><a href="returnBook/${user.userName}/${book.bookId}">Return</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>