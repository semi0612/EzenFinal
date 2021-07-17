<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/css/request_correction.css">
<link rel="stylesheet" href="/css/calendar.css">
<div class="content-wrapper">
	<main>
		<h2>근태 정정 일괄 신청</h2>
		<div class="vacation-request-form">
			<div class="calendar cal-request">
				<div class="header cal-request-header">
					<button class="prevBtn req-btn" onclick="prevCal()">
						<i class="fas fa-angle-double-left"></i>
					</button>
					<div class="title">
						<span class="yearTitle req-year"></span> 
						<span class="monthTitle req-month"></span>
					</div>
					<button class="nextBtn req-btn" onclick="nextCal()">
						<i class="fas fa-angle-double-right"></i>
					</button>
				</div>
				<div class="calendar-main">
					<div class="days">
						<div class="day">일</div>
						<div class="day">월</div>
						<div class="day">화</div>
						<div class="day">수</div>
						<div class="day">목</div>
						<div class="day">금</div>
						<div class="day">토</div>
					</div>
					<div class="dates"></div>
				</div>
			</div>
			<form method="post" action="corrReq">
				<div class="vac-q q1">
					<div class="vac-q q2">
						<label class="vac-period">정정 기간</label><input type="text" id="vac-period" name="period" readonly>
					</div>
					<div class="vac-q q4">
						<label for="vac-reason">정정 사유</label><input type="text" id="vac-reason" name="reason" required>
					</div>
					<div class="vac-send">
						<button class="button-three" type="submit" onclick="checkForm()">전송</button>
					</div>
				</div>
			</form>
		</div>
	</main>
</div>
<script type="text/javascript" src="/js/calendar_request_correction.js"></script>
