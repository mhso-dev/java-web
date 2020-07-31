<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 | ${board.title }</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<style>
div, p {
	padding: 0px;
	margin: 0px;
}

.container {
	max-width: 1000px;
	margin: auto;
	color: #313131;
}

.reply-container {
	margin-top: 1rem;
}

.reply-container .reply-wrapper .replyer {
	font-weight: 600;
	margin-bottom: 1rem;
	margin-top: 1rem;
}

.reply-container .reply-wrapper .reply-regdate {
	font-size: 0.7rem;
	font-weight: 400;
}

.reply-input-container {
	min-height: 3rem;
}

.reply-header {
	display: flex;
	justify-content: space-between;
}

#reply-writer {
	border-radius: 5px;
	height: 1.2rem;
	padding: 0.2rem;
}

#reply-writer:focus {
	outline: none;
}

#reply {
	width: 100%;
	border-radius: 5px;
	height: 5rem;
	padding: 0.5rem;
}

#reply:focus {
	outline: none;
}

.reply-input-container>* {
	margin: 1rem;
}
</style>

<script>

	const regReply = () => {
		
		const replyData = {
			bno: $("#hidden-bno-field").val(),
			replyer: $("#reply-writer").val(),
			reply: $("#reply").val()
		};
		
		$.ajax({
			type: "post",
			url: "/reply/new",
			data: JSON.stringify(replyData),	// 자바스크립트의 객체를 JSON 문자열화 시켜주는 함수
			contentType: "application/json; charset=utf-8", 	// contentType : 클라이언트가 서버에게 파라미터를 넘기면서 이건 json 이야~ 라고 알려주는 것
			success: function(item){
				const template = '<div class="reply-wrapper">'+
				'<p class="replyer">'+item['replyer']+'<span class="reply-regdate">'+item['replyDate']+'</span>'+
				'<p class="reply">'+item['reply']+'</p></div>';
			
		
				$(".reply-container").append(template);				
			}
		});
		
	};
	
</script>


</head>
<body>
	<div class="container">
		<div>글 번호 : ${ board.bno }</div>
		<div>글 제목 : ${ board.title }</div>
		<div>글 내용 : ${ board.content }</div>
		<div>작성자 : ${ board.writer }</div>

		<div class="reply-input-container">
			<div class="reply-header">
				<input type="text" id="reply-writer" placeholder="작성자" />
				<button id="btn-reply-reg" onclick="regReply()">댓글 등록</button>
			</div>
			<p>
				<textarea style="resize: none" id="reply"
					placeholder="댓글 내용을 입력해 주세요"></textarea>
			</p>
		</div>

		<div class="reply-container">

			<div class="reply-wrapper">
				<p class="replyer">
					작성자이름 <span class="reply-regdate">2020-07-31</span>
				</p>
				<p class="reply">내용</p>
			</div>

		</div>

		<input type="hidden" value="${ board.bno }" id="hidden-bno-field" />
	</div>
</body>

<script>
	const reqBno = $("#hidden-bno-field").val();
	$.ajax({
		url : "/reply/"+reqBno,
		success : function(response) {
			
			const replyList = response;
			const replyContainer = $(".reply-container");
			
			replyContainer.empty();
			
			replyList.forEach((item) => {
				
				const template = '<div class="reply-wrapper">'+
						'<p class="replyer">'+item['replyer']+'<span class="reply-regdate">'+item['replyDate']+'</span>'+
						'<p class="reply">'+item['reply']+'</p></div>';
					
				
				replyContainer.append(template);
			})
			
		}
	});
</script>

</html>





