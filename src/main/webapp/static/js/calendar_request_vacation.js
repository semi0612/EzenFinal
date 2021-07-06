let CDate = new Date();
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
    for (let i = 1; i <= 13 - thisLast.getDay(); i++) {//다음 월 날짜 구하기 13에서 빼는 이유는, 2월달력의 경우 최대 3월 13일까지 표시될 수 있음
        nextDates.push(i);
    }
    
    //선택한 날짜 달력에 체크하기 - 날짜 쪼개서 배열로 보관
    var periods = document.getElementById('vac-period').value.split(' ');
    var check = [];
    for(var i=0; i<periods.length-1; i++){
    	var period = periods[i].split('/');
    		var m = period[0];
    		var d = period[1];
    		if(m == CDate.getMonth()+1){
    			check.push(d);
    		}
    }
    
    let htmlDates = '';//날짜 정보를 html형식으로 저장할 변수 
    for (let i = 0; i < prevDates.length; i++) {//42일을 출력할 for문 
        htmlDates += `<div class="date choice-date except">${prevDates[i]}</div>`
    }
    
    for (let i = 0; i < dates.length; i++) {//42일을 출력할 for문 
    	if(dates[i]<today.getDate() &&  CDate.getMonth() == today.getMonth()|| CDate.getMonth() < today.getMonth() ){
    		htmlDates += `<div class="date choice-date except">${dates[i]}</div>`
    	}
    	else{
	        if (today.getDate() == dates[i] && today.getMonth() == CDate.getMonth() && today.getFullYear() == CDate.getFullYear()) { //만약 년도, 월, 일이 똑같은 dates[i]값이 나오면 class에 today를 추가하기 위함. 
	        			//이를 이용해서 today표시
	        			htmlDates += `<div class="date choice-date"><span class="today">${dates[i]}</span></div>`;
	        } else {
	        	let y = false;
	        	for(let j=0; j<check.length; j++){
	        		if(dates[i]==check[j]){
	        			htmlDates += `<div class="date choice-date" onclick="readDate(this)" style="background:var(--imp-color); color:white;">${dates[i]}</div>`
	        				y = true;
	        		}
	        	}
	        	if(y==false)
	        		htmlDates += `<div class="date choice-date" onclick="readDate(this)">${dates[i]}</div>`
	        	}
    		}
        }
        	
    
    for (let i = 0; i < nextDates.length; i++) {//42일을 출력할 for문 
        htmlDates += `<div class="date choice-date except">${nextDates[i]}</div>`
    }

    document.querySelector(".dates").innerHTML = htmlDates;//htmlDates를 index.html의 .dates안에 넣는 작업 
} //<i class="fas fa-exclamation-circle"></i>

function prevCal() { CDate.setMonth(CDate.getMonth() - 1); buildCalendar(); }
function nextCal() { CDate.setMonth(CDate.getMonth() + 1); buildCalendar(); }

var cnt = 0;
var pr = [];
function readDate(target){
	let cdate = (CDate.getMonth()+1)+'/'+target.innerText;
	let input = document.getElementById('vac-period');
	
	//잔여연차를 초과하여 추가 선택하려할 때
	if(cnt==document.getElementById('rest').value && !input.value.includes(cdate)){
		alert("잔여연차를 초과하셨습니다.");
	
	//잔여연차가 있을 때
	} else if(cnt<document.getElementById('rest').value){
  		
	    //선택된 날짜 한번 더 클릭하여 해제
	    if(input.value.includes(cdate)){
	        target.style.background = 'transparent';
	        target.style.color = 'var(--base-color)';
	        
	        input.value='';
	        pr.splice(pr.indexOf(cdate),1);
	    	for(let i=0; i<pr.length; i++){ input.value += (pr[i] +' ');}
	        cnt--;
	        let sCnt1 = "(" + cnt + ")";
	        input.value+= sCnt1;
	        
	    //클릭하여 선택
	    } else {
	    	target.style.background='var(--imp-color)';
	    	target.style.color = 'white';
	    	input.value='';
	    	cnt++;
	    	let sCnt2 = "(" + cnt + ")";
	    	pr.push(cdate);
	    	pr.sort((a, b) => a.split('/')[1] - b.split('/')[1]);
	    	
	    	for(let i=0; i<pr.length; i++){ input.value += (pr[i]+' ');	}
	        input.value += sCnt2;
	    }
	//잔여연차를 초과한 상황에서 선택한 날짜를 해제할 때
  	} else {
  		target.style.background = 'transparent';
        target.style.color = 'var(--base-color)';
        
        input.value='';
        pr.splice(pr.indexOf(cdate),1);
    	for(let i=0; i<pr.length; i++){ input.value += (pr[i]+' ');	}
        cnt--;
        let sCnt1 = "(" + cnt + ")";
        input.value+= sCnt1;
  	}
}

function checkEvi() {
	var imgname = document.getElementById('vac-prove').value;
	if (imgname == "") {
		alert("이미지를 첨부해주세요.");
		return false;
	}
	return true;
}

