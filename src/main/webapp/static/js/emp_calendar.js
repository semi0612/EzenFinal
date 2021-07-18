/**
 * 
 */
let CDate = new Date(); //'2021-07-10'
let today = new Date(); 

buildCalendar();


function buildCalendar() {
    let prevLast = new Date(CDate.getFullYear(), CDate.getMonth(), 0);
    let thisFirst = new Date(CDate.getFullYear(), CDate.getMonth(), 1);
    let thisLast = new Date(CDate.getFullYear(), CDate.getMonth() + 1, 0);
    document.querySelector(".yearTitle").innerHTML = CDate.getFullYear() + '년';
    //상단에 년도 출력
    document.querySelector(".monthTitle").innerHTML = CDate.getMonth() + 1 + '월';
    //상단에 월 출력 
    let dates = [];
    let prevDates = [];
    let nextDates = [];
    //현재 월 달력에 쓰일 날짜를 모을 배열 
    if (thisFirst.getDay() != 0) {//만약 이번 월의 첫째날이 일요일이 아니라면 
        for (let i = 0; i < thisFirst.getDay(); i++) {//일요일부터 이번 월의 요일까지 날짜를 구하기 위한 for문 
            prevDates.unshift(prevLast.getDate() - i);//이전 월의 마지막 날짜부터 1씩 빼가며 unshift(배열 앞에 값을 넣습니다.) 
        }
    }
    for (let i = 1; i <= thisLast.getDate(); i++) {//이번 월 날짜 구하기 
        dates.push(i);
    }
    if(prevDates.length + dates.length <=35)
       for (let i = 1; i <= 13 - thisLast.getDay(); i++) {//다음 월 날짜 구하기 13에서 빼는 이유는, 2월달력의 경우 최대 3월 13일까지 표시될 수 있음
           nextDates.push(i);
       }
    else
       for (let i = 1; i <= 6 - thisLast.getDay(); i++) {//다음 월 날짜 구하기 13에서 빼는 이유는, 2월달력의 경우 최대 3월 13일까지 표시될 수 있음
          nextDates.push(i);
       }
    
    // 데이터 뽑아오기
    //1. 파라미터로 넘겨줄 데이터를 변수에 담는다.
    // 파라미터1 emp_id : 컨트롤러에서 세션객체를 통해 얻을 예정ㄴ
    // 파라미터2 연-월'2021-07'//
    var month = (CDate.getMonth() +1)+'';
    var year = CDate.getFullYear();
    if(month.length == 1) month ='0'+month;
    var param = year+'-'+month;
    //2.변수를 json 문자열로 변환한다.
//    param = JSON.stringify(param); -> 이미 문자라서 하면 안됨다 아이고//{2021-07}
    
    //3.ajax
    $.ajax({
    	url : "/emp/calendar",
    	type:"post",
    	data : {
    		"dates":param
    		},
    	success : function(data){
    	    let htmlDates = '';//날짜 정보를 html형식으로 저장할 변수 
    	    for (var i = 0; i< prevDates.length; i++) { //지난달의 날짜를 출력 
    	        htmlDates += "<div class='date choice-date except'>" + prevDates[i]+"</div>";
    	    }
    	    
    	    let j=0;
    	    for (var i = 0; i < dates.length; i++) {//이번달의 날짜를 출력
    	    	//j는 0으로 시작해 data를 꺼내는 작업을 마칠때마다 1씩 증가한다. 데이터가 존재하지 않는 일자에도 html태그를 만들어줘야 하기 때문에, 실제 데이터의 크기가 j값보다 클때까지만(즉 데이터가 존재할때까지) data[j]가 가능하다. 
    	    	//즉 넘어온 데이터가 7열까지 존재하는데, data[8]을 꺼낼수는 없기 때문에 (에러 발생) 이때부터는 else문으로 처리한다.
    	    	if(data.length >j){  
	    	    	//데이터가 존재한다면 해당 데이터의 일자를 알아낸다.
	    	    	let day = data[j].work_day.substr(8,2);
	    	    	if(day.substr(0,1)=='0') day=day.substr(1,2);
	    	    	CDate.setDate(day);
	    	    	console.log(CDate);
	    	    	//데이터의 일자가 현재 달력에서 위치한 일자(배열에서 꺼낸 일자)와 같을때
	    	    	if(day == dates[i]){
	    	    	//과거 기록
	    	    		if( (dates[i]<today.getDate() &&  CDate.getMonth() == today.getMonth() && CDate.getFullYear() == today.getFullYear()) //이번달 어제까지
		    	    		   || (CDate.getMonth() < today.getMonth() && CDate.getFullYear() == today.getFullYear()) //지난달들
		    	    		   || (CDate.getFullYear() <today.getFullYear()) ){ //지난해
		    	          htmlDates += "<div class='date choice-date'><span>"+dates[i]+"</span>"; //일단 날짜를 달력에 표시
		    	          
			    	          if(data[j].work_in!='00:00:00'){ //출근 기록이 존재할 때 출퇴근 데이터 입력
			    	        	  //지각여부에 따른 css변화+경고아이콘
			    	        	  if(data[j].work_late == '1')
			    	        		  htmlDates += "<i class='fas fa-exclamation-circle warning'></i><div class='clock-record'><div class='clock in warning'>"+data[j].work_in+"</div><div class='clock out'>"+data[j].work_out+"</div>";
			    	        	  else htmlDates +="<div class='clock-record'><div class='clock in'>"+data[j].work_in+"</div><div class='clock out'>"+data[j].work_out+"</div>";
			    	          } else if(data[j].holi_code !='' && data[j].work_in=='00:00:00'){ //휴가일때
			    	        	  htmlDates +=	"<div class='clock-record'>"+data[j].holi_code+"</div>";
			    	          } else { //검토해야함
			    	        	  htmlDates +=	"<div class='clock-record'></div>";
		    	    		  }
			    	     htmlDates += "</div>";    
		    	       }
		    	     //오늘이라면
		    	       else if (today.getDate() == dates[i] && today.getMonth() == CDate.getMonth() && today.getFullYear() == CDate.getFullYear()) { //만약 년도, 월, 일이 똑같은 dates[i]값이 나오면 class에 today를 추가하기 위함. 
		    	                    //이를 이용해서 today표시
		    	        	   htmlDates += "<div class='date choice-date'><span class='today'>"+dates[i]+"</span>";
		    	        	   if(data[j].work_in!='00:00:00' && data[j].work_out !='00:00:00'){ //퇴근 후 
		    	                    htmlDates +="<div class='clock-record'><div class='clock in'>"+data[j].work_in+"</div><div class='clock out'>"+data[j].work_out+"</div></div>";
		    	        	   }
		    	        	   else if(data[j].work_in!='00:00:00' && data[j].work_out =='00:00:00'){ //근무 중
		    	        		   htmlDates +=	"<div class='clock-record'><div class='clock in'>"+data[j].work_in+"</div><div class='clock out'></div></div>";
		    	        	   }
		    	        	   else { //아직 미출근
		    	        	   }
		    	           //오늘 이후라면
		    	        } else {
		    	                htmlDates += "<div class='date choice-date except'>"+dates[i]+"</div>";
		    	        }
			    	    htmlDates += "</div>";
			    	    j++;
	    	    	} else { //무단결근 혹은 주말
	    	    		if(CDate.getDay()=='0' || CDate.getDay() == '1'){
		    	    		htmlDates += "<div class='date choice-date'><span>"+dates[i]+"</span></div>";
		    	    	} else if(data[j].holi_code =='' && data[j].work_in=='00:00:00' && (CDate.getDay()!=0 && CDate.getDay()!=6)){ //무단 결근
		    	    		htmlDates +="<div class='clock-record warning'>무단 결근</div>";
	    	        	} else {
	    	        		htmlDates += "<div class='date choice-date'><span>"+dates[i]+"</span></div>";
    	        	  }
	    	    	}
	    	    //데이터가 존재하지 않는다면
	    	    } else{
	    	    	CDate.setDate(dates[i]);
	    	    	if(CDate.getDay()=='0' || CDate.getDay() == '1'){
	    	    		htmlDates += "<div class='date choice-date'><span>"+dates[i]+"</span></div>";
	    	    	} else if(dates[i] < today.getDate() && !(CDate.getDay()=='0' || CDate.getDay()=='6' )){ //무단 결근
	    	    		htmlDates +="<div class='date choice-date'><span>"+dates[i]+"</span><i class='fas fa-exclamation-circle warning'></i><div class='warning' style='text-align:center'>무단 결근</div></div>";
    	        	} else {
    	        		htmlDates += "<div class='date choice-date'><span>"+dates[i]+"</span></div>";
    	        	}
	    	    }
    	    }
       
    	    for (var i = 0; i < nextDates.length; i++) {//42일을 출력할 for문 
    	        htmlDates += "<div class='date choice-date except'>"+nextDates[i]+"</div>";
    	    }
    	  //<i class='fas fa-exclamation-circle'></i>
    	    document.querySelector(".dates").innerHTML = htmlDates;//htmlDates를 index.html의 .dates안에 넣는 작업 
    	},
    	error : function(xhr){
    		console.log(xhr.status);
    	}
    });
}
    
    
    //선택한 날짜 달력에 체크하기 - 날짜 쪼개서 배열로 보관
    /*var periods = document.getElementById('vac-period').value;
    let dindex = periods.indexOf('(');
    periods = periods.substr(0, dindex-1).split(' / ');
    var check = [];
    for(var i=0; i<periods.length; i++){
       var period = periods[i].split('-');
          let y = period[0]
          let m = period[1];
          let d = period[2];
          if(m == CDate.getMonth()+1){
             check.push(d);
          }
    }*/
/*    
    let htmlDates = '';//날짜 정보를 html형식으로 저장할 변수 
    for (let i = 0; i < prevDates.length; i++) {//42일을 출력할 for문 
        htmlDates += "<div class='date choice-date except'>${prevDates[i]}</div>"
    }
    
    for (let i = 0; i < dates.length; i++) {//42일을 출력할 for문 
       이번달 오늘 이전이거나 과거일때(이번 해 이전달들 혹은 지난해들)
       if(dates[i]<today.getDate() &&  CDate.getMonth() == today.getMonth() && CDate.getFullYear() <=today.getFullYear()|| CDate.getMonth() < today.getMonth() && CDate.getFullYear() <=today.getFullYear() ){
          htmlDates += "<div class='date choice-date'><span>${dates[i]}</span>";
          //for문 추가
//          if(data.work_in!='00:00:00')
          htmlDates +=	"<div class='clock-record'><div class='clock in'>8:58</div><div class='clock out'>20:25</div></div>"
//          else
        htmlDates += "</div>";
       }
       else{//오늘이라면
           if (today.getDate() == dates[i] && today.getMonth() == CDate.getMonth() && today.getFullYear() == CDate.getFullYear()) { //만약 년도, 월, 일이 똑같은 dates[i]값이 나오면 class에 today를 추가하기 위함. 
                    //이를 이용해서 today표시
                    htmlDates += "<div class='date choice-date'><span class='today'>${dates[i]}</span>";
                    htmlDates +=	"<div class='clock-record'><div class='clock in'>8:58</div><div class='clock out'>16:40</div></div>"
//          else
                    htmlDates += "</div>";
           //오늘 이후라면
           } else {
                 htmlDates += "<div class='date choice-date except'>${dates[i]}</div>"
          }
        }
    }
          
    for (let i = 0; i < nextDates.length; i++) {//42일을 출력할 for문 
        htmlDates += "<div class='date choice-date except'>${nextDates[i]}</div>"
    }

    document.querySelector(".dates").innerHTML = htmlDates;//htmlDates를 index.html의 .dates안에 넣는 작업 
} //<i class='fas fa-exclamation-circle'></i>
*/
function prevCal(){ CDate.setDate(1); CDate.setMonth(CDate.getMonth()-1); buildCalendar(); } 
function nextCal(){ CDate.setDate(1); CDate.setMonth(CDate.getMonth()+1); buildCalendar(); }
