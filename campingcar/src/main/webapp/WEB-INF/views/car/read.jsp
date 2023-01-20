<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

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

</body>
</html>