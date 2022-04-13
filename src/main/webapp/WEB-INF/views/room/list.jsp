<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h3>채팅방 목록</h3>
	</div>
	<div>
		<table border="1">
			<thead>
				<tr>
					<td>채팅방 번호</td>
					<td>채팅방 명</td>
					<td>관리</td>
				</tr>
			</thead>
			<tbody>
				<c:if test="${list.size() < 1}">
					<tr>
						<td colspan="3">채팅방이 없습니다.</td>
					</tr>
				</c:if>
				<c:forEach var="item" items="${list}">
					<td>${item.roomCode }</td>
					<td><a href="view/${item.roomCode}">${item.roomName }</a></td>
					<td><a href="delete/${item.roomCode}">삭제</a></td>
				</c:forEach>
			</tbody>
		</table>
		<div><a href="add">생성</a></div>
	</div>
</body>
</html>