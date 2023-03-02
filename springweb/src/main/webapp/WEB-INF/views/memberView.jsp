<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>회원정보입니다</h1>
 <!-- 여기서 c를 이용하여 선택하게 하는데 조건도 넣어줘요 
 	request에 보내지면 el를 사용해서 정리?해야겠죠 
 	memberVO가 reqeustScope안에 있으면 !empty니까 없으면 아니고 있으면
 	그리고 test=" ${key} "
 	-->
 	<c:choose>
 		<c:when test="${ !empty requestScope.mem }">
 		<ul>
	
			<li>이름 : ${ mem.name } </li>
			<li>아이디 : ${ mem.id } </li>
			<li>비밀번호 : ${ mem.pw } </li>
			<li>연락처 : ${ mem.phone } </li>
		
			<a href="${ header.referer }"> 뒤로가기! </a>
	
		</ul>
 		</c:when>
 		<c:otherwise>
 			<ul>
			
				<li>이름 : ${ name } </li>
				<li>아이디 : ${ id } </li>
				<li>비밀번호 : ${ pw } </li>
				<li>연락처 : ${ phone } </li>
			
				<a href="${ header.referer }"> 뒤로가기! </a>
			</ul>
 			
 		</c:otherwise>
 	</c:choose>
</body>
</html>