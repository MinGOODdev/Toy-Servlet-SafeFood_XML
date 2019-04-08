<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>

    <jsp:include page="WEB-INF/partial/config.jsp"></jsp:include>
    <script src="${pageContext.request.contextPath}/res/js/login.js"></script>
</head>
<body>
<div class="container text-center" style="margin-top: 8%;">
    <h1 class="ssafy">회원가입</h1>
    <hr>

    <form action="${pageContext.request.contextPath}/main.do" method="post">
        <input type="hidden" name="action" value="signUp">

        <div class="form-group">
            <label for="id">ID</label>
            <input class="form-control margin-auto login-input-width"
                   type="text" id="id" name="id"
                   placeholder="ID를 입력하세요.">

            <c:if test="${errorMessages.idError != null}">
                <span class="error">${errorMessages.idError}</span>
            </c:if>

            <c:if test="${errorMessages.idAlready != null}">
                <span class="error">${errorMessages.idAlready}</span>
            </c:if>
        </div>

        <div class="form-group">
            <label for="pw">PW</label>
            <input class="form-control margin-auto login-input-width"
                   type="password" id="pw" name="pw"
                   placeholder="Password를 입력하세요.">

            <c:if test="${errorMessages.pwError != null}">
                <span class="error">${errorMessages.pwError}</span>
            </c:if>
        </div>

        <div class="form-group">
            <label for="name">NAME</label>
            <input class="form-control margin-auto login-input-width"
                   type="text" id="name" name="name"
                   placeholder="이름을 입력하세요.">

            <c:if test="${errorMessages.nameError != null}">
                <span class="error">${errorMessages.nameError}</span>
            </c:if>
        </div>

        <div class="form-group">
            <label for="age">AGE</label>
            <input class="form-control margin-auto login-input-width"
                   type="number" id="age" name="age" value="1"
                   placeholder="나이를 입력하세요.">

            <c:if test="${errorMessages.ageError != null}">
                <span class="error">${errorMessages.ageError}</span>
            </c:if>
        </div>

        <div>
            <label>GENDER</label><br>
            <input type="radio" name="gender" value="남"> 남
            <input type="radio" name="gender" value="여"> 여
            <br>
            <c:if test="${errorMessages.genderError != null}">
                <span class="error">${errorMessages.genderError}</span>
            </c:if>
        </div>

		<div>
            <label>Allergy</label><br>
            <label><input type="checkbox" name="bean"> 대두</label>
           	<label><input type="checkbox" name="milk"> 우유</label>
           	<label><input type="checkbox" name="salmon"> 연어</label>
            <br>
        </div>

        <hr>
        <button class="btn btn-primary" type="submit" onclick="validate();">저장</button>
    </form>
</div>
</body>
</html>