<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
#topmenu {height:50px; width:2000px; background:#f0f0f0; position:fixed; padding:0px 0px 0px 300px;}
</style>
</head>
<body>

<div id="container">
	<!-- #sidebar start -->
	<%@ include file="../include/sidebar.jsp" %>
	<!-- // #sidebar end -->
	
	<div id="topmenu">
		<h2>예약 목록</h2>
		<div id="gnb"></div>
	</div>
	
	<div id="wrap">
<!-- ================================================== -->

<h2>예약 목록</h2>

<div class="board_list">
<table class="table table-bordered table-hover center">
<colgroup>
</colgroup>
<thead>
<tr class="table-secondary">
	<th>#</th>
	<th>차량</th>
	<th>사용자 ID</th>
	<th>필수 연락처</th>
	<th>예비 연락처</th>
	<th>차량 출고일</th>
	<th>차량 반납일</th>
	<th>옵션1</th>
	<th>옵션2</th>
	<th>결제 비용</th>
	<th>결제 방법</th>
	<th>결제 상태</th>
</tr>
</thead>
<tbody>
<c:forEach items="${dtolist }" var="dto">
<tr onclick="location.href='read?rent_id=${dto.rent_id}';">
	<td>${dto.rent_id }</td>	
	<td>${dto.car_regid }</td>	
	<td>${dto.user_id }</td>	
	<td>${fn:substring(dto.rent_phone1,0,3) }-${fn:substring(dto.rent_phone1,3,7) }-${fn:substring(dto.rent_phone1,7,11) }</td>	
	<td>${fn:substring(dto.rent_phone2,0,3) }-${fn:substring(dto.rent_phone2,3,7) }-${fn:substring(dto.rent_phone2,7,11) }</td>	
	<td>${dto.rent_startdate }</td>	
	<td>${dto.rent_enddate }</td>	
	<td><input type="checkbox" disabled <c:if test="${dto.rent_option1==1 }">checked</c:if> /></td>	
	<td><input type="checkbox" disabled <c:if test="${dto.rent_option1==2 }">checked</c:if> /></td>	
	<td class="right"><fmt:formatNumber value="${dto.rent_price }" pattern="#,###" /></td>	
	<td>
		<c:choose>
			<c:when test="${dto.rent_paytype==0 }"><p>무통장 입금</p></c:when>
			<c:when test="${dto.rent_paytype==1 }"><p>신용 카드</p></c:when>
		</c:choose>	
	</td>	
	<td>
		<c:choose>
			<c:when test="${dto.rent_paystate==0 }"><p class="state type01">결제 대기</p></c:when>
			<c:when test="${dto.rent_paystate==1 }"><p class="state type02">결제 완료</p></c:when>
			<c:when test="${dto.rent_paystate==2 }"><p class="state type03">출고 완료</p></c:when>
			<c:when test="${dto.rent_paystate==3 }"><p class="state type04">반납 완료</p></c:when>
		</c:choose>
	</td>	
</tr>
</c:forEach>
</tbody>
</table>
</div>

<!-- ================================================== -->
	</div><!-- // #wrap end -->
</div><!-- // #container end -->

</body>
</html>