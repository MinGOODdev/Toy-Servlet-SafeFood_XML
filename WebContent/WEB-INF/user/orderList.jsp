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
                <th>도서번호</th>
                <th>도서명</th>
                <th>저자</th>
                <th>가격</th>
                <th>출판사</th>
                <th>출판일</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${not empty purchaseList}">
                <c:forEach items="${purchaseList}" var="b" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${b.isbn}</td>
                        <td>${b.title}</td>
                        <td>${b.author}</td>
                        <td>${b.price} ${b.currency}</td>
                        <td>${b.publisher}</td>
                        <td>${b.publishDate}</td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>