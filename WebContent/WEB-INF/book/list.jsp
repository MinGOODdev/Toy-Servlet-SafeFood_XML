<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>도서 목록</title>

    <jsp:include page="../partial/config.jsp"></jsp:include>
</head>
<body>
<div class="container div-margin-bottom">
    <jsp:include page="../partial/nav.jsp"></jsp:include>

    <div class="row text-center">
        <c:choose>
            <c:when test="${not empty books}">
                <c:forEach items="${books}" var="b">
                    <div class="col-sm">
                        <div class="card custom-card">
                            <a href="${pageContext.request.contextPath}/main.do?action=view&isbn=${b.isbn}"
                               class="product-font-color">
                                <img src="${pageContext.request.contextPath}/res/img/book.jpg" alt="BOOK"
                                     class="card-img-top">
                                <div class="card-body">
                                    <h4 class="card-title">${b.title}</h4>
                                    <h5>${b.price} ${b.currency}</h5>
                                </div>
                            </a>
                        </div>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <h1>등록된 도서가 없습니다.</h1>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>
