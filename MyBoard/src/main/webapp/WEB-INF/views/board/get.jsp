<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 | ${ board.title }</title>
</head>
<body>
	<a href="/board/list">게시판 리스트로 가기</a>
	<div>
		글 번호 : ${ board.bno }
	</div>
	<div>
		제목 : ${ board.title }
	</div>
	<div>
		내용 : ${board.content }
	</div>
	<div>
		작성자 : ${ board.writer }
	</div>
</body>
</html>