<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>식품 상세 정보</title>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.bundle.js"></script>
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
            <div>
            	<canvas id="myChart" width="300" height="300"></canvas>
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
                </tbody>
            </table>
        </div>

		
    </div>
    <script>
    	var ctx = document.getElementById('myChart');
        var myChart = new Chart(ctx, {
            type: 'doughnut',
            data: {
                labels: ['칼로리', '탄수화물', '단백질', '지방', '당류', '나트륨', '콜레스테롤', '포화지방산', '트랜스지방'],
                datasets: [{
                    label: '# 영양소',
                    data: [
                        ${food.calory},
                        ${food.carbo},
                        ${food.protein},
                        ${food.fat},
                        ${food.sugar},
                        ${food.natrium},
                        ${food.chole},
                        ${food.fattyacid},
                        ${food.transfat}
                    ],
                    backgroundColor: [
                        'rgba(192, 47, 30,1)',
                        'rgba(216, 78, 31, 1)',
                        'rgba(236, 170, 57, 1)',
                        'rgba(234, 200, 67, 1)',
                        'rgba(162, 184, 109, 1)',
                        'rgba(92, 167, 147, 1)',
                        'rgba(19, 149, 185, 1)',
                        'rgba(16, 91, 120, 1)',
                        'rgba(17, 59, 84, 1)'
                    ],
                    borderColor: [
                        'rgba(255,99,132,1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)',
                        'rgba(100, 200, 129, 0.2)',
                        'rgba(50, 10, 6, 0.2)',
                        'rgba(30, 30, 64, 0.2)'
                    ],
                    borderWidth: 0
                }]
            }
        });
    </script>
</div>
</body>
</html>

