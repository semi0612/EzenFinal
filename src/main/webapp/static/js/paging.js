/**
 * 
 */

$(document).ready(function() {
	$("#ajax").on('scroll', function() {
		
		if (page == last) return;
		var innerHeight = $(this).innerHeight(); // tbody의 padding값 포함한 높이(border, margin은 미포함)
		var scroll = $(this).scrollTop() + $(this).innerHeight(); // 스크롤을 내린만큼의 길이 + tbody 높이
		var height = $(this)[0].scrollHeight; // tbody 컨텐츠의 전체 길이(스크롤 전체 길이)

		if (scroll >= height) { // scroll = height 시점은 스크롤이 바닥에 닿았을 때
			page++;
			getMap(page);
		}
	});
});

$.fn.hasScrollbar = function(){
	//console.log(this);
	//console.log(this[0].scrollHeight);
	//console.log(this[0].clientHeight); clientHeight == innerHeight
	return this[0] ? this[0].scrollHeight > this[0].clientHeight : false;  
};

function scrollbar() {
	if($("#ajax").hasScrollbar()){ // 세로 스크롤바가 있을 경우 처리 
		$('thead').css('padding-right', '18px');
	} else{
		$('thead').css('padding-right', '0px');
	}
}

//정렬
$(document).ready(function(){
	$("#org_groupname, #org_teamname, #emp_id, #emp_name, #emp_posi, #emp_tel, #emp_email, #emp_level").click(function(){
	let o_ = $(this).attr('id');
	 if(orderBy == o_){
		 if(order == 'desc') {
			 order = 'asc';
			 $(this).children('img').css('transform', 'rotate(180deg)');
		 }
		 else {
			 order = 'desc';
			 $(this).children('img').css('transform', 'rotate(0deg)');
		 }
		 
	 }
	 else{
		 orderBy = o_;
		 $('.arrow').css('display','none');
		 $(this).children('img').css('transform', 'rotate(180deg)');
		 $(this).children('img').css('display', 'inline-block');
		 if(order != 'asc') order = 'asc'; //오름차순이 기본값
	 }
	 getMap(1);
	});
});