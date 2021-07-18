<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%> 
	  
 <nav class="menubar emp" onmouseover="content_flow()" onmouseout="content_flow2()">
        <ul>
            <a href="/emp/main">
                <li class="menu"><i class="fas fa-home"></i> <em>홈</em></li>
            </a>
            <div class="menus" onmouseleave="undo(this)">
                <a href="#">
                    <li class="menu" onmouseover="expand_sub(this)"><i class="fas fa-clock"></i> <em>출퇴근기록</em></li>
                </a>
                <ul class="submenu">
                    <a href="/emp/calendar">
                        <li><em>캘린더형보기</em></li>
                    </a>
                    <a href="#">
                        <li><em>상세기록보기</em></li>
                    </a>
                </ul>
            </div>
            <div class="menus" onmouseleave="undo(this)">
                <a href="#">
                    <li class="menu" onmouseover="expand_sub(this)"><i class="fas fa-plane"></i> <em>휴가</em></li>
                </a>
                <ul class="submenu">
                    <a href="/emp/vacation/request">
                        <li><em>휴가신청</em></li>
                    </a>
                    <a href="/emp/vacation/vcList">
                        <li><em>신청내역</em></li>
                    </a>
                </ul>
            </div>
            <div class="menus" onmouseleave="undo(this)">
                <a href="#">
                    <li class="menu" onmouseover="expand_sub(this)"><i class="fas fa-paper-plane"></i> <em>요청</em></li>
                </a>
                <ul class="submenu">
                    <a href="/emp/request/corrRequest">
                        <li><em>정정신청</em></li>
                    </a>
                    <a href="/emp/request/corrList">
                        <li><em>신청내역</em></li>
                    </a>
                </ul>
            </div>
            <a href="/emp/organization/organization">
                <li class="menu"><i class="fas fa-users"></i> <em>연락망</em></li>
            </a>
        </ul>
        <ul class="profile">
            <div class="menu-category">설정</div>
            <a href="/empProfile?emp_id=<sec:authentication property='principal.member.emp_id'/>">
                <li class="menu"><i class="fas fa-user"></i><em>프로필</em></li>
            </a>
        </ul>
    </nav>