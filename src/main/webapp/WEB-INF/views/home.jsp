<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<%-- <P>  The time on the server is ${serverTime}. </P>
<p>Please login to Student Application </p>
<form action="getMessage" method="get">

<input type="submit" value="Register" />
</form>
 --%>
<div align="center">
        <form:form action="login" method="post" commandName="UserLoginBean">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Student Application Login Page</h2></td>
                </tr>
                <tr>
                    <td>User Name:</td>
                    <td><form:input path="userName" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:password path="password" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Login" /></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>
