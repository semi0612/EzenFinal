<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <link rel="stylesheet" href="/css/calendar.css">
 <div class="content-wrapper">
    <main>
        <h2>출퇴근기록보기</h2>
        <div class="calendar cal-admin">
            <div class="header">
                <button class="prevBtn" onclick="prevCal()"><i class="fas fa-angle-double-left"></i></button> 
                <div class="title"> 
                    <span class="yearTitle"></span>
                    <span class="monthTitle"></span>
                </div>
                <button class="nextBtn" onclick="nextCal()"><i class="fas fa-angle-double-right"></i></button>
            </div>
            <div class="calendar-main tab-admin">
                <table class="record-calendar">
                	<div class="dates">
                	<!--직원별 기록시작-->
                	</div>
                </table>
            </div>
        </div>
    </main>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="/js/calendar_record.js"></script>