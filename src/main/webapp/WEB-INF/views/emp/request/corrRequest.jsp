<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <link rel="stylesheet" href="/css/common_header.css">
    <link rel="stylesheet" href="/css/common_main.css">
    <link rel="stylesheet" href="/css/common_all.css">
    <link rel="stylesheet" href="/css/common_nav.css">
    <link rel="stylesheet" href="/css/common_tooltip.css">
    <link rel="stylesheet" href="/css/common_components.css">
    <link rel="stylesheet" href="/css/request_vacation.css">
    <link rel="stylesheet" href="/css/calendar.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css" integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="/js/common_nav.js"></script>

    
<div class="nav-collapsed">

    <div class="content-wrapper">
    <main>
        <h2>정정 신청</h2>
        <div class="vacation-request-form">
            <div class="calendar cal-request">
                <div class="header cal-request-header">
                    <button class="prevBtn req-btn" onclick="prevCal()"><i class="fas fa-angle-double-left"></i></button> 
                    <div class="title"> 
                        <span class="yearTitle req-year"></span>
                        <span class="monthTitle req-month"></span>
                    </div>
                    <button class="nextBtn req-btn" onclick="nextCal()"><i class="fas fa-angle-double-right"></i></button>
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
        <form method="post">
        <div class="vac-q q1"><label class="vac-period">정정 기간</label><input type="text" id="vac-period" readonly></div>
        <div class="vac-q q3"><label for="vac-period">정정 일수</label><input type="text" id="vac-period"></div>
        <div class="vac-q q4"><label for="vac-reason">정정 사유</label><input type="text" id="vac-reason"></div>
        <div class="vac-send"><button class="button-three">전송</button></div>
       </form>
    </div>
    </main>
</div>
<script type="text/javascript" src="/js/calendar_request_vacation.js"></script>
