<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- JSTL 문법 ( 반복문(forEach), 조건문(if~else if~else) )  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- 날짜 시간 포매팅 등을 할 수 있게 해 준다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 리스트</title>
</head>
<body>
	<a href="/board/register">게시글 쓰기</a>
	<table>
		<thead>
			<tr>
				<th>#번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>수정일</th>
			</tr>
		</thead>
		<tbody>
			<!-- JSTL : JSP의 스크립틀릿을 사용하기 좋게 만들어 놓은 라이브러리 -->
			<!-- JSTL을 쓰게 되면 HTML 태그를 사용하는 것 처럼 스크립틀릿을 활용할 수 있다. -->
			<!-- list 안에 있는 게시판 정보를 꺼내서 화면에 출력 -->
			<c:forEach items="${ list }" var="board">
				<!-- list 배열에 들어있는 BoardVO를 하나씩 꺼내서 board 변수에 담는다. -->
				<tr>
					<td><c:out value="${ board.bno }" /></td>
					<td><a href="/board/get?bno=${ board.bno }"> <c:out value="${ board.title }" /></a></td>
					<td><c:out value="${ board.writer }" /></td>
					<td><fmt:formatDate value="${ board.regdate }" pattern="yyyy-MM-dd" /></td>
					<td><fmt:formatDate value="${ board.updateDate }" pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	
</body>
</html>







