<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library Home</title>
</head>
<body>
<h3><font color="red">Book List</font> </h3>
<a href="mybooks">My Ordered Books</a>
	<table style="width: 100%" border="1">
		<tr>
			<th>Book Id</th>
			<th>Book Name</th>
			<th>Availability</th>
			<th>Detail</th>
		</tr>
		<c:forEach items="${bookList}" var="book">
		<c:set var="isAvailable" scope="session" value="${book.isAvailable}"/>
			<tr>

				<td>${book.bookId}</td>
				<td>${book.bookName}</td>
				<td><c:choose>
				<c:when test="${book.isAvailable eq 'N'.charAt(0)}"><font color="red">Not Available</font> 
					<td>Already booked</td>
				</c:when>
				<c:otherwise><font color="green">Available </font>
					<td><a href="registerForBook/${user.userName}/${book.bookId}">Book Now</a></td>
				</c:otherwise>
				</c:choose>
				
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>