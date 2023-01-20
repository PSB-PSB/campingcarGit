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

<h2>차량 목록</h2>

<table width="100%" class="table table-bordered center" style="border-collapse:collapse;">
<colgroup>
</colgroup>
<thead>
</thead>
<tbody>
<c:forEach items="${dtolist}" var="dto">
<tr>
	<th>${dto.car_regid }</th>
	<td>${dto.car_rentcompid }</td>
	<td><a href="read?car_regid=${dto.car_regid }">${dto.car_modelname } ${dto.car_name }</a></td>
	<td>${dto.car_number }</td>
	<td>${dto.car_capa }</td>
	<td>${dto.car_rentprice }</td>
	<td>${dto.car_regdate }</td>
</tr>
</c:forEach>
</tbody>
</table>

<button onclick="location.href='${contextPath}/admin/car/register';">차량 등록</button>

<!-- ================================================== -->
	</div><!-- // #wrap end -->
</div><!-- // #container end -->

</body>
</html>