<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="/css/common_header.css">
    <link rel="stylesheet" href="/css/common_main.css">
    <link rel="stylesheet" href="/css/common_all.css">
    <link rel="stylesheet" href="/css/common_nav.css">
    <link rel="stylesheet" href="/css/correction_board.css">
    <link rel="stylesheet" href="/css/common_tooltip.css">
    <!-- 새로추가한 컴포넌트 css들-->
    <link rel="stylesheet" href="/css/common_components.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css"
        integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="/js/common_nav.js"></script>
</head>
<body>
	<div class="nav-collapsed">
	 <div class="content-wrapper">
            <main>
                <h2>정정 신청 내역</h2>
                <table class="corrList">
                    <tr>
                        <th class="corr1">근무일</th>
                        <th class="corr2">출근 시각 </th>
                        <th class="corr2">퇴근 시각</th>
                        <th class="corr3">요청사유 </th>
                        <th class="corr4">요청분류</th>
                        <th class="corr5">요청상태</th>
                    </tr>
                    <c:forEach var="cor" items="${list}">
	                <tr>
	                	<td>${cor.cor_work_day}</td>
						<td>${cor.cor_work_in}</td>
						<td>${cor.cor_work_out}</td>
						<td>${cor.cor_work_res}</td>
						<td>${cor.cor_work_req}</td>
						<td>${cor.cor_work_state}</td>
	                </tr>
                    </c:forEach>
                           <!--  <div class="wrap">
                                <button class="button-one">승인대기</button>
                            </div> -->
                </table>
            </main>
        </div>
    </div>
</body>
</html>