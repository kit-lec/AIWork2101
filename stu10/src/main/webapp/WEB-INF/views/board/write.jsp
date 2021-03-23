<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>음식 메뉴 작성</title>
</head>

<body>
<h2>음식 메뉴 작성</h2>
<form name="frm" action="writeOk.do" method="post">
음식 이름:
<input type="text" name="name" value="${w.name }"/><br>
음식 종류:
<input type="text" name="con" value="${w.con }"/><br>
음식 가격:
<input type="text" name="price" value="${w.price }"/><br><br>
<input type="submit" value="등로꾸!"/>
</form>
<br>
<button type="button" onclick="location.href = 'list.do'">음식 목록ㄱㄱ</button>
</body>
</html>



