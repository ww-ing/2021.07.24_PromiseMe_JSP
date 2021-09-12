package yaksok.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import yaksok.model.YaksokDAOMyBatis;

public class YaksokStatisticsAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		
		String yidx=req.getParameter("yidx");
		req.setAttribute("yidx", yidx);
		System.out.println("yidx="+yidx);
		
		YaksokDAOMyBatis dao=new YaksokDAOMyBatis();
		
		//----------해당 월의 예약 통계 화면
		//1. 데이터가 들어있는 연도 뽑아주기
		List<String> yearList = dao.getAllYaksokReserveYearList(yidx);
		req.setAttribute("yearList", yearList);
		
		//2. 월 데이터의 선택된 year값 받아오기
		String month_selectYear=req.getParameter("month_selectYear");
		System.out.println("month_selectYear1="+month_selectYear);
	
		if(month_selectYear==null||month_selectYear.trim().isEmpty()) {
			month_selectYear=yearList.get(0);
			System.out.println("month_selectYear2="+month_selectYear);
			
		}
		req.setAttribute("month_selectYear", month_selectYear);
		
		//3. 데이터가 들어있는 월 뽑아주기
		List<String> monthList = dao.getAllYaksokReserveMonthList(yidx,month_selectYear);
		System.out.println("monthList="+monthList);
		req.setAttribute("monthList", monthList);
		
		
		//4. 월 데이터의 선택된 month값 받아오기
		String month_selectMonth=req.getParameter("month_selectMonth");
		System.out.println("month_selectMonth1="+month_selectMonth);
		
		if(month_selectMonth==null||month_selectMonth.trim().isEmpty()) {
			month_selectMonth=monthList.get(0);
			System.out.println("month_selectMonth2="+month_selectMonth);
			
		}
		req.setAttribute("month_selectMonth", month_selectMonth);
		
		
		//----------해당 연도의 예약 통계 화면
		//1. 선택한 연도 받아오기
		String year_selectYear=req.getParameter("year_selectYear");
		System.out.println("year_selectYear1="+year_selectYear);
		
		if(year_selectYear==null||year_selectYear.trim().isEmpty()) {
			year_selectYear=yearList.get(0);
			System.out.println("year_selectYear2="+year_selectYear);
			
		}
		req.setAttribute("year_selectYear", year_selectYear);
		

		//----------해당 월의 예약 통계 데이터
		
		//선택한 연 월 을 합친 문자열
		String year_month_data=month_selectYear+"/"+month_selectMonth+"/";
		
		//선택한 월의 마지막 day값 구하기
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(month_selectYear), Integer.parseInt(month_selectMonth)-1, 1);
        System.out.println("해당 월의 마지막 day="+cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        
        
		String month_last_day=Integer.toString(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		
//		List<String> monthData = 
//				dao.selectYaksokReserveMonthData(yidx,year_month_data,month_last_day);
		
		//System.out.println("해당 월의 데이터="+monthData);
		
		//----------해당 연도의 예약 통계 데이터
		//List<String> yearData = dao.selectYaksokReserveYearData(yidx,year_selectYear);
		
		
		//----------중복 예약 통계 데이터
		//약속 예약 유저정보 중 중복값이 없는 (1회만 예약한 유저의 수)
		int notOverlapCount=dao.selectYaksokReserveNotOverlapCount(yidx);
		
		//약속 예약 유저정보 중 중복값을 제거한 유저 수
		int reserveUserCount=dao.selectYaksokReserveUserCount(yidx);
		
		//약속 예약 유저정보 중 중복값이 있는 (2회 이상 예약한 유저의 수)
		int overlapCount=reserveUserCount-notOverlapCount;
		
		req.setAttribute("notOverlapCount", notOverlapCount);
		req.setAttribute("overlapCount", overlapCount);
		
		this.setRedirect(false);
		this.setViewPage("yaksok/yaksokStatistics.jsp");

	}

}