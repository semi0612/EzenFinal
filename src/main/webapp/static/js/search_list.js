var page = 1;
var last;

$(document).ready(function () { $("#ajax").on('scroll',function() {

	if (page == last) return;
	 
	var innerHeight = $(this).innerHeight(); //tbody의 padding값 포함한 높이 (border, margin은 미포함)
	var scroll = $(this).scrollTop() + $(this).innerHeight(); //스크롤을 내린만큼의 길이 + tbody 높이 
	var height = $(this)[0].scrollHeight; //tbody 컨텐츠의 전체 길이(스크롤 전체 길이)

	if (scroll >= height) { //scroll = height 시점은 스크롤이 바닥에 닿았을 때
		page++;
		console.log("로딩중" +page);
	}
	});
});

//	console.log("innerHeight:" + innerHeight);
//	console.log("scroll(innerHeight+scrollTop) : " + scroll);
//	console.log("전체높이 : " + height);
//		console.log("끝");
function getMap(p){
	let search = $('.search');
	search = [];
	
	console.log(search);
	$('.search').each(function(){
		let s ={
			field : $(this).attr('id'),
			keyword : $(this).val()
		};
		search.push(s);
	});
	var jsonData = JSON.stringify(search);
	console.log(jsonData);
	console.log("page:" + p);
	$.ajax({
		url : "searchlist",
		type:"post",
//		dateType:'json', @ResponseBody를 담아놓았기 때문에 자동 처리
		data : {
			"search":jsonData,
			"page": p
			},
		success : function(data){
			var member = data.member;
			var cnt = data.totRows;
			last = data.lastNum;
			console.log("검색결과 : "+cnt);
			console.log("마지막페이지 : "+last);
//			$("#ajax").remove();
//			var html='<tbody id="ajax">';
			var html='';
			for(var i=0; i<member.length; i++){
				html += "<tr>"+
							"<td>"+member[i].org_groupname+"</td>"+
							"<td>"+member[i].emp_dept+"</td>" +
							"<td>"+member[i].emp_id+"</td>" +
							"<td>"+member[i].emp_name+"</td>" +
							"<td>"+member[i].emp_posi+"</td>" +
							"<td>"+member[i].emp_tel+"</td>" +
							"<td>"+member[i].emp_email+"</td>";
				if(member[i].emp_level == "ROLE_ADMIN")
					html +="<td>관리자</td>";
				if(member[i].emp_level == "ROLE_MEMBER")
					html +="<td>직원</td>";
					html+="</tr>";
			}
			$("#ajax").html(html);
			
		},
		error : function(xhr){
			console.log(xhr.status);
			console.log(xhr.responseText);
//			alert("Error code : " + xhr.status);
		}
	});
}


window.onload = function(){
    getMap(1);
}

