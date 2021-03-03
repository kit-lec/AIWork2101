<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="person1" class="com.lec.beans.Person"/>    
<%-- 다음과 같은 일 수행
	Person person1 = new com.lec.beans.Person();  // 기본생성자 호출
	request.setAttribute("person1", person1);	 //<-- 좀더 정확히는 이코드까지 수행
 --%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>자바빈</title>
</head>
<body>
	<jsp:setProperty property="name" name="person1" value="고길동"/>
	<jsp:setProperty property="age" name="person1" value="24"/>
	<jsp:setProperty property="id" name="person1" value="1515"/>
	<jsp:setProperty property="gender" name="person1" value="남"/>
	<%-- 다음과 같은 일을 수행한다.
		person1.setName("고길동");
		person1.setAge(24);
		person1.setId(1515);
		person1.setGender("남");
	 --%>

	<h3>person1</h3>
	이름: <jsp:getProperty property="name" name="person1"/><br>
	나이: <jsp:getProperty property="age" name="person1"/><br>
	아이디: <jsp:getProperty property="id" name="person1"/><br>
	성별: <jsp:getProperty property="gender" name="person1"/><br>
	<%-- 다음과 같은 일을 수행한다
		<%= person1.getName() %>
		<%= person1.getAge() %>
		<%= person1.getId() %>
		<%= person1.getGender() %>
	 --%>
	
	<%
		//int person1;
	%>
	<%= person1 %><br>


</body>
</html>

















