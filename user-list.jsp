<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>USER Add</h1>

<form action="user-create" method="post">
	<div>
		<input type="text" name="username" placeholder="Enter Username...">
	</div>
	
	<div>
		<input type="password" name="password" placeholder="Enter Password...">
	</div>
	
	<div>
		<input type="text" name="email" placeholder="Enter Email...">
	</div>
	
	<div>
		<input type="text" name="mobile" placeholder="Enter Mobile">
	</div>
	
	<div>
		<input type="Submit" value="Add User">
	</div>
</form>


<h1>USER LIST</h1>
<c:forEach var="item" items="${userList}">
	<div>
		${item.username} ${item.email} ${item.mobile} <a href="user-delete?id=${item.id}">DEL</a> 
	</div>
</c:forEach>

</body>
</html>