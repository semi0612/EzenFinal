function getMap(){
	//let search = $('.search');
	//console.log(search);
	//1. 제이쿼리를 이용해 뷰단에서 id값과 입력값(val) 가져오기 
	let search = [];
	$('.search').each(function(){
		/*console.log($(this).val());
		console.log($(this).attr(('id')));*/
		let s = {
			field : $(this).attr('id'),
			keyword : $(this).val()
		};
		search.push(s);
	});
	//console.log(search);
	//2. 필요하다면 json 문자열로 변환하기 
	var jsonData = JSON.stringify(search);
	console.log(jsonData);
//	console.log(obj.member);
	//3. 컨트롤러로 넘겨주기 
	$.ajax({
		url : "byList",
		type:"post",
//		dateType:'json', @ResponseBody를 담아놓았기 때문에 자동 처리
		data : {
			"search":jsonData
			},
		success : function(list){
			console.log(list)
			var html='';
			for(var i=0; i<list.length; i++){
				if (list[i].work_comm == null){
					html += "<tr>"+
					"<td>"+list[i].work_rid+"</td>"+
					"<td>"+list[i].work_day+"</td>" +
					"<td>"+list[i].emp_name+"</td>" +
					"<td>"+list[i].emp_dept+"</td>" +
					"<td>"+list[i].work_in+"</td>" +
					"<td>"+list[i].work_out+"</td>" +
					"<td>"+list[i].workingTime+"</td>"+
					"<td></td>" +
					"<td></td>";
				} else {
					html += "<tr>"+
					"<td>"+list[i].work_rid+"</td>"+
					"<td>"+list[i].work_day+"</td>" +
					"<td>"+list[i].emp_name+"</td>" +
					"<td>"+list[i].emp_dept+"</td>" +
					"<td>"+list[i].work_in+"</td>" +
					"<td>"+list[i].work_out+"</td>" +
					"<td>"+list[i].workingTime+"</td>"+
					"<td>"+list[i].work_comm+"</td>" +
					"<td></td>";
				}
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
    getMap();
}

