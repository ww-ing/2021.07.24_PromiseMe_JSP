package yaksok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;

public class YaksokSetFormAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		req.setCharacterEncoding("UTF-8");
		
		String key=req.getParameter("key");
		
		req.setAttribute("key", key);
		
		this.setViewPage("yaksok/yaksokSetForm.jsp");
		this.setRedirect(false);

	}

}