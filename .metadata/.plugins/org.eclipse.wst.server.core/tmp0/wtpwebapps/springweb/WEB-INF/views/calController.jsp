<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>연산성공</h1>
	<!-- EL 검색순 -->
	<% pageContext.setAttribute("myData", "고양이는 냐옹냐옹"); %>
	<br>
	<h3>request.getAttribute("msg") - 결과는 : <%= request.getAttribute("msg") %></h3>
	<h3>$ { msg } - 결과는 : ${ msg }</h3>
	<h3>$ { param.msg } - 결과는 : ${ param.msg }</h3>
	<h3>$ { param.firstNum } - 결과는 : ${ param.firstNum }</h3>
	<h3>$ { pageScope.msg } - 결과는 : ${ pageScope.msg }</h3>
	<h3>$ { pageScope.myData } - 결과는 : ${ pageScope.myData }</h3>
	<br>
	<a href="${ header.referer }">뒤로가기</a>
</body>
</html>