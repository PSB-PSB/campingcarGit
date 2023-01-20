<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
    
<div id="sidebar">
	<h1>
		<a href="${contextPath }/admin/"><img src="${contextPath }/resources/img/header/logo.png" alt="" /></a>
		<p>관리자 페이지</p>
	</h1>
	<ul>
		<li><a href="${contextPath }/admin/car/list">차량 목록</a></li>
		<li><a href="${contextPath }/admin/rent/calendar">예약 현황</a>
			<ul>
				<li><a href="${contextPath }/admin/rent/calendar">달력형 예약 현황</a></li>
				<li><a href="${contextPath }/admin/rent/list">목록형 예약 현황</a></li>
			</ul>
		</li>
		<li><a href="#">대여 회사 관리</a>
			<ul>
				<li><a href="#">대여 회사 현황</a></li>
			</ul>		
		</li>
		<li><a href="#">게시판 관리</a></li>
	</ul>
</div>