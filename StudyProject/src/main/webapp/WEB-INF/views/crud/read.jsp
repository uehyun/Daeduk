<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<body>
	<h2>Read</h2>
	<table border="1">
		<tr>
			<td>제목</td>
			<td>${board.title }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${board.writer }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${board.content }</td>
		</tr>
		<tr>
			<td>작성일</td>
			<td>${board.regDate }</td>
		</tr>
	</table>
	<form method="post" action="/crud/board/remove" id="delForm">
		<input type="hidden" name="boardNo" value="${board.boardNo }"/>
	</form>
	<button type="button" id="btnModify">수정</button>
	<button type="button" id="btnDelete">삭제</button>
	<button type="button" id="btnList">목록</button>
</body>
<script type="text/javascript">
$(function(){
	var delForm = $("#delForm");
	var btnModify = $("#btnModify");
	var btnDelete = $("#btnDelete");
	var btnList = $("#btnList");
	
	btnModify.on("click", function(){
		delForm.attr("action", "/crud/board/modify");
		delForm.attr("method", "get");
		delForm.submit();
	});
	
	btnDelete.on("click", function(){
		if(confirm("정말로 삭제하시겠습니까?")) {
			delForm.submit();
		}
	});
	
	btnList.on("click", function(){
		location.href="/crud/board/list";
	});
});
</script>
</html>