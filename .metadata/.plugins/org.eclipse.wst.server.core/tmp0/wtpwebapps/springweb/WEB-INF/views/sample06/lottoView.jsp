<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 컨트롤러에서 나온 false에서 나온 결과 적기 -->
	당첨 결과 : ${ lotto.result }
	<br><br>
	
	<a href="${ header.referer }">뒤로가기</a>
</body>
</html>