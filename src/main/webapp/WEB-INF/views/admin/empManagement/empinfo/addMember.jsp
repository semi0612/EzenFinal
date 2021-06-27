<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/css/add_member.css">
<script src="/js/check_img.js"></script>
<script src="/js/check_dept.js"></script>
<div class="content-wrapper">
	<main>
		<h2>직원추가</h2>
		<div class="main-wrapper">
		<form action="addMember" method="post" enctype="multipart/form-data">
			<div class="page-title">
				<h4 class="team-title">부서</h4>
				&nbsp; &nbsp;
				<!--부서목록-->
				<select class="department-menu" name="emp_dept" id="dept">
					<option value="none" hidden>부서목록</option>
					<optgroup label="IT본부">
						<option value="strategy">IT기획팀</option>
						<option value="development">개발1팀</option>
						<option value="development2">개발2팀</option>
					</optgroup>

					<optgroup label="경영지원 본부">
						<option value="HR">인사총무팀</option>
						<option value="finance">재경팀</option>
						<option value="purchasement">구매무역팀</option>
					</optgroup>

					<optgroup label="생산본부">
						<option value="safety">공정안전팀</option>
						<option value="process">공정실행팀</option>
						<option value="production1">생산1팀</option>
						<option value="production2">생산2팀</option>
					</optgroup>
				</select> &nbsp;
				<!--검색창-->
				<!-- <form id='searchform'> -->
					<div id='simpleSearch'>
						<input type='search' name='search' class='searchInput' placeholder='  검색'>
						<input type='button' name='go' class='searchButton'>
					</div>
				<!-- </form> -->
			</div>
			<div class="add-component">
				<!--직원이미지 입력폼-->
				<div class="member-images">
					<div class="member-image">
					 <img id="preview" src="/images/thumbnail.png" alt="image">
						<!-- <i class="fas fa-user"></i> -->
					</div>
					<input type="file" name="emp_pic" id="empPic" accept="image/*" style="display:none; apperance: none; -webkit-apperance: none;">
					<label for="empPic" class="addbutton-three button-label">사진첨부</label>
				</div>
				<!--직원정보 입력폼-->
				<div class="member-data">
					<span class="label-connect"><label for="empName"><h4>이름</h4></label><input	type="text" id="empName" name="emp_name" required></span>
					<span class="label-connect"><label for="empId"><h4>사번</h4></label><input type="text" id="empId" name="emp_id" required></span> 
					<span class="label-connect c2"> <span class="label-connect2"><input	type="checkbox" id="empLevel" name="emp_level" value="1">
					<label for="empLevel">관리</label></span> <label for="empPosition"><h4>직급</h4></label>
						<select class="select-input" id="empPosition" name="emp_posi">
							<option value="사원">사원</option>
							<option value="주임">주임</option>
							<option value="대리">대리</option>
							<option value="과장">과장</option>
							<option value="팀장">팀장</option>
							<option value="부장">부장</option>
					</select>
					</span> <span class="label-connect c2"><label for="empSal"><h4>연봉</h4></label><input type="text" id="empSal" name="emp_sal"></span>
					<span class="label-connect"><label for="totalAnnday"><h4>총연차</h4></label><input type="text" id="totalAnnday" name="total_annday"></span>
					<span class="label-connect"><label for="empTel"><h4>직통전화</h4></label><input type="tel" id="empTel" name="emp_tel"></span> 
					<span class="label-connect"><label for="empEmail"><h4>이메일로 초대</h4></label><input type="email" id="empEmail" name="emp_email" placeholder=" test@naver.com" required></span>
					 <span class="label-connect"><label for="empPhone"><h4>연락처로 초대</h4></label><input type="tel" id="empPhone" name="emp_phone" placeholder=" 010-2579-2252"></span>
					<button class="invite-button" type="submit" onclick="return checkImg()" name="직원추가">초대하기</button>
				</div>
			</div>
			</form>
		</div>
	</main>
</div>