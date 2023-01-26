<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div id="header_outer">
<div id="header">
	<div id="gnb">
		<a href="#">회원가입</a>　
		<a href="#">로그인</a>　
		<a href="${contextPath }/admin/" target="_blank">관리자</a></div>
	<h1><a href="${contextPath }/"><img src="${contextPath }/resources/img/header/logo.png" alt="자바 캠핑카" /></a></h1>
	<div id="topmenu">
		<ul>
			<li><a href="#">회사 소개</a></li>
			<li><a href="${contextPath }/car/list">보유 차량</a></li>
			<li><a href="${contextPath }/rent/list">실시간 예약</a></li>
			<li><a href="#">예약 확인</a></li>
			<li><a href="#">커뮤니티</a></li>
			<li><a href="#">고객센터</a></li>
		</ul>
	</div>	
</div>
</div>