var page = 1;
var last;
var html;


function getMap(p){
	search = [];
	
	$('.search').each(function(){
			
		let s ={
			field : $(this).attr('id'),
			keyword : $(this).val(),
		};
		if(s.field=='emp_sal') s.op1 =$('#upDown').val();
		if(s.field=='emp_join') s.op2 = $('#beforeAfter').val();
			
		search.push(s);
	});
	var jsonData = JSON.stringify(search);
	
	$.ajax({
		url : "salarylist",
		type:"post",
		data : {
			"search":jsonData,
			"page": p
			},
		success : function(data){
			var member = data.member;
			var cnt = data.totRows;
			var cntRows = $('#totRows');
			last = data.lastNum;
			if(p==1) {html=''; page=1; cntRows.html('검색 결과 : ' +cnt+ '건');}
			for(var i=0; i<member.length; i++){
				html += "<tr class='chk'>"+
							"<td class='chk'><input type='checkbox' id='empCheck'></td>"+
							"<td class='gname'>"+member[i].org_groupname+"</td>"+
							"<td class='tname'>"+member[i].emp_dept+"</td>" +
							"<td class='eid'>"+member[i].emp_id+"</td>" +
							"<td class='ename'>"+member[i].emp_name+"</td>" +
							"<td class='eposi'>"+member[i].emp_posi+"</td>" +
							"<td class='esal'>"+member[i].emp_sal+"</td>" +
							"<td class='monthly'>"+member[i].emp_pay+"</td>" +
							"<td class='ejoin'>"+member[i].emp_join+"</td>" +
							"<td class='exit'>"+member[i].emp_resi+"</td>";
					html+="</tr>";
			}
			$("#ajax").html(html);
			scrollbar();
		},
		error : function(xhr){
			console.log(xhr.status);
			console.log(xhr.responseText);
		}
	});
}


window.onload = function(){
    getMap();
}




