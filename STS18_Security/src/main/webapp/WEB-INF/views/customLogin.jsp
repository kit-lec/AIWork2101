<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
<h1>Custom Login Page</h1>
<h2>error: <c:out value="${error }"/></h2>
<h2>logout: <c:out value="${logout }"/></h2>

<form method="post" action="${pageContext.request.contextPath }/login">
	<input type="text" name="username" value="admin"><br>
	<input type="password" name="password" value="admin"><br>
	<input type="checkbox" name="remember-me">Remember Me<br>
	<input type="submit">로그인<br>
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
</form>

</body>
</html>












