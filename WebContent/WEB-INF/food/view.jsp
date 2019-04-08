<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>식품 상세 정보</title>

    <jsp:include page="../partial/config.jsp"></jsp:include>
</head>
<body>
<div class="container div-margin-bottom">
    <jsp:include page="../partial/nav.jsp"></jsp:include>

    <div class="row text-center">
        <div class="col-6 div-margin-top">
            <img src="${pageContext.request.contextPath}/res/${food.img}" alt="FOOD"
                 class="product-detail-card text-center div-margin-bottom">

            <div class="margin-auto div-margin-top">
                <a href="${pageContext.request.contextPath}/main.do?action=order&code=${food.code}">
                    <button type="button" class="btn btn-primary">EAT</button>
                </a>
                <a href="${pageContext.request.contextPath}/main.do?action=foodList">
                    <button type="button" class="btn btn-primary">식품 목록으로 돌아가기</button>
                </a>
            </div>
            <div class="margin-auto div-margin-top">
                <form action="${pageContext.request.contextPath}/main.do?action=foodDelete&code=${food.code}" method="post">
                    <button class="btn btn-danger" type="submit">식품 식제</button>
                </form>
            </div>
        </div>
        <div class="col-6 div-margin-top table-responsive">
            <table class="table table-hover table-bordered"
                   style="width: 80%;">
                <thead>
                <tr>
                    <th colspan="2">식품 정보</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td style="width: 50%;">식품명</td>
                    <td style="width: 50%;">${food.name}</td>
                </tr>
                <tr>
                    <td style="width: 50%;">제조사</td>
                    <td style="width: 50%;">${food.maker}</td>
                </tr>
                <tr>
                    <td style="width: 50%;">일일 제공량</td>
                    <td style="width: 50%;">${food.supportpereat}</td>
                </tr>
                <tr>
                    <td style="width: 50%;">일회 제공 칼로리</td>
                    <td style="width: 50%;">${food.calory}</td>
                </tr>
                <tr>
                    <td style="width: 50%;">원료</td>
                    <td style="width: 50%;">${food.material}</td>
                </tr>
                <tr>
                    <td style="width: 50%;">알레르기 정보</td>
                    <td style="width: 50%;">${food.allergy}</td>
                </tr>
<%--                <tr>--%>
<%--                    <td>저자</td>--%>
<%--                    <td>${book.author}</td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <td>도서가격</td>--%>
<%--                    <td>${book.price} ${book.currency}</td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <td>도서설명</td>--%>
<%--                    <td>${book.description}</td>--%>
<%--                </tr>--%>
                </tbody>
            </table>
        </div>


    </div>
</div>
</body>
</html>

