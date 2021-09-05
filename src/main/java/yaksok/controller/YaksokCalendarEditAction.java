package yaksok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import yaksok.model.YaksokCalendarVO;
import yaksok.model.YaksokDAOMyBatis;

public class YaksokCalendarEditAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		
		String yidx=req.getParameter("yidx");
		String cidx=req.getParameter("cidx");
		String ctitle=req.getParameter("ctitle");
		String ccontent=req.getParameter("ccontent");
		
		YaksokCalendarVO vo=new YaksokCalendarVO(cidx,ctitle,ccontent,null,null,null,null);
		YaksokDAOMyBatis dao=new YaksokDAOMyBatis();
		
		int n=dao.updateYaksokCalendar(vo);
		
		if(n>0) {
			this.setRedirect(false);
			this.setViewPage("yaksokCalendar.me?yidx="+yidx);
			return;
		}

		
		
	}

}