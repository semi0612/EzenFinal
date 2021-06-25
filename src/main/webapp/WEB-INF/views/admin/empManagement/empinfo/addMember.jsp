<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/css/add_member.css">
<div class="content-wrapper">
	<main>
		<h2>직원추가</h2>
		<div class="main-wrapper">
		<form name="addMemberForm">
			<div class="page-title">
				<h2 class="team-title">
					부서
					</h2>
					&nbsp; &nbsp;
					<!--부서목록-->
					<select class="department-menu" name="department">
						<option value="none" hidden>부서목록</option>
						<optgroup label="IT본부">
							<option value="korean">IT기획팀</option>
							<option value="english">개발1팀</option>
							<option value="chinese">개발2팀</option>
						</optgroup>
						<optgroup label="경영지원 본부">
							<option value="korean">인사총무팀</option>
							<option value="english">재경팀</option>
							<option value="chinese">구매무역팀</option>
						</optgroup>

						<optgroup label="생산본부">
							<option value="korean">공정안전팀</option>
							<option value="english">공정실행팀</option>
							<option value="chinese">생산1팀</option>
							<option value="chinese">생산2팀</option>
						</optgroup>
					</select> &nbsp;
					<!--검색창-->
					<form id='searchform'>
						<div id='simpleSearch'>
							<input type='search' name='search' class='searchInput'
								placeholder='  검색'> <input type='submit' name='go'
								class='searchButton'>
						</div>
					</form>
			</div>
			<div class="add-component">
				<!--직원이미지 입력폼-->
				<div class="member-images">
					<div class="member-image">
						<i class="fas fa-user"></i>
					</div>
					<button class="addbutton-three">사진첨부</button>
				</div>
				<!--직원정보 입력폼-->
				<div class="member-data">
					<div class="member-head">
						<h4>이름</h4>
						<h4 class="right-title">직급</h4>
					</div>
					<div class="member-input">
						<input type="text" class="text-input" placeholder=" 이름 입력">
						&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
						&nbsp;&nbsp; &nbsp; <select class="select-input" name="position">
							<option value="none">사원</option>
							<option value="one">팀장</option>
							<option value="two">대리</option>
							<option value="three">부장</option>
							<option value="four">과장</option>
						</select>
					</div>

					<div class="member-head">
						<h4>직통전화</h4>
						<h4 class="right-title2">연봉</h4>
					</div>

					<div class="member-input">
						<input type="text" class="text-input" placeholder=" 070-2575-5959">
						&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
						&nbsp;&nbsp; &nbsp; <input type="text" class="text-input">
					</div>

					<div class="member-head">
						<h4>이메일로 초대</h4>
						<h4 class="right-title3">연락처로 초대</h4>
					</div>

					<div class="member-input">
						<input type="text" class="text-input"
							placeholder=" test@naver.com"> &nbsp; &nbsp;&nbsp;
						&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; <input
							type="text" class="text-input" placeholder=" 010-5959-5959">
					</div>
					<button class="invite-button">초대하기</button>
				</div>
			</div>
			</form>
		</div>
	</main>
</div>
</div>