<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/css/update_memberinfo.css">
<link rel="stylesheet" href="/css/component_board.css">
<link rel="stylesheet" href="/css/component_board.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<main>
		<h2>직원정보관리</h2>
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
					<c:if test="${list.emp_level=='1'}">
						<c:set var="mgr" value="selected"/>
					</c:if>
					<c:if test="${list.emp_level!='1'}">
						<c:set var="emp" value="selected"/>
					</c:if>
				<tr>
					<td><select name="emp_dept">
						<option value="none" hidden>부서목록</option>
							<optgroup label="IT본부">
							<option value="IT기획팀">IT기획팀</option>
							<option value="개발1팀">개발1팀</option>
							<option value="개발2팀">개발2팀</option>
						</optgroup>
						<optgroup label="경영지원 본부">
							<option value="인사총무팀">인사총무팀</option>
							<option value="재경팀">재경팀</option>
							<option value="구매무역팀">구매무역팀</option>
						</optgroup>

						<optgroup label="생산본부">
							<option value="공정안전팀">공정안전팀</option>
							<option value="공정실행팀">공정실행팀</option>
							<option value="생산1팀">생산1팀</option>
							<option value="생산2팀">생산2팀</option>
						</optgroup>
						</select></td>
					<td><input type="text" id="empId" value="${list.emp_id}" readonly></td>
					<td><input type="text" id="ename" value="${list.emp_name}"></td>
					<td><input type="text" id="position" value="${list.emp_posi}"></td>
					<td><input type="text" id="tel" value="${list.emp_tel}"></td>
					<td><input type="text" id="email" value="${list.emp_email}"></td>
					<td><select>
						<option value="1" ${mgr}>관리자</option>
						<option value="0" ${emp}>직원</option>							
						</select>
					</td>
				</tr>
			</c:forEach>
		</table>
	</main>
</div>