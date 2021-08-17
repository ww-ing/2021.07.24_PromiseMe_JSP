package login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;

public class IdCheckAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		String userid=req.getParameter("userid");
		
		System.out.println("userid="+userid);
		
		this.setRedirect(false);
		this.setViewPage("join.me");

	}

}
