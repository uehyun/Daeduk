<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<td>유저 ID</td>
		<td>${member.userId }</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>${member.password }</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${member.userName }</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td>${member.email }</td>
	</tr>
	<tr>
		<td>생년월일</td>
		<td><fmt:formatDate value="${member.dateOfBirth }"/></td>
	</tr>
	<tr>
		<td>성별</td>
		<td>${member.gender }</td>
	</tr>
	<tr>
		<td>개발자 여부</td>
		<td>${member.developer }</td>
	</tr>
	<tr>
		<td>외국인 여부</td>
		<td>${foreign }</td>
	</tr>
	<tr>
		<td>국적</td>
		<td>
			<c:forEach items="${member.nationality }" var="nation">
				${nation }
			</c:forEach>
		</td>
	</tr>
	<tr>
		<td>소유차량</td>
		<td>
			<c:forEach items="${member.cars }" var="car">
				${car }
			</c:forEach>
		</td>
	</tr>
	<tr>
		<td>취미</td>
		<td>
			<c:forEach items="${member.hobby }" var="hobby">
				${hobby }
			</c:forEach>
		</td>
	</tr>
	<tr>
		<td>우편번호</td>
		<td>${member.address.postCode }</td>
	</tr>
	<tr>
		<td>주소</td>
		<td>${member.address.location }</td>
	</tr>
		<c:forEach items="${member.cardList }" var="cardList" varStatus="status">
	<tr>
			<td>카드${status.index +1 } - 번호</td><td>${cardList.no }</td>
		</tr>
		<tr>
			<td>카드${status.index +1 } - 유효년월</td><td><fmt:formatDate value="${cardList.validMonth }"/></td>
	</tr>
		</c:forEach>
	<tr>
		<td>소개</td>
		<td colspan="3">${member.introduction }</td>
	</tr>
</table>
</body>
</html>