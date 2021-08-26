package yaksok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import member.model.UserVO;

public class YaksokAddFormAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		
		//세션에서 꺼내오기
		HttpSession session=req.getSession();
		UserVO user=(UserVO) session.getAttribute("loginUser");
		String idx=user.getIdx();
		
		req.setAttribute("idx", idx);
		
		this.setViewPage("yaksok/yaksokAddForm.jsp");
		this.setRedirect(false);

	}

}