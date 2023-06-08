<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<section class="content">
	<div class="container-fluid">
		<div class="row" style="justify-content:center;">
			<div class="col-md-6">
				<div class="card card-primary">
					<div class="card-header">
						<h3 class="card-title">공지사항 등록</h3>
					</div>
					<!-- 
						1) method는 꼭 post
						2) enctype="multipart/form-data"
						3) input type="file"
						
						요청 URI : /notice/generalFormPost
						요청 방식 : post
						요청 파라미터 : {boTitle=제목, boContent=내용, boWriter=작성자, boFile=파일}
					 -->
					<form id="frm" name="frm" action="/notice/generalFormPost" method="post" enctype="multipart/form-data">
						<div class="card-body">
							<div class="form-group">
								<label for="boTitle">제목</label>
								<input type="text" class="form-control" id="boTitle" name="boTitle" placeholder="제목을 입력해주세요." required/>
							</div>
							<div class="form-group">
								<label for="boContent">내용을 입력해주세요</label>
								<textarea id="boContent" name="boContent" class="form-control" rows="14"></textarea>
							</div>
							<div class="form-group">
								<label for="boWriter">작성자</label>
								<input type="text" class="form-control" id="boWriter" name="boWriter" placeholder="내용을 입력해주세요." required/>
							</div>
							<div class="form-group">
								<label for="boFile">파일</label>
								<div class="input-group">
									<div class="custom-file">
										<input type="file" class="custom-file-input" id="boFile" name="boFile" multiple>
										<label class="custom-file-label" for="boFile">파일을 선택해주세요.</label>
									</div>
								</div>
							</div>
						</div>
				
						<div class="card-footer">
							<button type="submit" class="btn btn-primary">등록</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>
<script type="text/javascript">
	CKEDITOR.replace("boContent");
</script>