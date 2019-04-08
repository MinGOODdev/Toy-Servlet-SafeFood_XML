<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>구매 내역</title>
    <meta charset="UTF-8">

    <jsp:include page="../partial/config.jsp"></jsp:include>
</head>
<body>
<div class="container div-margin-bottom">
    <jsp:include page="../partial/nav.jsp"></jsp:include>

    <div class="table-responsive">
        <h3>구매 내역</h3>
        <table class="table table-hover table-bordered">
            <thead class="thead-light">
            <tr>
                <th>#</th>
                <th>식품명</th>
                <th>제조사</th>
                <th>일회 제공량</th>
                <th>칼로리</th>
                <th>알레르기 정보</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${not empty purchaseList}">
                <c:forEach items="${purchaseList}" var="f" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${f.name}</td>
                        <td>${f.maker}</td>
                        <td>${f.supportpereat}</td>
                        <td>${f.calory}</td>
                        <td>${f.allergy}</td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>