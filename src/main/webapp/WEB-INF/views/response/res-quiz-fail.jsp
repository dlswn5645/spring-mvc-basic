
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인 성공</h1>
   <p>
      ${user.userId}님은 존재하지 않는 회원이거나 비밀번호가 틀렸습니다. <br>
      <a href="/response/res-login">로그인화면으로</a>
   </p>
</body>
</html>