package login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;

public class LogoutAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		HttpSession session = req.getSession();
		session.invalidate();
		
		
		req.setAttribute("message", "로그아웃 완료");
		req.setAttribute("loc", "main.me");
		
		this.setViewPage("msg.jsp");
		this.setRedirect(false); 
		

	}

}
