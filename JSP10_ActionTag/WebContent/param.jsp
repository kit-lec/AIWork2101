<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>param</title>
</head>
<body>
<p>지금 현재 페이지는 param 페이지 입니다...</p>
<%
	int num = 788;
%>
<jsp:forward page="subParam.jsp">
	<jsp:param value="test123" name="id"/>
	<jsp:param value="<%= num %>" name="pw"/>
</jsp:forward>

</body>
</html>