package yaksok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import yaksok.model.YaksokCalendarVO;
import yaksok.model.YaksokDAOMyBatis;

public class YaksokCalendarAddAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		String yidx=req.getParameter("yidx");
		String ctitle=req.getParameter("ctitle");
		String ccontent=req.getParameter("ccontent");
		String cyear=req.getParameter("year");
		String cmonth=req.getParameter("month");
		String cday=req.getParameter("day");
		
		YaksokDAOMyBatis dao=new YaksokDAOMyBatis();
		YaksokCalendarVO vo=new YaksokCalendarVO(null,ctitle,ccontent,cyear,cmonth,cday,yidx);
		
		int n=dao.insertYaksokCalendar(vo);
				
		this.setRedirect(false);
		this.setViewPage("yaksokCalendar.me?yidx="+yidx);

	}

}