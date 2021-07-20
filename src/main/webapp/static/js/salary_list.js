/**
 * 
 */
function getMap(){
	search = [];
	
	$('.search').each(function(){
		let s ={
			field : $(this).attr('id'),
			keyword : $(this).val()
		};
		search.push(s);
	});
	var jsonData = JSON.stringify(search);
	
	$.ajax({
		url : "searchlist",
		type:"post",
		data : {
			"search":jsonData
			},
		success : function(data){
			var html='';
			var indexer='';
			var pager ='';
			let page = data.page; //굳이 page를 ajax를 통해 가져오는 이유는... 뷰단 쿼리스트링 파라미터 정보를 자바스크립트로 가져오는 과정이 복잡함(정규식 필요) 
			let startNum = data.startNum;
			let lastPageNum = data.lastPageNum;
			var member = data.member;
			for(var i=0; i<member.length; i++){
				html += "<tr>"+
							"<td>"+member[i].org_groupname+"</td>"+
							"<td>"+member[i].emp_dept+"</td>" +
							"<td>"+member[i].emp_id+"</td>" +
							"<td>"+member[i].emp_name+"</td>" +
							"<td>"+member[i].emp_posi+"</td>" +
							"<td>"+member[i].emp_sal+"</td>" +
							"<td>"+member[i].emp_pay+"</td>" +
							"<td>"+member[i].emp_join+"</td>" +
							"<td>"+member[i].emp_resi+"</td>";
					html+="</tr>";
			}
			$("#ajax").html(html);
			
			indexer = "<div><span class='text-imp text-strong'>"+page+"</span>/ "+lastPageNum+" pages</div>";
			$("#indexer").html(indexer); 
			
			pager ="<div class='btn-container'>";
			if(startNum>1) pager += "<a href='?p="+(startNum-1) +"' class='btn btn-next'>이전</a>";
			else pager += "<span class='btn btn-prev' onclick='alert('이전 페이지가 없습니다.');'>이전</span>";
			pager +="</div>";
			
			pager +="<ul class='pages center'>";
			for(let i=0; i<5; i++){
				if(startNum+i <= lastPageNum) pager+="<li><a class='"+(page==(startNum+i)?'imp ':'') +"bold' href='?p=${startNum+i}'>${startNum+i}</a></li>";
			}
			pager +="</ul>";
			
			pager +="<div>";
			if(startNum+5<=lastPageNum) pager+="<a href='?p="+(startNum+5)+"' class='btn btn-next'>다음</a>";
			else pager += "<span class='btn btn-next' onclick='alert('다음 페이지가 없습니다.');'>다음</span>";
			pager += "</div>";
			$("#pager").html(pager); 
			
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

