<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p>Please login to Student Application </p>
<form action="getMessage" method="get">
<input type="submit" value="Register" />
</form>

</body>
</html>
