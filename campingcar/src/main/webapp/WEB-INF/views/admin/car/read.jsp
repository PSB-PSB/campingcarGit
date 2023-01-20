<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바 캠핑카 - 관리자 페이지</title>
<%@ include file="../../include/plugin.jsp" %>
<link href="${contextPath}/resources/css/admin/admin_all.css" rel="stylesheet" />
<style>

</style>
</head>
<body>

<div id="container">
	<!-- #sidebar start -->
	<%@ include file="../include/sidebar.jsp" %>
	<!-- // #sidebar end -->

	<!-- #topmenu start -->
	<%@ include file="../include/topmenu.jsp" %>
	<!-- // #topmenu end -->
	
	<div id="wrap">
<!-- ================================================== -->


<h2>차량 조회</h2>

<table border="1" width="100%">
<colgroupd>
	<col width="20%" />
	<col width="*" />
</colgroupd>
<tr>
	<th>등록 번호</th><td>${dto.car_regid }</td>
</tr>
<tr>
	<th>대여 회사</th><td>${dto.car_rentcompid }</td>
</tr>
<tr>
	<th>모델 명</th><td>${dto.car_modelname }</td>
</tr>
<tr>
	<th>차량 이름</th><td>${dto.car_name }</td>
</tr>
<tr>
	<th>차량 번호</th><td>${dto.car_number }</td>
</tr>
<tr>
	<th>탑승 인원</th><td>${dto.car_capa }</td>
</tr>
<tr>
	<th>내부 옵션</th><td>${dto.car_option }</td>
</tr>
<tr>
	<th>세부 내용</th><td>${dto.car_detail }</td>
</tr>
<tr>
	<th>대여 비용 (1일 기준)</th><td>${dto.car_rentprice }</td>
</tr>
<tr>
	<th>등록 일</th><td>${dto.car_regdate }</td>
</tr>
</table>
<button onclick="location.href='list';">목록</button>
<button onclick="location.href='register?car_regid=${dto.car_regid }';">수정</button>
<form action="remove" method="post">
	<input type="text" name="car_regid" value="${dto.car_regid }" />
	<button type="submit">삭제</button>
</form>


<!-- ================================================== -->
	</div><!-- // #wrap end -->
</div><!-- // #container end -->

</body>
</html>