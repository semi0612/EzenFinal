<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
   prefix="sec"%>

<link rel="stylesheet" href="/css/modify_member.css">
<script src="/js/check_pw.js"></script>
<script src="/js/check_img.js"></script>
<div class="content-wrapper">
   <main>
      <h2>직원 정보변경</h2>
      <form action="infoUpdate" method="post" enctype="multipart/form-data">
         <div class="add-component">
            <!--직원이미지 입력폼-->
            <div class="member-images">
               <div class="member-image">
                  <img id="preview" src="/images/${updateProfile.emp_pic}" alt="image">
               </div>
               <input type="file" name="emp_pic" id="empPic" accept="image/*"
                  style="display: none; apperance: none; -webkit-apperance: none;">
               <label for="empPic" class="addbutton-three button-label">사진첨부</label>
            </div>

            <!--직원정보 입력폼-->
            <div class="member-data">
               <div class="member-head">
                  <h4>사번</h4>
                  <h4 class="modify-right-title">이름</h4>
               </div>
               <div class="member-input">
                  <input type="text" name="emp_id" class="text-input"
                     value="${updateProfile.emp_id}">
                  &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
                  &nbsp;&nbsp; &nbsp; <input type="text" class="text-input"
                     readonly="readonly"
                     value="${updateProfile.emp_name}">
               </div>

               <div class="member-head">
                  <h4>부서</h4>
                  <h4 class="modify-right-title">직급</h4>
               </div>

               <div class="member-input">
                  <input type="text" class="text-input" readonly="readonly"
                     value="${updateProfile.emp_dept}">
                  &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
                  &nbsp;&nbsp; &nbsp; <input type="text" class="text-input"
                     readonly="readonly"
                     value="${updateProfile.emp_posi}">
               </div>


               <div class="member-head">
                  <h4>비밀번호 입력</h4>
                  <h4 class="modify-right-title2">비밀번호 확인</h4>
               </div>

               <div class="member-input">
                  <input type="password" id="pw1" name="emp_pw" class="text-input"
                     placeholder="&nbsp;변경 할 비밀번호를 입력하세요." required /> &nbsp;
                  &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
                  &nbsp; <input type="password" id="pw2" name="emp_pw2"
                     class="text-input" placeholder="&nbsp;변경 할 비밀번호를 다시 입력하세요."
                     required />

               </div>

               <div class="member-head">
                  <h4>이메일</h4>
                  <h4 class="modify-right-title3">직통번호</h4>
               </div>

               <div class="member-input">
                  <input type="text" class="text-input" name="emp_email"
                     value="${updateProfile.emp_email}">
                  &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
                  &nbsp;&nbsp; &nbsp; 
                  <input type="text" class="text-input" name="emp_tel"
                     value="${updateProfile.emp_tel}">
               </div>
               <button class="update-button" type="submit" onclick="return checkPw()">수정하기</button>
            </div>
         </div>
      </form>
</div>
</main>
</div>