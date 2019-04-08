<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>도서 상세 정보</title>

    <jsp:include page="../partial/config.jsp"></jsp:include>
</head>
<body>
<div class="container div-margin-bottom">
    <jsp:include page="../partial/nav.jsp"></jsp:include>

    <div class="row text-center">
        <div class="col-6 div-margin-top">
            <img src="${pageContext.request.contextPath}/res/img/book.jpg" alt="BOOK"
                 class="product-detail-card text-center div-margin-bottom">

            <div class="margin-auto div-margin-top">
                <a href="${pageContext.request.contextPath}/main.do?action=order&isbn=${book.isbn}">
                    <button type="button" class="btn btn-primary">구매</button>
                </a>
                <a href="${pageContext.request.contextPath}/main.do?action=bookList">
                    <button type="button" class="btn btn-primary">도서 목록으로 돌아가기</button>
                </a>
            </div>
            <div class="margin-auto div-margin-top">
                <form action="${pageContext.request.contextPath}/main.do?action=bookDelete&isbn=${book.isbn}" method="post">
                    <button class="btn btn-danger" type="submit">도서 식제</button>
                </form>
            </div>
        </div>
        <div class="col-6 div-margin-top table-responsive">
            <table class="table table-hover table-bordered"
                   style="width: 80%;">
                <thead>
                <tr>
                    <th colspan="2">도서 정보</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>도서명</td>
                    <td>${book.title}</td>
                </tr>
                <tr>
                    <td>도서번호</td>
                    <td>${book.isbn}</td>
                </tr>
                <tr>
                    <td>도서분류</td>
                    <td>${book.catalogue}</td>
                </tr>
                <tr>
                    <td>도서국가</td>
                    <td>${book.nation}</td>
                </tr>
                <tr>
                    <td>출판일</td>
                    <td>${book.publishDate}</td>
                </tr>
                <tr>
                    <td>출판사</td>
                    <td>${book.publisher}</td>
                </tr>
                <tr>
                    <td>저자</td>
                    <td>${book.author}</td>
                </tr>
                <tr>
                    <td>도서가격</td>
                    <td>${book.price} ${book.currency}</td>
                </tr>
                <tr>
                    <td>도서설명</td>
                    <td>${book.description}</td>
                </tr>
                </tbody>
            </table>
        </div>


    </div>
</div>

<jsp:include page="../partial/footer.jsp"></jsp:include>
</body>
</html>

