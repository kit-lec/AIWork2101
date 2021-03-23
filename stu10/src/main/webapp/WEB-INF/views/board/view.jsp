<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:choose>
	<c:when test="${empty list || fn:length(list) == 0 }">
		<script>
			alert("해당 메뉴가 삭제되었거나 없습니다");
			history.back();
		</script>
	</c:when>	
	<c:otherwise>
	
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>메뉴 상세 정보</title>
<style>
table {
	width: 300px;
	text-align: left;
}
table, td {
	border: 1px solid black;
	border-collapse: collapse;
}
td {padding: 5px 10px}
#left {width: 100px; background-color: AntiqueWhite;}
#right {width: 200px}
</style>
</head>
<script>
function chkDelete(uid){
	// 삭제 여부, 다시 확인 하고 진행
	var r = confirm("이 메뉴를 삭제하시겠습니까?");
	
	if(r){
		location.href = 'deleteOk.do?uid=' + uid;
	}
} // chkDelete
</script>
<body>	
	<h2>메뉴 상세 정보</h2>
	<table>
		<tr><td id="left">음식 이름</td>
			<td id="right">${list[0].name }</td></tr>
		<tr><td id="left">음식 종류</td>
			<td id="right">${list[0].con }</td></tr>
		<tr><td id="left">음식 가격</td>
			<td id="right">${list[0].price } 원</td></tr>
	</table>
	<br>
		<button onclick="location.href='update.do?uid=${list[0].uid }'">메뉴 수정</button>
		<button onclick="location.href='list.do'">음식 목록</button>
		<button onclick="chkDelete(${list[0].uid })">메뉴 삭제</button>
		<button onclick="location.href='write.do'">메뉴 신규등록</button>
</body>
</html>				
	</c:otherwise>
</c:choose>

