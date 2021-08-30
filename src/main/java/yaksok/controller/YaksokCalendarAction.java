package yaksok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;

public class YaksokCalendarAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		
		String yidx=req.getParameter("yidx");
		req.setAttribute("yidx", yidx);
		
		this.setRedirect(false);
		this.setViewPage("yaksok/modal/yaksokCalendarModal.jsp");

	}

}
