var page = 1;
var last;
var html;
// 스크롤 제어
$(document).ready(function() {
	$("#ajax").on('scroll', function() {
		if (page == last)
			return;

		var innerHeight = $(this).innerHeight(); // tbody의 padding값 포함한 높이 // (border, margin은 미포함)
		var scroll = $(this).scrollTop() + $(this).innerHeight(); //스크롤을 내린만큼의 길이 + tbody 높이
		var height = $(this)[0].scrollHeight; // tbody 컨텐츠의 전체 길이(스크롤 전체 길이)

		// 컨텐츠 길이가 스크롤보다 짧으면 아래 if 가 실행되지 않는다
		// +1 해준것도, 해주지 않으면 height가 scroll보다 길어서 제대로 작동 안되는 문제가 있어 해준 것
		if (scroll+1 >= height) { // scroll = height 시점은 스크롤이 바닥에 닿았을 때
			page++;
			getMap(page);

		}
	});
});


function getMap(p) {
	 
	// 1. 제이쿼리를 이용해 뷰단에서 id값과 입력값(val) 가져오기
	let search = [];
	$('.search').each(function() {
		let s = {
			field : $(this).attr('id'),
			keyword : $(this).val()
		};
		search.push(s);
	});
	// 2. 필요하다면 json 문자열로 변환하기
	var jsonData = JSON.stringify(search);
	console.log(jsonData);
	
	
	// 3. 컨트롤러로 넘겨주기
	$.ajax({
		url : "/admin/byList",
		type : "post",
		// dateType:'json', @ResponseBody를 담아놓았기 때문에 자동 처리
		data : {
			"search" : jsonData,
			"page" : p
		},
		success : function(data) {
			var list = data.member;
			var cnt = data.totRows;
			var cntRows = $('#totRows');
			last = data.lastNum;
	
			if(p==1) {html=''; page=1; cntRows.html('검색 결과 : ' +cnt+ '건');}
			for (var i = 0; i < list.length; i++) {
				if (list[i].work_comm == null) {
					html += "<tr>"
							+ "<td class='NO'>" + list[i].work_rid + "</td>"
							+ "<td class='DATE'>" + list[i].work_day + "</td>"
							+ "<td class='ENAME'>" + list[i].emp_name + "</td>"
							+ "<td class='TNAME'>" + list[i].emp_dept + "</td>"
							+ "<td class='INTIME'>" + list[i].work_in + "</td>"
							+ "<td class='ENDTIME'>" + list[i].work_out + "</td>"
							+ "<td class='TOTIME'>" + list[i].workingTime + "</td>"
							+ "<td class='COMM'></td>"
							+ "<td class='REQUEST'></td>";
				} else {
					html += "<tr>"
						+ "<td class='NO'>" + list[i].work_rid + "</td>"
						+ "<td class='DATE'>" + list[i].work_day + "</td>"
						+ "<td class='ENAME'>" + list[i].emp_name + "</td>"
						+ "<td class='TNAME'>" + list[i].emp_dept + "</td>"
						+ "<td class='INTIME'>" + list[i].work_in + "</td>"
						+ "<td class='ENDTIME'>" + list[i].work_out + "</td>"
						+ "<td class='TOTIME'>" + list[i].workingTime + "</td>"
						+ "<td class='COMM'>" + list[i].work_comm + "</td>"
						+ "<td class='REQUEST'></td>";

				}
			}
			$("#ajax").html(html);
		},
		error : function(xhr) {
			console.log(xhr.status);
			console.log(xhr.responseText);
			// alert("Error code : " + xhr.status);
		}
	});

}


// 가장 처음 실행했을 때(js가 불러졌을 때) 화면에 뿌려주는 역할
window.onload = function() {
	getMap();
}
