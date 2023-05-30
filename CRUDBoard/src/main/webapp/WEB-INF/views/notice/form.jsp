<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css" />
<title>공지게시판 등록</title>
</head>
<body>
<c:set value="등록" var="name"/>
<c:if test="${status eq 'u'}">
	<c:set value="수정" var="name"/>
</c:if>
	<div class="jumbotron">
		<div class="container">
			<h3 class="display-3">공지게시판 ${name }</h3>
		</div>
	</div>
	<div class="container">
		<form name="newWrite" action="/notice/insert.do" class="form-horizontal" method="post" id="noticeForm">
			<input name="boNo" type="hidden" class="form-control" value="${notice.boNo }">
			<input name="writer" type="hidden" class="form-control" value="a001">
			<div class="form-group row">
				<label class="col-sm-2 control-label" >제목</label>
				<div class="col-sm-5">
					<input id="boTitle" name="boTitle" type="text" class="form-control" placeholder="title" value="${notice.boTitle }">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label" >내용</label>
				<div class="col-sm-8">
					<textarea id="boContent" name="boContent" cols="50" rows="5" class="form-control" placeholder="content">${notice.boContent }</textarea>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10 ">
					<input type="button" id="formBtn" class="btn btn-primary " value="${name }">				
					<input type="reset" class="btn btn-primary " value="취소 ">
				</div>
			</div>
		</form>
		<hr>
	</div>
</body>
<script src="${pageContext.request.contextPath}/resources/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/jquery/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	CKEDITOR.replace("boContent");
	CKEDITOR.config.allowedContent = true;
	
	var formBtn = $("#formBtn");
	var back = $("#back");
	var pattern = /\s/g;
	
	back.on("click", function(){
		history.back();
	})
	
	formBtn.on("click",function(){
		var title = $("#boTitle");
		var content = CKEDITOR.instances.boContent.getData();
		var ext = content.replace(/(<([^>]+)>)/gi, '');
		ext = ext.replace(/&nbsp;/gi,"");
		
		console.log(ext)
		
		if(title.val().match(pattern)) {
			alert("제목에 공백이 존재합니다.");
			$("#boTitle").focus();
			return false;
		}
		
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
			$("#noticeForm").attr("action","/notice/update.do");
		}
		
		$("#noticeForm").submit();
	})
})
</script>
</html>



