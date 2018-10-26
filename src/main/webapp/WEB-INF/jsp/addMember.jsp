<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>addMember Form</h2>
	<form action="<%=request.getContextPath()%>/AddMember" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="pw"></td>
			</tr>
			<tr>
				<td>권한</td>
				<td>
					<select name="level">
		                <option value="1">== 선택하세요 ==</option>
		                <option value="1">고객</option>
		                <option value="0">관리자</option>
            		</select>
            	</td>
			</tr>
		</table>
		<div>
			<a href="<%=request.getContextPath()%>/">
				<button type="button">취소</button></a>
			<input type="submit" value="회원가입">
		</div>
	</form>
</body>
</html>