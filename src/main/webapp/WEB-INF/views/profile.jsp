<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link rel="stylesheet" href="/css/profile.css">
<div class="content-wrapper">
	<main>
		<h2>프로필</h2>
		<div class="main-wrapper">


			<div class="member-component">
				<!--직원이미지 입력폼-->
				<div class="member-images">
					<!--  <div class="member-image"> -->
						<img src="/images/${profile.emp_pic}"/>
					<!--</div>   -->

				</div>
				<!--직원정보 입력폼-->
				<div class="member-data">
					<div class="member-container">
						<div class="member-name">
							<h4>이름</h4>
							<span>${profile.emp_name}</span>
						</div>
						<div class="member-id">
							<h4>사번</h4>
							<span>${profile.emp_id}</span>
						</div>
					</div>
					<div class="member-container">

						<div class="member-dept">
							<h4>부서</h4>
							<span>${profile.emp_dept}</span>

						</div>

						<div class="member-posi">
							<h4>직급</h4>
							<span>${profile.emp_posi}</span>
						</div>
					</div>
					<div class="member-container">

						<div class="member-tel">
							<h4>직통전화</h4>
							<span>${profile.emp_tel}</span>

						</div>

						<div class="member-email">
							<h4>이메일</h4>
							<span>${profile.emp_email}</span>

						</div>
					</div>
				</div>
			</div>

		</div>
	</main>
</div>


















<%-- <div class="content-wrapper">
	<main>
		<h2>프로필</h2>
		<div class="main-wrapper">
		<form name="addMemberForm">
			
			<div class="member-component">
				<!--직원이미지 입력폼-->
				<div class="member-contents">
					<div class="contents-top">
						<img src="/images/<sec:authentication property='principal.member.emp_pic' />"/>
					</div>
					
					<div class="contents-bottom">
					
						<div class="bottom-title">부서명</div>
						<div class="bottom-content"><sec:authentication property="principal.member.emp_dept" /></div>
					
						<div class="bottom-title">성명</div>
						<div class="bottom-content"><sec:authentication property="principal.member.emp_name" /></div>
					
						<div class="bottom-title">사번</div>
						<div class="bottom-content"><sec:authentication property="principal.member.emp_id" /></div>
		
						<div class="bottom-title">직급</div>
						<div class="bottom-content"><sec:authentication property="principal.member.emp_posi" /></div>
					
						<div class="bottom-title">메일주소</div>
						<div class="bottom-content"><sec:authentication property="principal.member.emp_email" /></div>
					
					
						<div class="bottom-title">입사일</div>
						<div class="bottom-content"><sec:authentication property="principal.member.emp_resi" /></div>
						<button class="modify-button" onclick="location.href='emp/modifyPassword'">수정하기</button>
					
					</div>
					
				</div>
				
				
				
				
				
			</div>
			</form>
		</div>
	</main>
</div> --%>
