<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css" />
<title>자유게시판 상세보기</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h3 class="display-3">자유게시판 상세보기 / 수정 / 삭제</h3>
		</div>
	</div>

	<div class="container">
			<div class="form-group row">
				<label class="col-sm-2 control-label" >제목</label>
				<div class="col-sm-5">
					<div class="card-header">
						<h3 class="card-title">${free.boTitle }</h3>
						<div class="card-tools">${free.boWriter } ${free.boDate } ${free.boHit }</div>
					</div>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label" >내용</label>
				<div class="col-sm-8" style="word-break: break-all;">
					<div class="card-body">${free.boContent }</div>
					<form action="/free/updateform.do" method="get" id="nFrm">
						<input type="hidden" name="boNo" value="${free.boNo }"/>
					</form>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10 ">
					<p>
						<input type="button" class="btn btn-danger" value="삭제" id="delBtn">
						<input type="button" class="btn btn-success" value="수정 " id="updateBtn">
						<a href="/free/list.do" class="btn btn-primary"> 목록</a>
					</p>
				</div>
			</div>
		<hr>
	</div>
</body>
<script src="${pageContext.request.contextPath}/resources/plugins/jquery/jquery.min.js"></script>
<script>
$(function(){
	console.log('${free.boNo }')
	var delBtn = $("#delBtn");
	var updateBtn = $("#updateBtn");
	var nFrm = $("#nFrm");
	
	updateBtn.on("click",function(){
		nFrm.submit();
	})
	
	delBtn.on("click",function(){
		if(confirm("정말 삭제하시겠습니까?")) {
			nFrm.attr("method", "post");
			nFrm.attr("action", "/free/delete.do");
			nFrm.submit();
		} else {
			nFrm.reset();
		}
	})
	
})
</script>
</html>


