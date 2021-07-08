<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="/css/organization.css">
<div class="content-wrapper">
<main>
	<h2>조직도</h2>
	<div class="main-wrapper org-wrapper">
		<img class="org-img" src="/images/orgimg.png" alt="조직도 이미지" />
		<div class="org-content">
			<div class="org-header">
				<div class="org-header-left">
					<div class="org-header-content org-content-one">조직</div>
					<div class="org-header-content org-content-two">본부</div>
					<div class="org-header-content org-content-two-text">${groupcount}</div>
					<div class="org-header-content org-content-two">팀</div>
					<div class="org-header-content org-content-two-text">${teamcount}</div>
					<div class="org-header-content org-content-two">총 인원</div>
					<div class="org-header-content org-content-two-text">${memberCount}</div>
					<div class="org-header-content org-content-two">기획·감사</div>
					<div class="org-header-content org-content-two-text">2</div>
				</div>
				<div class="org-header-center">
					<div class="org-center-one">간부진</div>
					<div class="org-center-two">5</div>
					<span class="org-center-two-text">명</span>
				</div>

				
			</div>
			<table class="org-table">
				<thead>
					<tr>
						<th class="th-one">소속본부</th>
						<th class="th-two">부서</th>
						<th class="th-three">대표번호</th>
						<th class="th-four">담당업무</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${orgView}" var="org">
					<tr>
						<td class="td-one">${org.org_groupname}</td>
						<td class="td-two"><a href="contacts?org_teamname=${org.org_teamname}">${org.org_teamname}</a></td>
						<td class="td-three">${org.org_teamtel}</td>
						<td class="td-four">${org.org_content}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</main>
</div>