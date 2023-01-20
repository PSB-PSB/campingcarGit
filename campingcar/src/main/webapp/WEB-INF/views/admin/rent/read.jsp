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
	
	<div id="wrap">
<!-- ================================================== -->
<c:if test="${empty dto }">
	<p>해당 글이 존재하지 않습니다.</p>
</c:if>
<c:if test="${not empty dto }">
<c:set var="stateclass" value="type01" />
<c:set var="state" value="결제 대기" />
<c:choose>
	<c:when test="${dto.rent_paystate==0 }">
		<c:set var="stateclass" value="type01" />
		<c:set var="state" value="결제 대기" />
	</c:when>
	<c:when test="${dto.rent_paystate==1 }">
		<c:set var="stateclass" value="type02" />
		<c:set var="state" value="결제 완료" />
	</c:when>
	<c:when test="${dto.rent_paystate==2 }">
		<c:set var="stateclass" value="type03" />
		<c:set var="state" value="출고 완료" />
	</c:when>
	<c:when test="${dto.rent_paystate==3 }">
		<c:set var="stateclass" value="type04" />
		<c:set var="state" value="반납 완료" />
	</c:when>		
</c:choose>
<table class="table table-bordered">
<colgroup>
	<col width="15%" />
	<col width="35%" />
	<col width="15%" />
	<col width="35%" />
</colgroup>
<thead>
<tr>
	<th colspan="4" class="state ${stateclass }">#${dto.rent_id } <span>${state }</span></th>
</tr>
</thead>
<tbody>
<tr><th>예약 번호</th><td></td><th>차량 정보</th><td>(${dto.car.car_regid }) ${dto.car.car_modelname } ${dto.car.car_name }</td></tr>
<tr><th>예약자</th><td>${dto.user_id }</td><th>유저 ID</th><td>${dto.user_id }</td></tr>
<tr><th>필수 연락처</th><td>${dto.rent_phone1 }</td><th>예비 연락처</th><td>${dto.rent_phone2 }</td></tr>
<tr><th>차량 출고일</th><td>${dto.rent_startdate }</td><th>차량 반납일</th><td>${dto.rent_enddate }</td></tr>
<tr><th>옵션1</th><td>${dto.rent_option1 }</td><th>옵션2</th><td>${dto.rent_option1 }</td></tr>
<tr>
	<th>결제 비용</th><td>${dto.rent_price }</td>
	<th>결제 유형</th>
	<td>
		<c:choose>
			<c:when test="${dto.rent_paytype==0 }"><p>무통장 입금</p></c:when>
			<c:when test="${dto.rent_paytype==1 }"><p>신용 카드</p></c:when>
		</c:choose>			
	</td>
</tr>
<tr><th>추가 내용</th><td colspan="3">${dto.rent_memo }</td></tr>
</tbody>
</table>

</c:if>

<button onclick="location.href='calendar';" class="btn btn-primary">목록</button>
<!-- ================================================== -->
	</div><!-- // #wrap end -->
</div><!-- // #container end -->

</body>
</html>