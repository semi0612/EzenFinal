/**
 * 
 */
//var keys= [];
function getMap(){
	let search = $('.search');
//	let obj = {};
//	obj.search = [];
	search = [];
//	let fields = ['org_groupname','org_teamname','emp_id','emp_name','emp_posi','emp_tel','emp_email','emp_level'];
//	let keys = [];
	
	console.log(search);
	$('.search').each(function(){
		/*console.log($(this).val());
		console.log($(this).attr(('id')));*/
		let s ={
			field : $(this).attr('id'),
			keyword : $(this).val()
		};
		search.push(s);
	});
	var jsonData = JSON.stringify(search);
	console.log(jsonData);
//	console.log(obj.member);
//	obj.keys = keys;
	
	$.ajax({
		url : "searchlist",
		type:"post",
//		dateType:'json', @ResponseBody를 담아놓았기 때문에 자동 처리
		data : {
			"search":jsonData
			},
		success : function(member){
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
//			alert("Error code : " + xhr.status);
		}
	});
}



window.onload = function(){
    getMap();
}

