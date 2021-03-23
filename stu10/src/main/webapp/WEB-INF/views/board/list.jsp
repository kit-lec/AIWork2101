<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>음식 목록</title>
<style>
table {
	width: 300px;
	text-align: center;
}
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
a {text-decoration:none;}
th{background-color: tomato;}
#uid {width: 50px;}
#name {width: 250px}
</style>
</head>
<body>
	<hr>
	<h2>음식 리스트</h2>
	<table>
		<tr>
			<th id="uid">UID</th>
			<th id="name">음식 이름</th>
		</tr>

		<c:choose>
		<c:when test="${empty list || fn:length(list) == 0 }">
		</c:when>
		<c:otherwise>
			<c:forEach var="dto" items="${list }">
				<tr>
					<td>${dto.uid }</td>  <%-- dto.getUid() --%>
					<td><a href="view.do?uid=${dto.uid }">${dto.name }</a></td>
				</tr>			
			</c:forEach>
		</c:otherwise>
		</c:choose>
	</table>
	<br>
	<button onclick="location.href='write.do'">메뉴 신규등록</button>
</body>
</html>




























