<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>
	<div id="menu">
		<ul class="navbar-nav">
			<li class="nav-item open" onclick="fix_menu()">
			<i class="fas fa-solid fa-bars" alt="메뉴고정"></i> <span class="tooltip">
					메뉴 고정/해제</span></li>
			<li class="nav-item company-name">
				<!---->
				<span> HMG </span>
			</li>
			<li class="nav-item setting" onclick="dp_menu()"><a><i
					class="fas fa-cog"></i></a>
				<ul class="dropdown-menu dropdown-menu-right show" id="drop-content">
					<li class="full-name">민지율</li>
					<li class="link"><a class="dropdown-item"><i
							class="fas fa-user-alt"></i> 계정 설정 </a></li>
					<li class="dropdown-divider"></li>
					<li class="link"><a class="dropdown-item"><i
							class="fas fa-sign-out-alt"></i> 직원 모드로 전환 </a></li>
					<li class="link"><a class="dropdown-item"><i
							class="fas fa-sign-out-alt"></i> 로그아웃 </a></li>
				</ul>
			</li>
		</ul>
	</div>
</header>