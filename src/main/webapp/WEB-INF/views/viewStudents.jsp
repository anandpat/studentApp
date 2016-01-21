<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student List</title>
</head>
<body>

	<table style="width: 100%" border="1">
		<tr>
			<th>UserName</th>
			<th>Full Name</th>
			<th>Branch</th>
			<th>Role</th>
			<th>Sex</th>
			<th>Parent Name</th>
			<th>Primary Address</th>
			<th>Secondary Address</th>
			<th>Home Phone</th>
			<th>Mobile Number</th>
		</tr>
		<c:forEach items="${studentList}" var="student">
			<tr>

				<td>${student.userName}</td>
				<td>${student.fullName}</td>
				<td>${student.branch}</td>
				<td>${student.role}</td>
				<td>${student.sex}</td>
				<td>${student.contactInfo.parentName}</td>
				<td>${student.contactInfo.primaryAdd}</td>
				<td>${student.contactInfo.secondaryAdd}</td>
				<td>${student.contactInfo.homePhone}</td>
				<td>${student.contactInfo.mobileNum}</td>


			</tr>
		</c:forEach>
	</table>


</body>
</html>