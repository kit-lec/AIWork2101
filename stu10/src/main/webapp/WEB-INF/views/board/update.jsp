<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<c:choose>
	<c:when test="${empty list || fn:length(list) == 0 }">
		<script>
			alert("입력이 적절하지 않습니다");
			history.back();
		</script>
	</c:when>	
	<c:otherwise>

    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>${list[0].name }의 정보 수정</title>
</head>

<body>
<h2>메뉴 수정</h2>
<form name="frm" action="updateOk.do" method="post">
<input type="hidden" name="uid" value="${list[0].uid }"/>
음식 이름 : <input type="text" name="name" value="${list[0].name }"/><br>
음식 종류 : <input type="text" name="con" value="${list[0].con }"/><br>
음식 가격 : <input type="text" name="price" value="${list[0].price }"/><br><br>
<input type="submit" value="메뉴 수정"/>
</form>
<button onclick="history.back();">이전으로</button>
<button onclick="location.href='list.do'">음식 목록</button>
<br>
</body>
</html>
	</c:otherwise>
</c:choose>

