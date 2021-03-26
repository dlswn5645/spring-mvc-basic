
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!--jsp에서 자바 코드를 안쓰는 법 (EL,JSTL) -->
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="com.spring.mvc.user.domain.User" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

    <%--
        //jsp전용주석
        for(var : items) {}
        ${모델이름} -> ${userList} : 모델 객체에서 userList를 사용함

        name(private)을 써도 getName()쓴 것 처럼 받아올 수 있다
    --%>
    <c:forEach var="user" items="${userList}">
        <div>이름: ${user.name}, 나이: ${user.age}세</div>
    </c:forEach>
    =========================================

    <br>
    <a href="/new-form">다시 회원 가입</a>
</form>
</body>
</html>