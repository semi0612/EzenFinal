<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/corrlist_board_all.css">
<body>
	<div class="nav-collapsed">
	 <div class="content-wrapper">
            <main>
                <h2>정정 신청 전체 내역</h2>
                <table class="corrList">
                    <tr>
                    	<th class="corr1">번호</th>
                    	<th class="corr2">사원번호</th>
                        <th class="corr3">근무일</th>
                        <th class="corr4">출근 시각</th>
                        <th class="corr5">퇴근 시각</th>
                        <th class="corr6">요청사유 </th>
                        <th class="corr5">요청분류</th>
                        <th class="corr5">요청상태</th>
                    </tr>
                    <c:forEach var="cor" items="${corrList}">
                    <tr>
                    	<td>${cor.work_cor_rid}</td>
                    	<td>${cor.emp_id}</td>
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