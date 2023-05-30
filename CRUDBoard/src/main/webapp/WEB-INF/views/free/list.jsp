<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.*"%>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css" />
<title>자유게시판 목록</title>
</head>
<body>
<c:set value="${pagingVO.dataList }" var="freeList"/>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">자유 게시판 목록</h1>
		</div>
	</div>
	<div class="container">
			<div>
				<div class="text-right">
					<span>전체 ${totalRecord}건</span>
				</div>
			</div>
			<div style="padding-top: 50px">
				<div class="row" style="padding-bottom: 20px">
					<div class="col-md-7"></div>
					<div class="col-md-5">
						<div class="row">
							<div class="col-md-2"></div>
							<div class="col-md-10">
							<form class="input-group input-group-sm" method="post" id="searchForm" style="width: 440px;">
								<input type="hidden" name="page" id="page"/>
								<select class="form-control" name="searchType">
									<option value="title" <c:if test="${searchType == 'title' }"><c:out value="selected"/></c:if>>제목</option>
									<option value="writer" <c:if test="${searchType == 'writer' }"><c:out value="selected"/></c:if>>작성자</option>
									<option value="titleWriter" <c:if test="${searchType == 'titleWriter' }"><c:out value="selected"/></c:if>>제목+작성자</option>
								</select>
								<input type="text" id="searchWord" name="searchWord" class="form-control float-right" value="${searchWord }"/>
								<input type="button" value="검색" id="search"/>
								</form>
							</div>
						</div>
					</div>
				</div>
				<table class="table">
					<thead class="table-dark">
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${empty freeList }">
								<tr>
									<td colspan="5">조회하신 게시글이 존재하지 않습니다.</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${freeList }" var="free">
									<tr data-boNo="${free.boNo }">
										<td>${free.boNo }</td>
										<td>${free.boTitle }</td>
										<td>${free.boWriter }</td>
										<td>${free.boDate }</td>
										<td>${free.boHit }</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
			<div class="card-footer clearfix" id="pagingArea">
				${pagingVO.pagingHTML }
			</div>
			<div align="left">
				<a href="/free/form.do" class="btn btn-primary">&laquo;글쓰기</a>
			</div>
		<hr>
	</div>
	<form>
	</form>
</body>
<script src="${pageContext.request.contextPath}/resources/plugins/jquery/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	var tr = $('tr');
	var search = $("#search");
	var searchWord = $("#searchWord");
	
	tr.click(function() {
		var boNo = $(this).data('bono');
		location.href="/free/detail.do?boNo="+boNo;
	});
	
	var pagingArea = $('#pagingArea');
	var searchForm = $("#searchForm");
	
	pagingArea.on('click', 'a', function(event){
		event.preventDefault();
		var pageNo = $(this).data("page");
		console.log(pageNo)
		searchForm.find("#page").val(pageNo);
		searchForm.submit();
	})
	
	search.on("click", function(){
		var searchWord = $("#searchWord");
		var word = searchWord.val().trim();
		searchWord.val(word);
		searchForm.submit();
	})
})
</script>
</html>





