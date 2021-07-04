//비밀번호 일치여부 확인 및 비밀번호 입력 확인

function checkPw() {
	var pw1 = document.getElementById('pw1').value;
	var pw2 = document.getElementById('pw2').value;
	
	if(pw1 == "" || pw2 == "") {
		alert("비밀번호를 입력해주세요.");
		return false;
	} 
	
	if(pw1 != pw2) {
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	}
	
	return true;
}