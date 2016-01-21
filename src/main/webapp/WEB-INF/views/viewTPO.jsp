<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TPO List</title>
</head>
<body>
<h3><font color="red"> TPO List </font> </h3>
<table style="width: 100%" border="1">
		<tr>
			<th><font color="green">UserName</font></th>
			<th><font color="green">Full Name</font></th>
			<th><font color="green">Branch</font></th>
			<th><font color="green">Role</font></th>
			<th><font color="green">Sex</font></th>
			<th><font color="green">Parent Name</font></th>
			<th><font color="green">Primary Address</font></th>
			<th><font color="green">Secondary Address</font></th>
			<th><font color="green">Home Phone</font></th>
			<th><font color="green">Mobile Number</font></th>
		</tr>
		<c:forEach items="${tpoList}" var="tpo">
			<tr>

				<td>${tpo.userName}</td>
				<td>${tpo.fullName}</td>
				<td>${tpo.branch}</td>
				<td>${tpo.role}</td>
				<td>${tpo.sex}</td>
				<td>${tpo.contactInfo.parentName}</td>
				<td>${tpo.contactInfo.primaryAdd}</td>
				<td>${tpo.contactInfo.secondaryAdd}</td>
				<td>${tpo.contactInfo.homePhone}</td>
				<td>${tpo.contactInfo.mobileNum}</td>


			</tr>
		</c:forEach>
	</table>

</body>
</html>