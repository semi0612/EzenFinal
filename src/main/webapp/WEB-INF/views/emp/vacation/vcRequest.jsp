<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/css/request_vacation.css">
<link rel="stylesheet" href="/css/calendar.css">
<div class="content-wrapper">
    <main>
        <h2>휴가 신청</h2>
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
            <form method="post" action="request" enctype="multipart/form-data">
                <div class="vac-q q1">
                    <div class="vac-q q2">
                        <label class="vac-period">잔여 연차</label><input id="rest" type="text" value="${annday.annday_rest}" readonly>
                    </div>
                    <div class="vac-q q2">
                        <label class="vac-period">총 연차</label><input type="text" value="${annday.total_annday}" readonly>
                    </div>
                    <div class="vac-q q2">
                        <label class="vac-period">휴가 기간</label><input type="text" id="vac-period" name="period" readonly>
                    </div>
                    <div class="vac-q q3">
                        <label for="vac-category">휴가 종류</label>
                            <select id="vac-category" name="kind">
                            	<option value="연차">연차</option>
                                <option value="오전반차">오전반차</option>
                                <option value="오후반차">오후반차</option>
                                <option value="병가">병가</option>
                                <option value="대체휴일">대체휴일</option>
                                <option value="특별휴가">특별휴가</option>
                                <option value="기타">기타</option>
                            </select>
                        </div>
                </div>
                <div class="vac-q q4"><label for="vac-reason">휴가 사유</label><input required type="text" id="vac-reason" name="reason"></div>
                <div class="vac-q q5"><span class="fileName">결재.png</span><input type="file" id="vac-prove" class="hiddenBtn" name="file"><label class="fileBtn button-three" for="vac-prove">증빙파일첨부</label></div>
                <div class="vac-send"><button class="button-three" type="submit" onclick="return checkEvi()">전송</button></div>
            </form>
        </div>
    </main>
</div>
<script type="text/javascript" src="/js/calendar_request_vacation.js"></script>