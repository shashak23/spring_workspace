<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>step1 - 사용자 기본 정보를 입력하세요</h1>
	<form action="/springweb/memberRegisterStep2" method="post">
		아이디 : <input type="text" name="memberId" value="${ memberInfo.memberId }"><br><br> <!-- 값이 저장되어서 남아있으면 value를 해야한ㄷ! -->
		이름 : <input type="text" name="memberName" value="${ memberInfo.memberName }"><br><br> <!-- 근데 사실은 남은게 아니고 세션에 있는 걸 댕겨와서 쓴거임 -->
		주소 : <input type="text" name="memberAddr" value="${ memberInfo.memberAddr }"><br><br>
		<input type="submit" value="두번째 페이지로 이동">
		<!-- 취미와 특기와 상세정보가 나오는 페이지로 넘어가기  -->
	</form>
</body>
</html>