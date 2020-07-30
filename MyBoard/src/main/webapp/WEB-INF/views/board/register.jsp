<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
	
	<form action="/board/register" method="post">
		<div>
			<label>Title</label>
			<input name="title">
		</div>
		<div>
			<label>Text area</label>
			<textarea rows="3"  name="content"></textarea>
		</div>
		<div>
			<label>Writer</label>
			<input name="writer" />
		</div>
		
		<button type="submit">게시글 등록</button>
		
	</form>
	
</body>
</html>