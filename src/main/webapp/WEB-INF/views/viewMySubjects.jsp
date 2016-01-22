<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Subjects</title>
</head>
<body>
<h3><font color="red">Subject List</font> </h3>

<table style="width: 100%" border="1">
		<tr>
			<th>Subject Code</th>
			<th>Subject Name</th>
			<th>Branch</th>
		</tr>
		<c:forEach items="${subjectList}" var="subject">
			<tr>

				<td>${subject.subjectCode}</td>
				<td>${subject.subjectName}</td>
				<td>${subject.branch}</td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>