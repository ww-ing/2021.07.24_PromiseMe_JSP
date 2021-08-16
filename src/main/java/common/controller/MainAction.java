package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.domain.UserVO;

public class MainAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		
		HttpSession session=req.getSession();
		UserVO user=(UserVO) session.getAttribute("loginUser");
		req.setAttribute("user", user);
		
		this.setRedirect(false);
		this.setViewPage("main.jsp");

	}

}