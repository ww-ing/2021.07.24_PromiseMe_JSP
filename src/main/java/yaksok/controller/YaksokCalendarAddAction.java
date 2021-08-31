package yaksok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;

public class YaksokCalendarAddAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		String ctitle=req.getParameter("ctitle");
		String ccontent=req.getParameter("ccontent");
		System.out.println("ctitle="+ctitle);
		System.out.println("ccontent"+ccontent);
		
		this.setRedirect(false);
		this.setViewPage("start.me");

	}

}