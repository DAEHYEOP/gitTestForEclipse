<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메일 보내기</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>mailForm.jsp</h1>

		<form action="sendmail" method="post">

			<table class="table">
				<tr>
					<th>수신자주소</th>
					<td><input type="text" name="mailTo" id="" /></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" id="" /></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="contents" id="" cols="100" rows="20"></textarea></td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="submit" value="발송" />
					 <input type="reset" value="초기화" /> 
					 <a href="/"><input type="button" value="메인으로 이동" /></a>
					 </td>
				</tr>
			</table>

		</form>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
			crossorigin="anonymous"></script>
	</div>
</body>
</html>