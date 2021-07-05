/**
 * 
 */
$(function () {
            $('#demo').daterangepicker({
                "locale": {
                    "format": "YYYY-MM-DD",
                    "separator": " ~ ",
                    "applyLabel": "확인",
                    "cancelLabel": "취소",
                    "fromLabel": "From",
                    "toLabel": "To",
                    "customRangeLabel": "Custom",
                    "weekLabel": "W",
                    "daysOfWeek": ["월", "화", "수", "목", "금", "토", "일"],
                    "monthNames": ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
                    "firstDay": 1
                },
                "startDate": "2021-01-01",
                "endDate": "2020-01-01",
                "drops": "down"
            }, function (start, end, label) {
                console.log('New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')');
            });
        });

$(function() {

  $('input[name="datefilter"]').daterangepicker({
      autoUpdateInput: false,
      locale: {
          cancelLabel: 'Clear'
      }
  });

  $('input[name="datefilter"]').on('apply.daterangepicker', function(ev, picker) {
      $(this).val(picker.startDate.format('MM/DD/YYYY') + ' - ' + picker.endDate.format('MM/DD/YYYY'));
  });

  $('input[name="datefilter"]').on('cancel.daterangepicker', function(ev, picker) {
      $(this).val('');
  });

});

/*<script src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css">
*/
/*<link rel="stylesheet" href="//code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
	<script src="//code.jquery.com/jquery-1.9.1.js"></script>
	<script src="//code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
	<script>*/
	var holidays = {
	  "0101":{type:0, title:"신정", year:""},
	  "0301":{type:0, title:"삼일절", year:""},
	  "0505":{type:0, title:"어린이날", year:""},
	  "0606":{type:0, title:"현충일", year:""},
	  "0815":{type:0, title:"광복절", year:""},
	  "1003":{type:0, title:"개천절", year:""},
	  "1009":{type:0, title:"한글날", year:""},
	  "1225":{type:0, title:"크리스마스", year:""},

	  "0209":{type:0, title:"설날", year:"2013"},
	  "0210":{type:0, title:"설날", year:"2013"},
	  "0211":{type:0, title:"설날", year:"2013"},
	  "0918":{type:0, title:"추석", year:"2013"},
	  "0919":{type:0, title:"추석", year:"2013"},
	  "0920":{type:0, title:"추석", year:"2013"},
	  "0517":{type:0, title:"석가탄신일", year:"2013"}
	};

	jQuery(function($){
	   $.datepicker.regional['ko'] = {
	      closeText: '닫기',
	      prevText: '이전달',
	      nextText: '다음달',
	      currentText: '오늘',
	      monthNames: ['1월(JAN)','2월(FEB)','3월(MAR)','4월(APR)','5월(MAY)','6월(JUN)',
	      '7월(JUL)','8월(AUG)','9월(SEP)','10월(OCT)','11월(NOV)','12월(DEC)'],
	      monthNamesShort: ['1월','2월','3월','4월','5월','6월',
	      '7월','8월','9월','10월','11월','12월'],
	      dayNames: ['일','월','화','수','목','금','토'],
	      dayNamesShort: ['일','월','화','수','목','금','토'],
	      dayNamesMin: ['일','월','화','수','목','금','토'],
	      weekHeader: 'Wk',
	      dateFormat: 'yy-mm-dd',
	      firstDay: 0,
	      isRTL: false,
	      showMonthAfterYear: true,
	      yearSuffix: ''
	   };
	   $.datepicker.setDefaults($.datepicker.regional['ko']);

	   $('#booking_date').datepicker({
	      showOn: 'both',
	      buttonImage: '&amp;lt;?=$g4[path]?&amp;gt;/img/calendar.gif',
	      buttonImageOnly: true,
	      buttonText: "달력",
	      changeMonth: true,
	      changeYear: true,
	      showButtonPanel: true,
	      yearRange: 'c-99:c+99',
	      minDate: '+1d',
	      beforeShowDay: function(day) {
	         var result;
	         // 포맷에 대해선 다음 참조(http://docs.jquery.com/UI/Datepicker/formatDate)
	         var holiday = holidays[$.datepicker.formatDate("mmdd",day )];
	         var thisYear = $.datepicker.formatDate("yy", day);

	         // exist holiday?
	         if (holiday) {
	         if(thisYear == holiday.year || holiday.year == "") {
	            result =  [false, "date-holiday", holiday.title];
	         }
	         }

	         if(!result) {
	         switch (day.getDay()) {
	            case 0: // is sunday?
	               result = [false, "date-sunday"];
	               break;
	            case 6: // is saturday?
	               result = [true, "date-saturday"];
	               break;
	            default:
	               result = [true, ""];
	               break;
	         }
	         }

	         return result;
	      }
	   });
	});
/*	</script>*/