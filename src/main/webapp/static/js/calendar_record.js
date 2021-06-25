let CDate = new Date();
let today = new Date(); 

buildCalendar();

function buildCalendar(){
    let prevLast = new Date(CDate.getFullYear(), CDate.getMonth(), 0);
    let thisFirst = new Date(CDate.getFullYear(), CDate.getMonth(), 1); 
    let thisFirstDay = thisFirst.getDay();
    let thisLast = new Date(CDate.getFullYear(), CDate.getMonth() + 1, 0); 
    document.querySelector(".yearTitle").innerHTML = CDate.getFullYear() +'년';
    //상단에 년도 출력
    document.querySelector(".monthTitle").innerHTML = CDate.getMonth() + 1 +'월';
    //상단에 월 출력 
    let days = [];
    let emp = ['민지율', '박예슬', '이정연', '최샘이'];
    //현재 월 달력에 쓰일 날짜를 모을 배열 
    for(let i = 0; i < thisLast.getDate(); i++){//이번 월 날짜 구하기 
        switch((thisFirstDay+i)%7){
            case 0: days.push('일'); break;
            case 1: days.push('월'); break;
            case 2: days.push('화'); break;
            case 3: days.push('수'); break;
            case 4: days.push('목'); break;
            case 5: days.push('금'); break;
            case 6: days.push('토'); break;
        }
    } 
    let htmlDates = '';//날짜 정보를 html형식으로 저장할 변수
    htmlDates += `<thead><tr class="dates-admin"><th></th>`;
    for(let i = 0; i < days.length; i++){
        htmlDates += `<th>${i+1}/${days[i]}</th>`;
    }
    htmlDates += `</thead></tr><tbody>`;
    for(let j=0; j<emp.length; j++){
        htmlDates += `<tr><th class="emps">${emp[j]}</th>`; //직원이름
        for(let i=0; i<days.length; i++){ //출퇴근기록넣기
            if(days[i]!='일' && days[i]!='토'){
                htmlDates += `<td><div class="clock-record" >`;
                if(i==16){
                    htmlDates +=`<div class="clock in"> 8:58 </div>
                    <i id="msg msg-admin" class="fas fa-exclamation-circle">
                    <span class="tooltip record admin-tooltip"> 퇴근누락</span></i></td></div>`;
                }
                else{
                    htmlDates += `<div class="clock in">8:58</div><div class="clock out">18:05</div></div ></td>`;
                }
            }
            else
                htmlDates += `<td></td>`;
        }
        htmlDates += `</tr>`;
    }
        htmlDates += `</tbody>`;
    htmlDates += `<tfoot><tr><th class="sum">합계</th>`;
    for(let i=0; i<days.length; i++){
        if (days[i] != '일' && days[i] != '토')
            htmlDates += `<td>4</td>`;
        else
            htmlDates += `<td></td>`;
    }
    htmlDates += `</tr></tfoot>`;
    document.querySelector(".record-calendar").innerHTML = htmlDates;//htmlDates를 index.html의 .dates안에 넣는 작업 
}

function prevCal(){ CDate.setMonth(CDate.getMonth()-1); buildCalendar(); } 
function nextCal(){ CDate.setMonth(CDate.getMonth()+1); buildCalendar(); }

