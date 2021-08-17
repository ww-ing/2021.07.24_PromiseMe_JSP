package login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;

import common.util.CommonUtil;

public class LogoutAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		
		HttpSession session = req.getSession();
		session.invalidate();
	
		CommonUtil.addMsgLoc(req, "로그아웃 완료", "main.me");
		
		this.setRedirect(false); 
		this.setViewPage("msg.jsp");
		
	}

}
