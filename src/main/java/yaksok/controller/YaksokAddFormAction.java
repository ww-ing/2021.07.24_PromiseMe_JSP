package yaksok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import user.domain.UserVO;

public class YaksokAddFormAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//세션에서 꺼내오기
		HttpSession session=req.getSession();
		UserVO user=(UserVO) session.getAttribute("loginUser");
		int useridx=user.getIdx();
		String idx=Integer.toString(useridx);
		
		req.setAttribute("idx", idx);
		
		this.setViewPage("yaksok/yaksokAddForm.jsp");
		this.setRedirect(false);

	}

}
