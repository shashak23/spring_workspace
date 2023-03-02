<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수행된 결과입니다</h1>
	
	<h2>RequestScope</h2>
	
	<h3>requestScope.data1 : ${ requestScope.data1 }</h3>  <!-- createString1가 모델로 붙어있으니까 나옴 -->
		<h3>requestScope.data2 : ${ requestScope.data2 }</h3>  <!-- createString2가 나옴 -->
			<h3>param.msg : ${ param.msg }</h3>  <!-- 클라이언트가 보낸 msg 찍을거야  파람이라는 외작객체가 msg를 들고 있으니까!-->
				<h3>requestScope.newStudent : ${ requestScope.newStudent }</h3>  <!-- key값으로 정한 것이 여기서 쓰여야해요! -->
		
	<hr>
	<h2>sessionScope</h2>
	<h3>sessionScope.data1 : ${ sessionScope.data1 }</h3>  
		<h3>sessionScope.data2 : ${ sessionScope.data2 }</h3>
			<h3>sessionScope.newStudent : ${ sessionScope.newStudent }</h3>
	
</body>
</html>