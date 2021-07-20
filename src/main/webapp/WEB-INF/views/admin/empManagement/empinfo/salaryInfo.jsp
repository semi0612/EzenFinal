<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/css/update_memberinfo.css">
<link rel="stylesheet" href="/css/component_board.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="/js/search_list.js"></script>
<div class="content-wrapper">
	<main>
		<h2>직원급여관리</h2>
		<div class="sub-tab">
			<span class="tab-group1">
				<h4>서브메뉴</h4> <span class="wrap"><button class="button-three" onclick="location.href='memberlist'">기본정보</button></span>
				<span class="wrap"><button class="button-three" onclick="location.href='leaveInfo'">연차</button></span>
			</span> <span class="tab-group2">
				<h4>급여정보</h4> <span class="wrap"><button class="button-two">일괄수정</button></span>
				<span class="wrap"><button class="button-two">수정</button></span> <span
				class="wrap"><button class="button-two">삭제</button></span>
			</span>
		</div>
		<table class="tbl-ex emp-tbl">
			<summary>총 직원수 : ${cnt}</summary>
			<thead>
				<tr class="search-tr">
					<th></th>
					<th><input type="text" id="org_groupname" class="search" placeholder="검색.."></th>
					<th><input type="text" id="org_teamname" class="search" placeholder="검색.."></th>
					<th><input type="text" id="emp_id" class="search" placeholder="검색.."></th>
					<th><input type="text" id="emp_name" class="search" placeholder="검색.."></th>
					<th><input type="text" id="emp_posi" class="search" placeholder="검색.."></th>
					<th><input type="text" id="emp_sal" class="search" placeholder="검색.."></th>
					<th><select id="upDown" class="search"><option value="up">이상</option><option value="down">이하</option></select></th>
					<th><input type="text" id="" class="search" placeholder="검색.."></th>
					<th><select id="beforeAfter" class="search"><option value="before">이전</option><option value="after">이후</option></select></th>
				</tr>
			<thead>
				<tr class="title-tr">
					<th></th>
					<th>본부</th>
					<th>부서</th>
					<th>사번</th>
					<th>이름</th>
					<th>직급</th>
					<th>연봉</th>
					<th>월급</th>
					<th>입사일</th>
					<th>퇴사일</th>
				</tr>
			</thead>
			<tbody id="ajax">
			<c:forEach var="list" items="${list}">
				<tr>
					<td><input type="checkbox" id="empCheck"></td>
					<td>${list.org_groupname}</td>
					<td>${list.emp_dept}</td>
					<td>${list.emp_id}</td>
					<td>${list.emp_name}</td>
					<td>${list.emp_posi}</td>
					<td>${list.emp_sal}</td>
					<td>${list.emp_pay}</td>
					<td>${list.emp_join}</td>
					<td>${list.emp_resi}</td>
				</tr>
			</c:forEach>
			</tbody>
			<!--<c:set var ="page" value="${(empty param.p)?1:param.p}"/>
			<div class="indexer align-right" id="indexer">
				<div>
					<span class="text-imp text-strong">${page}</span>
					/ ${lastNum} pages
				</div>
			</div>
			<div class="align-center pager" id="pager">
				<div>
					<c:if test="${startNum>1}">
						<a href="?p=${startNum-1}" class="btn btn-next">이전</a>
					</c:if>
					<c:if test="${startNum<=1}">
						<span class="btn btn-prev" onclick="alert('이전 페이지가 없습니다.');">이전</span>
					</c:if>
				</div>
				<ul class="pages center">
					<c:forEach var="i" begin="0" end="4">
						<c:if test="${(startNum+i) <= lastNum}">
							<li><a class="${(page==(startNum+i))?'imp':''} bold"	href="?p=${startNum+i}">${startNum+i}</a></li>
						</c:if>
					</c:forEach>
				</ul>
				<div>
					<c:if test="${startNum+5<=lastNum}">
						<a href="?p=${startNum+5}" class="btn btn-next">다음</a>
					</c:if>
					<c:if test="${startNum+5>lastNum}">
						<span class="btn btn-next" onclick="alert('다음 페이지가 없습니다.');">다음</span>
					</c:if>
				</div>
			</div>-->
		</table>
	</main>
</div>