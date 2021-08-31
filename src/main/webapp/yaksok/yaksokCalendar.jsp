<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>달력 만들기</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="yaksok/css/yaksokCalendar.css" rel="stylesheet" type="text/css" />
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    
    <script>
    (function () {
        calendarMaker($("#calendarForm"), new Date());
        
    })();

    var nowDate = new Date();
    function calendarMaker(target, date) {
    	
        if (date == null || date == undefined) {
            date = new Date();
        }
        nowDate = date;
        if ($(target).length > 0) {
            var year = nowDate.getFullYear();
            var month = nowDate.getMonth() + 1;
            $(target).empty().append(assembly(year, month));
        } else {
            console.error("custom_calendar Target is empty!!!");
            return;
        }

        var thisMonth = new Date(nowDate.getFullYear(), nowDate.getMonth(), 1);
        var thisLastDay = new Date(nowDate.getFullYear(), nowDate.getMonth() + 1, 0);


        var tag = "<tr>";
        var cnt = 0;
        //빈 공백 만들어주기
        for (i = 0; i < thisMonth.getDay(); i++) {
            tag += "<td></td>";
            cnt++;
        }

        //날짜 채우기
        for (i = 1; i <= thisLastDay.getDate(); i++) {
            if (cnt % 7 == 0) { tag += "<tr>"; }

            tag += "<td><div class='dayVal'>" + i + "</div><br> <div class='dayList'></div> <br></td>";
            cnt++;
            if (cnt % 7 == 0) {
                tag += "</tr>";
            }
        }
        $(target).find("#custom_set_date").append(tag);
        calMoveEvtFn();

        function assembly(year, month) {
            var calendar_html_code =
                "<table class='custom_calendar_table' style='margin:auto'>" +
                "<colgroup>" +
                "<col style='width:180px'/>" +
                "<col style='width:180px'/>" +
                "<col style='width:180px'/>" +
                "<col style='width:180px'/>" +
                "<col style='width:180px'/>" +
                "<col style='width:180px'/>" +
                "<col style='width:180px'/>" +
                "</colgroup>" +
                "<thead class='cal_date'>" +
                "<th><button type='button' class='prev'><</button></th>" +
                "<th colspan='5'><p><span class='selectYear'>" + year + "</span>년 <span class='selectMonth'>" + month + "</span>월</p></th>" +
                "<th><button type='button' class='next'>></button></th>" +
                "</thead>" +
                "<thead  class='cal_week'>" +
                "<th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>" +
                "</thead>" +
                "<tbody id='custom_set_date'>" +
                "</tbody>" +
                "</table>" +
                "<a class='btn btn-primary' href='#yaksokCalendarAddModal' data-toggle='modal'>등록</a>";
            return calendar_html_code;
        }

        function calMoveEvtFn() {
            //전달 클릭
            $(".custom_calendar_table").on("click", ".prev", function () {
                nowDate = new Date(nowDate.getFullYear(), nowDate.getMonth() - 1, nowDate.getDate());
                calendarMaker($(target), nowDate);
            });
            //다음날 클릭
            $(".custom_calendar_table").on("click", ".next", function () {
                nowDate = new Date(nowDate.getFullYear(), nowDate.getMonth() + 1, nowDate.getDate());
                calendarMaker($(target), nowDate);
            });
          	//일자 선택 클릭
            $(".custom_calendar_table").on("click", "td", function () {
                $(".custom_calendar_table .select_day").removeClass("select_day");
                $(this).removeClass("select_day").addClass("select_day");
            });
            //버튼 클릭
            $("#addButton").click(function() {
            	var selectDay=$(".select_day .dayVal").html();
            	alert(year+"/"+month+"/"+selectDay)
            	return;
            });
            //value 테스트
          /*   $(".dayVal").click(function() {
            	alert('숫자')
            }) */
            $(".dayList").click(function() {
            	alert('문자')
            }) 
            
        }
        
        function move(){
        	for(i=1; i<=3; i++){
        		$(".dayList").append("테스트");
        		
        	}
        		
        }
        
    }
    </script>
</head>
<body>
	<div class="container-fluid">
		<br>
		<h1 class="h3 mb-2 text-gray-800">일정관리</h1><br>
			<div class="card shadow mb-4 text-center">
				<div class="card-body">
					<div class="table-responsive">
			
						<!--  -->
    					<div id="calendarForm" ></div>
    					<!--  -->
    					
    				</div>
    			</div>
    		</div>
    	</div>
    <%@ include file="/yaksok/modal/yaksokCalendarAddModal.jsp"%>
</body>
</html>