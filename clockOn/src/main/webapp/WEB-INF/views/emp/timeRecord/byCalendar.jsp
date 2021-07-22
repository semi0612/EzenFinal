<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/css/calendar.css">
<link rel="stylesheet" href="/css/request_vacation.css">
<div class="content-wrapper">
    <main>
        <h2>출퇴근기록보기</h2>
        <div class="calendar">
            <div class="header">
                <button class="prevBtn" onclick="prevCal()"><i class="fas fa-angle-double-left"></i></button> 
                <div class="title"> 
                    <span class="yearTitle"></span>
                    <span class="monthTitle"></span>
                </div>
                <button class="nextBtn" onclick="nextCal()"><i class="fas fa-angle-double-right"></i></button>
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
                <div class="dates emp_cal"></div>
            </div>
        </div>
    </main>
</div>
<script type="text/javascript" src="/js/emp_calendar.js"></script>