<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
					<div class="org-header-content org-content-two-text">3</div>
					<div class="org-header-content org-content-two">팀</div>
					<div class="org-header-content org-content-two-text">13</div>
					<div class="org-header-content org-content-two">총 인원</div>
					<div class="org-header-content org-content-two-text">70</div>
					<div class="org-header-content org-content-two">기획·감사</div>
					<div class="org-header-content org-content-two-text">5</div>
				</div>
				<div class="org-header-center">
					<div class="org-center-one">간부진</div>
					<div class="org-center-two">5</div>
					<span class="org-center-two-text">명</span>
				</div>

				<!--검색창-->
				<div class="org-header-search">
					<form id='searchform'>
						<div class="org-search">
							<input type='search' name='search' class="orgInput"
								placeholder='  검색'> <input type='submit' name='go'
								class='searchButton'>
						</div>
					</form>
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
					<tr>
						<td class="td-one">IT본부</td>
						<td class="td-two"><a href="contacts">IT기획팀</a></td>
						<td class="td-three">070-3359-5847</td>
						<td class="td-four">IT기획팀입니다.</td>
					</tr>
					<tr>
						<td class="td-one">IT본부</td>
						<td class="td-two"><a href="contacts">개발1팀</a></td>
						<td class="td-three">070-3254-5844</td>
						<td class="td-four">SW개발입니다.</td>
					</tr>
					<tr>
						<td class="td-one">IT본부</td>
						<td class="td-two">개발2팀</td>
						<td class="td-three">070-3254-5900</td>
						<td class="td-four">SW개발입니다.</td>
					</tr>
					<tr>
						<td class="td-one">경영지원본부</td>
						<td class="td-two">인사총무팀</td>
						<td class="td-three">070-3349-5894</td>
						<td class="td-four">인사총무팀입니다.</td>
					</tr>
					<tr>
						<td class="td-one">생산본부</td>
						<td class="td-two">생산1팀</td>
						<td class="td-three">070-3341-5840</td>
						<td class="td-four">생산1팀입니다.</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</main>
</div>