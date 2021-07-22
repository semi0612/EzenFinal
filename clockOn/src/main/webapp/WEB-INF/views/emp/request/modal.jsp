<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css"
        integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc" crossorigin="anonymous">
        <link rel="stylesheet" href="/css/common_components.css">
        <link rel="stylesheet" href="/css/modal.css">
        <link rel="stylesheet" href="/css/common_all.css">
        <script type="/js/calendar.js"></script>
        <script src="/js/modal.js"></script>
        <title>정정 신청</title>
    </head>

    <body>
        <!--모달 내용-->
        <div id="my_modal">
            <a class="modal_close_btn"><i class="fas fa-times"></i></a>
            <div class="request-head">
                <h5 class="modal-left">요청명</h5><h5 class="modal-right">요청분류</h5>
            </div>

            <div class="request-input">
                <label class="request-name">출퇴근 기록정정</label>
               
                <select class="select-request" name="request" >
                    <option value="none">출퇴근 누락</option>
                    <option value="one">결근</option>
                    <option value="two">지각</option>
                </select>    
            </div> 
            <div class="request-head">
                <h5 class="modal-left">날짜</h5>
            </div>
            <div class="request-input">
            	<!-- js를 통해 해당 날짜로 수정 -->
                <label class="request-name">
                	<input>
                </label>    
            </div>
            <div class="request-head">
                <h5 class="modal-left">기록된 시각</h5><h5 class="modal-right-two">변경요청 시각</h5>
            </div>
            <div class="request-input">
            	<!-- 날짜 수정이 가능하게끔 뚫어두기 (value에 기존 입력값 넣기)--> 
                <label class="request-name">
                	<input type="text" value=""/>
                </label>
                <label class="request-name-right">
                	<input type="text" placeholder=" 변경 요청 시각을 입력하세요."/>
                </label> 
            </div>

            <div class="request-head">
                <h5 class="modal-left-two">요청사유</h5>
            </div>

            <div class="request-input">
                <input type="text" class="underline" placeholder="  요청 사유를 입력하세요."> 
            </div>

            <hr class="hr-class">

            <button type="button" class="cancel-button">취소</button>
            <button type="button" class="send-button">전송</button>

        </div>

        <button id="popup_open_btn">모달</button>