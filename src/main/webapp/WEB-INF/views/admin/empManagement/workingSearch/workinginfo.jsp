<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="/css/workingSearch.css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"/>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- datepicker 한국어로 -->
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/i18n/datepicker-ko.js"></script>
<script src="/js/datepicker.js"></script>
<div class="content-wrapper">
<main>
	<h2>직원 근태 기록조회</h2>
	<div class="main-wrapper working-wrapper">
		<form action="#">
		<div class="working-content">
						<div class="date">
                            <!-- 시작일 -->
                            <span class="dset">
                                <input type="text" class="datepicker inpType" name="searchStartDate" id="searchStartDate" placeholder="시작일" readonly="readonly">
                                <a href="#none" class="btncalendar dateclick"><i class="far fa-calendar-alt"></i></a>
                            </span>
                            <span class="demi">-</span>
                            <!-- 종료일 -->
                            <span class="dset">
                                <input type="text" class="datepicker inpType" name="searchEndDate" id="searchEndDate" placeholder="종료일" >
                                <a href="#none" class="btncalendar dateclick"><i class="far fa-calendar-alt"></i></a>
                            </span>
                        </div>
			<table class="workingSearch-table">
				<thead>
					<tr>
						<th class="th-one">사원번호</th>
						<th class="th-two">부서</th>
						<th class="th-three">직원</th>
						<th class="th-four">근무일수</th>
						<th class="th-five">지각일수</th>
						<th class="th-six">결근일수</th>
						<th class="th-seven">휴무일수</th>
						<th class="th-eight">총 근무시간</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${attendlist}" var="all">
					<tr>
						<td class="td-one">${all.emp_id}</td>
						<td class="td-two">${all.emp_dept}</td>
						<td class="td-three">${all.emp_name}</td>
						<td class="td-four">${all.workDay} <c:if test="${!empty all.workDay}">일</c:if></td>
						<td class="td-five">${all.lateDay}<c:if test="${!empty all.lateDay}">일</c:if></td>
						<td class="td-six">${all.absent}<c:if test="${!empty all.absent}">일</c:if></td>
						<td class="td-seven">${all.holiday}<c:if test="${!empty all.holiday}">일</c:if></td>
						<td class="td-eight">${all.workingTime}<c:if test="${!empty all.workingTime}">시간</c:if></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="page_wrap">
   				<div class="page_nation">
      				<a class="arrow pprev" href="#"><i class="fas fa-angle-left"></i></a>
      				<a class="arrow prev" href="#"><i class="fas fa-angle-double-left"></i></a>
      				<a href="#" class="active">1</a>
      				<a href="#">2</a>
      				<a href="#">3</a>
      				<a href="#">4</a>
      				<a href="#">5</a>
      				<a href="#">6</a>
	      			<a href="#">7</a>
	      			<a href="#">8</a>
      				<a href="#">9</a>
      				<a href="#">10</a>
      				<a class="arrow next" href="#"><i class="fas fa-angle-right"></i></a>
      				<a class="arrow nnext" href="#"><i class="fas fa-angle-double-right"></i></a>
   				</div>
			</div>
		</div>
		</form>
	</div>
</main>
</div> 