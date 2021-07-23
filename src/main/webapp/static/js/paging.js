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
	console.log(this);
	console.log(this[0].scrollHeight);
	console.log(this[0].clientHeight);
	
	return this[0] ? this[0].scrollHeight > this[0].clientHeight : false;  
};

function scrollbar() {
	if($("#ajax").hasScrollbar()){ // 세로 스크롤바가 있을 경우 처리 
		$('thead').css('padding-right', '18px');
		console.log('padding만들기');
	} else{
		$('thead').css('padding-right', '0px');
		console.log('padding없애기');
	}
}