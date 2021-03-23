<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<c:choose>
	<c:when test="${result == 0 }">
		<script>
			alert("메뉴 수정 실패-_-");
			history.back();
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert("미션 컴플리트 :)!");
			location.href = "view.do?uid=${param.uid}"; <%-- view로 이동 --%>
		</script>
	</c:otherwise>
</c:choose>

