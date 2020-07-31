<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>#번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성시간</th>
				<th>댓글개수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="board">
				<tr>
					<td>${ board.bno }</td>
					<td><a href="/board/get?bno=${ board.bno }">${board.title }</a></td>
					<td>${board.writer }</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${board.regdate}" /></td>
					<td>${board.replyCnt }</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
</body>
</html>