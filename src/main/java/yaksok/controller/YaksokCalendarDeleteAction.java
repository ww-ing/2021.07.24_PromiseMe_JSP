package yaksok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import yaksok.model.YaksokDAOMyBatis;

public class YaksokCalendarDeleteAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		
		String yidx=req.getParameter("yidx");
		String cidx=req.getParameter("cidx");
		
		YaksokDAOMyBatis dao=new YaksokDAOMyBatis();
		int n=dao.deleteYaksokCalendar(cidx);
		
		if(n>0) {
			this.setRedirect(false);
			this.setViewPage("yaksokCalendar.me?yidx="+yidx);
			return;
		}

	}

}
