<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
					  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<c:set var="path" value="${pageContext.request.contextPath}"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>字典信息</title>
</head>
<body>
	YOU ARE SUCCESS!<br/>
	<a href="${path}/insertUserPage">添加</a> <br/>
	
	<c:forEach items="${users}" var="user">
		<tr id="dict-${user.id}">
			<td>${user.username}</td>
		</tr>
	</c:forEach>
</body>
</html>