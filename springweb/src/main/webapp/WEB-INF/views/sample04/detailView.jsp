<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<img src="/springweb/resources/imgs/${ imgname }.jpg"/>
	<!-- 파일을 읽을 수 있도록 확장자를 반드시 작성해주서야 해요
	 	1. jsp에서 읽을 수 있도록 .확장자명 적기
	 	2. class 자체에서 읽을 수 있도록 value옆에 확장자명을 적기 
	 	2번은 비추하는 방식이고 이 외에  다른 png나 gif 를 하고 싶다면
	 	확장자명을 달리해서 해도 돼요!
	 	일반적으로 확장자를 통일해서 이미지나 필요한 파일을 넣도록해요
	 	근데 다양한 파일들을 검색해서 중구난방인채로 찾게 하고 싶다면
	 	로직을 써야하는데 엄청 복잡해져요 
	 	
	 	그래서 사실 일반적으로 하나의 확장자로 통일해서 써요   -->
</body>
</html>