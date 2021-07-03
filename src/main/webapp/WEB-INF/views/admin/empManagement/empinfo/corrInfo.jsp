<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/css/update_memberinfo.css">
<link rel="stylesheet" href="/css/component_board.css">
<link rel="stylesheet" href="/css/component_board.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<main>
		<h2>직원정보관리</h2>
		<form action="corrInfo" method="post">
		<div class="sub-tab">
			<span class="tab-group1">
				<h4>서브메뉴</h4> <span class="wrap"><button class="button-three" onclick="location.href='leaveInfo'">연차</button></span>
				<span class="wrap"><button class="button-three" onclick="location.href='salaryInfo'">급여</button></span>
			</span> <span class="tab-group2">
				<h4>직원정보</h4> <span class="wrap"><button class="button-one" onclick="location.href='addMember'">돌아가기</button></span>
				<span class="wrap"><button class="button-two" type="submit">수정완료</button></span>
			</span>
		</div>
		<table class="tbl-ex emp-tbl emp-modify">
			<summary>총 직원수 : ${cnt}</summary>
			<thead>
				<tr class="search-tr">
					<th><input type="text" class="search" placeholder="검색.."></th>
					<th><input type="text" class="search" placeholder="검색.."></th>
					<th><input type="text" class="search" placeholder="검색.."></th>
					<th><input type="text" class="search" placeholder="검색.."></th>
					<th><input type="text" class="search" placeholder="검색.."></th>
					<th><input type="text" class="search" placeholder="검색.."></th>
					<th><input type="text" class="search" placeholder="검색.."></th>
				</tr>
			<thead>
				<tr class="title-tr">
					<th>부서</th>
					<th>사번</th>
					<th>이름</th>
					<th>직급</th>
					<th>내선번호</th>
					<th>이메일</th>
					<th>액세스권한</th>
				</tr>
			</thead>
			<c:forEach var="list" items="${list}">
					<c:set var="mgr" value=""/>
					<c:set var="emp" value=""/>
					<c:if test="${list.emp_level=='ROLE_ADMIN'}">
						<c:set var="mgr" value="selected"/>
					</c:if>
					<c:if test="${list.emp_level!='ROLE_ADMIN'}">
						<c:set var="emp" value="selected"/>
					</c:if>
				<tr>
					<td><select name="emp_dept">
						<option value="none" hidden>부서목록</option>
						<c:forEach var="org" items="${orgList}"> <!-- org라는 HashMap<Key,Value> key : org_groupname, teamList -->
							<optgroup label="${org.org_groupname}"> 
								<c:forTokens var="team" items="${org.teamList}" delims="/"> <!--인사총무팀/재경팀/구매무역팀 -->
									<option value="${team}" name="emp_dept" ${team==list.emp_dept?'selected':''}>${team}</option>
								</c:forTokens>
							</optgroup>
						</c:forEach>
						</select></td>
					<td><input type="text" id="empId" name="emp_id" value="${list.emp_id}" readonly></td>
					<td><input type="text" id="ename" name="emp_name" value="${list.emp_name}"></td>
					<td>
					<c:set var="posi" value="${list.emp_posi}"/>
						<select class="select-input" id="position" name="emp_posi">
							<c:forEach var="pos" items="${posiList}">
								<option value="${pos}" ${posi==pos?'selected':''}>${pos}</option>
							</c:forEach>
						</select>
					<%-- <input type="text" id="position" value="${list.emp_posi}"> --%></td>
					<td><input type="tel" name="emp_tel" id="tel" value="${list.emp_tel}" ></td>
					<td><input type="email" name="emp_email" id="email" value="${list.emp_email}"></td>
					<td><select name="emp_level">
						<option value="ROLE_ADMIN" ${mgr}>관리자</option>
						<option value="ROLE_MEMBER" ${emp}>직원</option>							
						</select>
					</td>
				</tr>
			</c:forEach>
		</table>
		</form>
	</main>
</div>