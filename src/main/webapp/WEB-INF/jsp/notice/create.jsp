<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create notice</title>
</head>
<body>
	<h1>Create notice</h1>
	<form action='<c:url value="/notice/add"/>' method="POST">
		<input type="text" name="notice.title" placeholder="Title"><br/><br/>
		<textarea cols="30" rows="5" name="notice.content" placeholder=" Write the content "></textarea><br/>
		<input type="submit" value="Save">
	</form>
</body>
</html>