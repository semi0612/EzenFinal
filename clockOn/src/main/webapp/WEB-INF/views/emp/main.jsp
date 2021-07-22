<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<%@ page import="java.text.SimpleDateFormat" %>
<%-- <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%> --%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/css/emp_main.css">
<div class="content-wrapper">

<% 
	Date nowTime = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일");
	Calendar now = Calendar.getInstance();
	int month = now.get(Calendar.MONTH) + 1;
	int year = now.get(Calendar.YEAR);
%>

	<main>
		<h2><%= sf.format(nowTime) %></h2>
		<div class="main-wrapper">
			<h3 class="commute-title">출·퇴근 요청</h3>
			<table>
			<tr>
			<td>
			<c:choose>
				<c:when	test="${work_day==null}">
					<form action="/emp/hiSuccess?emp_id=${id}" method="post" class="hiSuccess-form">
						<button class="hi-button" id="hi" type="submit">출&nbsp;근</button>
					</form>
				</c:when>
				<c:when test="${work_day!=null}">
					<button type="button" id="attendFail" class="hi-button">출&nbsp;근</button>
				</c:when>				
			</c:choose>
			</td>
			<td>
				<form action="/emp/byeSuccess?emp_id=${id}" method="post" class="byeSuccess-form">
					<button class="bye-button" id="bye" type="submit">퇴&nbsp;근</button>
				</form>
			</td>
			</tr>
			</table>
			  
			<h3 class="work-title">나의 근로 통계</h3>
			<table class="tbl-work">
                    <tr>
                        <th>기간</th>
                        <th>근무일수</th>
                        <th>지각일수</th>
                        <th>결근일수</th>
                        <th>휴무일수</th>
                        <th>총 근무시간</th>
                    </tr>
                    <tr>
                    	<td><%= month+"월" %></td>
                        <td>${thisMonthCount}일</td>
                        <td>${thisMonthLate}일</td>
                        <td>${thisMonthAbsent}일</td>
                        <td>${thisMonthHoli}일</td>
                        <td>${thisMonthTime}시간</td>   
                    </tr>
                    <tr>
               			<td><%= year+"년" %></td>
                        <td>${thisYearCount}일</td>
                        <td>${thisYearLate}일</td>
                        <td>${thisYearAbsent}일</td>
                        <td>${thisYearHoli}일</td>
                        <td>${thisYearTime}시간</td>  
                    </tr>
                    
                </table>
                <h3 class="vacation-title">나의 휴가 통계</h3>
                <table class="tbl-vacation">
                    <tr>
                        <th>종류</th>
                        <th>총</th>
                        <th>사용</th>
                        <th>잔여</th>
                        <th>비고</th>
                    </tr>
                    
                    <tr>
                        <td>연차</td>
                        <td>${annday.total_annday}</td>
                        <td>${annday.annday_used}</td>
                        <td>${annday.annday_rest}</td>
                        <td></td>  
                    </tr>
                </table>
		</div>
	</main>
</div>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
$('#hi').on("click",function(){
	// swal("체크되었습니다", "좋은 하루 보내세요✨✨", "success")
	alert("좋은 하루 보내세요")
});
 

$('#bye').on("click",function(){
	alert("수고하셨습니다")
})

$('#attendFail').on("click",function(){
	alert("이미 처리된 요청입니다")
})
</script>
