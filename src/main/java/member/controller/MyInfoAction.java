package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import user.domain.UserVO;

public class MyInfoAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		
		HttpSession session=req.getSession();
		UserVO user=(UserVO) session.getAttribute("loginUser");
		
		this.setRedirect(false);
		this.setViewPage("member/myInfo.jsp");

	}

}