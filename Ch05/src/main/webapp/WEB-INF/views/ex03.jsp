<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attribute 테스트 1</title>

<style>
	.container {
		padding: 2rem;
	}
	
	.container h1 {
		color: pink;
	}
</style>

</head>
<body>
	<div class="container">
		<!-- model에 추가한 attribute는 request객체 에서 getAttribute("키값")을 통해 꺼낼 수 있다. -->
		<h1>이름 : <%= request.getAttribute("name") %></h1> <!-- 잘 쓰는 표현은 아님!! -->
		<h1>이름 : ${name} </h1>
		
		<!-- 위에 있는 스크립틀릿을 간편화 하는 EL ( Expression Language ) -->
		<!-- age 키값을 자동으로 검색해서 해당 attribute의 값을 추출한다. -->
		<h1>나이 : ${ age } </h1>
	</div>
</body>
</html>









