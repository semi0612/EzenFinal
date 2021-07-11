<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>    
<%@ page import="java.text.SimpleDateFormat" %>
<link rel="stylesheet" href="/css/admin_main.css">
<div class="content-wrapper">
<% 
	Date nowTime = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일");
%>
	<main>
		<h2><%= sf.format(nowTime) %></h2>
		<div class="main-wrapper">
			<div class="member-count">
				<strong>총 직원수 : ${memberCount}</strong>
			</div>
			<div class="working-cards">
				<div class="working-card">
					<p class="working-title">출근</p>
					<hr class="underline">
					<p class="working-data">${gowork_count}</p>
				</div>
				
				<div class="working-card">
					<p class="working-title">미출근</p>
					<hr class="underline">
					<p class="working-data">${notwork_count}</p>
				</div>
				<div class="working-card">
					<p class="working-title">휴가</p>
					<hr class="underline">
					<p class="working-data">${holiday_count}</p>
				</div>
				
				<div class="working-card">
					<p class="working-title">지각</p>
					<hr class="underline">
					<p class="working-data">${late_count}</p>
				</div>
			</div>
		</div>
	</main>
</div>