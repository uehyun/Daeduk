<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css" />
<title>자유게시판 ${name }</title>
</head>
<body>
	<c:set value="등록" var="name"/>
	<c:if test="${status eq 'u'}">
		<c:set value="수정" var="name"/>
	</c:if>
	<div class="jumbotron">
		<div class="container">
			<h3 class="display-3">자유 게시판 ${name }</h3>
		</div>
	</div>
	<div class="container">
		<form name="newWrite" action="/free/insert.do" class="form-horizontal" method="post" id="freeForm">
			<input name="boNo" type="hidden" class="form-control" value="${free.boNo }">
			<input name="id" type="hidden" class="form-control" value="a001">
			<div class="form-group row">
				<label class="col-sm-2 control-label" >제목</label>
				<div class="col-sm-5">
					<input id="boTitle" name="boTitle" type="text" class="form-control" placeholder="title" value="${free.boTitle }">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label" >내용</label>
				<div class="col-sm-8">
					<textarea id="boContent" name="boContent" cols="50" rows="5" class="form-control" placeholder="content">${free.boContent }</textarea>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10 ">
					<input type="button" id="formBtn" class="btn btn-primary " value="${name }">				
					<input type="reset" class="btn btn-primary " value="취소" id="back">
				</div>
			</div>
		</form>
		<hr>
		<c:if test="${not empty errors}">
			<p>
				${errors.boTitle }<br/>
				${errors.boContent }<br/>
				${errors.msg }
			</p>
		</c:if>
	</div>
</body>
<script src="${pageContext.request.contextPath}/resources/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/jquery/jquery.min.js"></script>
<script>
$(function(){
	CKEDITOR.replace("boContent");
	CKEDITOR.config.allowedContent = true;
	
	var formBtn = $("#formBtn");
	var back = $("#back");
	
	back.on("click", function(){
		history.back();
	})
	
	formBtn.on("click",function(){
		var title = $("#boTitle");
		var content = CKEDITOR.instances.boContent.getData();
		var ext = content.replace(/(<([^>]+)>)/gi, '');
		ext = ext.replace(/&nbsp;/gi,"");
		
		if(title.val().trim() == "") {
			alert("제목을 입력해주세요!");
			$("#boTitle").focus();
			return false;
		}
		
		if(ext.trim() == "" || ext.trim() == null) {
			alert("내용을 입력해주세요!");
			$("#boContent").focus();
			return false;
		}
		
		if(ext.trim().length > 4000) {
	         alert("최대 4000자 입니다.");
	         $('#boContent').focus();
	         return false;
	    } 
		
		if($(this).val() == "수정") {
			$("#freeForm").attr("action","/free/update.do");
		}
		
		$("#freeForm").submit();
	})
})
</script>
</html>



