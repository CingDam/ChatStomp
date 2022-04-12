<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h3>채팅 테스트</h3>
	</div>
	<c:if test="${sessionScope.user != null}">
		<span>${sessionScope.user.userId } 님 환영합니다</span>
	</c:if>
	<c:if test="${sessionScope.member == null }">
		<div>
			<a href="/login">로그인</a>
		</div>
	</c:if>
	<div>
		<ul>
			<li><a href="room">채팅방 목록</a></li>
		</ul>
	</div>
	
</body>
</html>