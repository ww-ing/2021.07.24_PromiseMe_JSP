package yaksok.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import yaksok.model.YaksokCalendarVO;
import yaksok.model.YaksokDAOMyBatis;

public class YaksokCalendarAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		
		String yidx=req.getParameter("yidx");
		req.setAttribute("yidx", yidx);
		
		YaksokDAOMyBatis dao=new YaksokDAOMyBatis();
		List<YaksokCalendarVO> calendarList=dao.selectAllYaksokCalendar(yidx);
		req.setAttribute("calendarList", calendarList);
		
		this.setRedirect(false);
		this.setViewPage("yaksok/yaksokCalendar.jsp");

	}

}
