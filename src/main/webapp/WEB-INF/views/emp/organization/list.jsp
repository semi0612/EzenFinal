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
         <div class="page_wrap">
               <div class="page_nation">
               <a class="arrow prev" href="?nowPage=${paging.startPage}"><i class="fas fa-angle-double-left"></i></a>
               <c:if test="${paging.startPage<=1}">
                     <a class="arrow pprev" onclick="alert('이전 페이지가 없습니다.');"><i class="fas fa-angle-left"></i></a>
               </c:if>
               <c:if test="${paging.startPage>1}">
                     <a class="arrow pprev" href="?nowPage=${paging.nowPage -1}"><i class="fas fa-angle-left"></i></a>
               </c:if>
               <c:if test="${paging.startPage != 1 }">
                  <a href="?nowPage=${paging.startPage - 1 }">&lt;</a>
               </c:if>
               
               <c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
                     <c:choose>
                     <c:when test="${p == paging.nowPage }">
                        <a class="active">${p}</a>
                     </c:when>
                     <c:when test="${p != paging.nowPage }">
                        <a href="?nowPage=${p}">${p}</a>
                     </c:when>
                     </c:choose>
               </c:forEach>
                  
                  <c:if test="${paging.startPage+5>paging.lastPage}">
                        <a class="btn btn-next" onclick="alert('다음 페이지가 없습니다.');"><i class="fas fa-angle-right"></i></a>
                  </c:if>
                  <c:if test="${paging.startPage+5<=paging.lastPage}">
                        <a class="arrow next" href="?nowPage=${paging.nowPage +1}"><i class="fas fa-angle-right"></i></a>
                  </c:if>
                  <a class="arrow nnext" href="?nowPage=${paging.lastPage}"><i class="fas fa-angle-double-right"></i></a>
                  <c:if test="${paging.endPage != paging.lastPage}">
               <a href="?nowPage=${paging.endPage+1 }">&gt;</a>
               </c:if>
               </div>
         </div>
      </div>
   </div>
</main>
</div>