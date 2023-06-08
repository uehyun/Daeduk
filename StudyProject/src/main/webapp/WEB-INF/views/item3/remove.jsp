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
	<h2>Remove</h2>
	<form action="/item3/remove" method="post" enctype="multipart/form-data">
		<input type="hidden" name="itemId" value="${item.itemId }"/>
		<table border="1">
			<tr>
				<td>상품명</td>
				<td>
					<input type="text" name="itemName" id="itemName" value="${item.itemName }" disabled="disabled"/>
				</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>
					<input type="text" name="price" id="price" value="${item.price }" disabled="disabled"/>
				</td>
			</tr>
			<tr>
				<td>파일</td>
				<td>
					<div class="uploadedList"></div>
				</td>
			</tr>
			<tr>
				<td>개요</td>
				<td>
					<textarea rows="10" cols="30" name="description" disabled="disabled">${item.description }</textarea>
				</td>
			</tr>
		</table>
		<div>
			<button type="submit" id="btnRemove">Remove</button>
			<button type="button" id="btnList" onclick="javascript:location.href='/item3/list'">List</button>
		</div>
	</form>
</body>
<script type="text/javascript">
$(function(){
	var itemId = ${item.itemId};
	console.log("itemId : " + itemId);
	
	$.getJSON("/item3/getAttach/" + itemId, function(list){
		$(list).each(function(){
			console.log("data : " + this);
			
			var data = this;
			var str = "";
			
			if(checkImageType(data)) {	// 이미지면 이미지태그를 이용하여 출력
				str += "<div>";
				str += "	<a href='/item3/displayFile?fileName=" + data + "'>";
				str += "		<img src='/item3/displayFile?fileName=" + getThumbnailName(data) + "'/>";
				str += "	</a>";
				str += "	<span>X</span>";
				str +="</div>";
			} else {
				str += "<div>";
				str += "	<a href='/item3/displayFile?fileName=" + data + "'>" + getOriginalName(data) + "</a>";
				str += "	<span>X</span>";
				str +="</div>";
			}
			
			$(".uploadedList").append(str);
		});
	});
	
	function getThumbnailName(fileName) {
		var front = fileName.substr(0, 12);	// /2023/06/07 폴더
		var end = fileName.substr(12);		// 뒤 파일 명
		
		return front + "s_" + end;
	}
	
	function getOriginalName(fileName) {
		if(checkImageType(fileName)) {
			return;
		}
		
		var idx = fileName.indexOf("_") + 1;
		return fileName.substr(idx);
	}
	
	
	// 이미지 파일인지 확인
	function checkImageType(fileName) {
		var pattern = /jpg|gif|png|jpeg/;
		return fileName.match(pattern); // 패턴과 일치하면 true
	}
});
</script>
</html>