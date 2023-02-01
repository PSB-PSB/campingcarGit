<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<head>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>

<title>Home</title>
<script>

$(document).ready(function(){  
     
       //아이디 유효성검사
    $("#update").on("click", function(){
    	
       if($("#garage_name").val()==""){
          alert("정비소명을 입력해주세요.");
          $("#garage_name").focus();
          return false;
       }
       //비밀번호 유효성검사
       if($("#garage_addr").val()==""){
          alert("주소를 입력해주세요.");
          $("#garage_addr").focus();
          return false;
       }
       //이름 유효성검사
       if($("#garage_code").val()==""){
          alert("지역을 선택해주세요.");
          $("#garage_code").focus();
          return false;
       }
      
    });
 })
</script>

</head>
<body>

	
	<h1 style="text-align: center">여기는 정비소 정보수정 관리페이지(관리자) 입니다.</h1>
<div class="container text-center">
			<h4>정보를 수정하세요</h4>
	<table class="table table-bordered text-center";>
	
			<form method = "post">
			
			<div>
					<div>정비소명:	<input type="text" id="garage_name" name="garage_name" value="${dto.garage_name}"></div>
					<div>정비소주소:	<input type="text" id="garage_addr" name="garage_addr" value="${dto.garage_addr}"></div>
					<div>정비소번호:	<input type="text" id="garage_phone" name="garage_phone" value="${dto.garage_phone}"></div>
					<div>정비소상태:  
					
					  <input class="form-check-input" type="radio" name="garage_state" value="1" checked>
					  <label class="form-check-label" for="garage_state">영업중&nbsp;&nbsp;</label>
					
					
					  <input class="form-check-input" type="radio" name="garage_state" value="2">
					  <label class="form-check-label" for="grage_state">휴업중</label>
					

					</div>
				    
				    <div>정비소 지역&nbsp;&nbsp;
					<select id="garage_code" name="garage_code" size="1" >			
							<option value="">지역을 선택하세요.</option>
							<option value="41820">가평군</option>
							<option value="41610">경기광주시</option>
							<option value="41280">고양시</option>
							<option value="41290">과천시</option>
							<option value="41210">광명시</option>
							<option value="41310">구리시</option>
							<option value="41410">군포시</option>
							<option value="41570">김포시</option>
							<option value="41360">남양주시</option>						
							<option value="41250">동두천시</option>
							
							<option value="41190">부천시</option>
							<option value="41130">성남시</option>
							<option value="41110">수원시</option>
							<option value="41390">시흥시</option>
							<option value="41270">안산시</option>
							<option value="41170">안양시</option>
							<option value="41630">양주시</option>
							<option value="41830">양평군</option>
							
							<option value="41670">여주시</option>
							<option value="41800">연천군</option>
							<option value="41370">오산시</option>
							<option value="41460">용인시</option>
							<option value="41430">의왕시</option>
							<option value="41150">의정부시</option>
							<option value="41500">이천시</option>
							<option value="41480">파주시</option>
							<option value="41220">평택시</option>
							<option value="41650">포천시</option>
							<option value="41450">하남시</option>
							<option value="41590">화성시</option>						
						</select>
					</div>
		</div>
		
				<button class="btn btn-success" type="submit" id="update">수정</button>
				<button class="btn btn-danger" type ="reset" value="초기화">초기화</button>
				<button class="btn btn-secondary" type="button" onclick='location.href="${contextPath }/garage/listcri"'>돌아가기</button>
				
	</form>
		
			
				
			
			
				
					 
						

	</table>
</div>


	<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
		
	
</body>

</html>
