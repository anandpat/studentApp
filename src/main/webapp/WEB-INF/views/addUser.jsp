<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add A User</title>
</head>
<body>

<div align="left">
		<h1 align="center">Add a New User !!</h1>
<br>
<form action="addNewUser" method="post">

	<font color="red"> User name :</font> <input type="text" name="userName" value= "${userName}"> <input type="submit" value="Check Availability"><font color=green>${availability}!!</font> <br> 
  	 <font color="red"> Password :</font> <input type="text" name="password"><br>
 	 <font color="red"> Full Name : </font> <input type="text" name="fullName"><br>
 	 
 	 
 	 
	 <!--  <font color="red"> Branch :  </font> <input type="text" name="branch" ><br> -->
	  
	  <font color="red"> Branch :  </font>
	  	<select name="branch">
	  			  <option value=""></option>
				  <option value="CS">CS</option>
				  <option value="EC">EC</option>
				  <option value="EE">EE</option>
				  <option value="IT">IT</option>
				  <option value="ME">ME</option>
				  <option value="COMMON">COMMON</option>
    	</select>
	 <br> 
	  
	 <!--  <font color="red">Role : </font> <input type="text" name="role"><br> -->
	  <font color="red">Role : </font>
	  <select name="role">
	  			  <option value=""></option>
				  <option value="STUDENT">STUDENT</option>
				  <option value="TEACHER">TEACHER</option>
				  <option value="ADMIN">ADMIN</option>
				  <option value="TPO">TPO</option>
				  <option value="OTHER">OTHER</option>
				
    	</select>
	   <br>
	   
	  <!--  <font color="red">Sex : </font> <input type="text" name="sex"><br> -->
	   
	   <font color="red">Sex : </font> 
	   <select name="sex">
	  			  <option value=""></option>
				  <option value="MALE">MALE</option>
				  <option value="FEMALE">FEMALE</option>
				
    	</select>
	   <br>
	  <font color="red">Parent Name : </font> <input type="text" name="parentName" ><br>
	  <font color="red">Primary Address : </font>  <input type="text" name="primaryAdd"><br>
	  <font color="red"> Secondary Address : </font> <input type="text" name="secondaryAdd"><br>
	 <font color="red">Home Phone : </font> <input type="text" name="homePhone"><br>
	 <font color="red"> Mobile Number : </font> <input type="text" name="mobileNum"><br>
	 <input type="submit" value="Add User">

</form>
 </div>

</body>
</html>