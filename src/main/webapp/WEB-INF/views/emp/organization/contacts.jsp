<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="/css/contacts.css">
<div class="content-wrapper">
	<main>
		<h2>연락망</h2>
		<div class="main-wrapper">
			<h3 class="team-title">${param.org_teamname}</h3>
			<div class="card-container">
				<div class="main-content">

				<c:forEach items="${contacts}" var="contacts">
					<article class="component">
						<div class="contact-image">
							<img src="/images/${contacts.emp_pic}"/>
						</div>
						<!-- <img src="/images/bangul.jpg" alt="직원 이미지" /> -->
						<div class="description">
							<div class="user-title">
								<h3>${contacts.emp_name}</h3>
								<h4 class="position">${contacts.emp_posi}</h4>
							</div>
							<div class="user-description">
								<p> HMG | ${contacts.emp_dept}</p>
								<hr>
								<p>
									<i class="fas fa-envelope"></i>&nbsp; &nbsp;${contacts.emp_email}
								</p>
								<p>
									<i class="fas fa-phone-alt"></i>&nbsp; &nbsp;${contacts.emp_tel}
								</p>
							</div>
							<a href="#" class="button">채팅하기</a>
						</div>
					</article>
				</c:forEach>
				</div>
			</div>
		</div>
	</main>
</div> 