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
	<!-- 변수를 만들고 값을 할당할 수 있어요  -->
	<%
	int k = 100; 
	%>
	<!-- prefix를 이용해서 시작하는데 "c"는 c로 시작 
			tag를  만들어서 변수를 만들고 값을 할당 할 수 있음-->
	<c:set var="num1" value="100"/>
	
	<!-- 제어문 중 대표적인 'if문' 사용하기  
			연산의 결!과!로 true냐 false냐가 나오게한다	
			여기서 num1 은 위의 var이다 
			여기서 myNum은 model에서 가져온 것이다
			두 개가 100보다 크니? 맞으면 true로 떨어지고
			c tag안에 있는 내용이 나오게 됨
			false면 안에 있는 내용이 나오지 않아요 
			
			근데 사실 else문이 없어요! -> 조건을 넣고 싶을 때만 쓰기 
			
			일반적인 것은 쓰고 싶으면 if문으로만 씀-->
	<c:if test="${ num1 + myNum > 100 }">
		100보다 커요!
	</c:if>
	
	<!-- 일반적으로 조건이 여러개인 경우 c:if 대신 다른 걸 사용해요 
			if else 처럼 만들 수 있는 태그
			c:when 은 조건을 만족하라는 것 
			c:otherwise 는 조건이 아니야? 아니야? -->
	<c:choose>
		<c:when test="${ num1 + myNum > 50">
			50보다 커요! 
		</c:when>
		<!-- 실행시켜서 어떤게 나오는 지 보고? 300 조건이랑 otherwise가 안나오겠죠? -->
		<c:when test="${ num1 + myNum > 100">
			100보다 커요! 
		</c:when>
		<!--  -->
		<c:when test="${ num1 + myNum > 300">
			300보다 커요! 
		</c:when>
		
		<c:otherwise>
			이도저도 아니에요!
		</c:otherwise>
	</c:choose>
		
		<br><br>
		
		<!-- 반복문도 해 볼까요? -->
		<!-- 기본적인 형태 - 1. 반복적인 횟수를 알려줘서 반복하는 경우  
				begin '시작' end '끝' step '증가'
				var="tmp" begin="1" end="5" step="1">
			<li>${ tmp }</li>
				-->
		<ul>
			<c:forEach var="tmp" begin="1" end="5" step="1">
			<li>${ tmp }</li>
			</c:forEach>
			<!-- for문을 작성할 때 int = i 라고 하는 그 i랑 tmp가 같다  -->
		</ul>
		
		<!-- 일반적으로 집합자료구조를 이용한 반복처리를 많이 해요, 대표적인 것이 ArrayList! 
				class에서 했던 list 마들어서 list에 넣은 거를
				리스트 안에 들어가있는 문자열을 얘가 담게 되는거에요  -->
		<ul>
		<c:forEach var="name"  items="${ myList }">
			<li>${ name }</li>
		</c:forEach>
		</ul>
		
		<!-- fmt를 이요해서 변수를 하나 선언 해 보아요 
			 -->
		<c:set var="number" value="123456789" />
		<br><br>
		<!-- 숫자 표현할 때 많이 쓰는 기능이 무엇이냐면, 3자리마다 콤마 표현하는 것 -->	 
		<fmt:formatNumber value="${ number }" />
		<br><br>
		
		<!-- 화폐단위 원(\)넣기  -->
		<fmt:formatNumber value="${ number }" type="currency"/>
		<br><br>		
		
		<!-- fmt를 ㅅ용하기 위해 변수를 하나 선언해 보아요  -->
		<c:set var="number" value="0.783" />
		<br><br>
		
		<fmt:formatNumber value="${ number }" type="percent"/>
		
</body>
</html>