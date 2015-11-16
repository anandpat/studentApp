<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

	<div align="center">
		<h1>Hello world!</h1>
		<form:form action="validatePassChange" method="post"
			commandName="PasswordChange">
			<table border="0">
				<tr>
					<td colspan="2" align="center"><h2>Student Application
							reset Password Page</h2></td>
				</tr>
				<tr>
					<td>User Name:</td>
					<td><form:input path="userName" /></td>
				</tr>
				<tr>
					<td>question</td>
					<td><form:select path="question">
							<form:option value="" label="...." />
							<form:option value="what is your home town?" label="what is your home town?" />
							<form:option value="what is your parent name?" label="what is your parent name?" />
							<%-- <form:options items="${questionList}" /> --%>
						</form:select></td>
				</tr>
				<tr>
					<td>Answer</td>
					<td><form:input path="answer" /></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="change password" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>