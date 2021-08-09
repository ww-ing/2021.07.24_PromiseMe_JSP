package yaksok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import user.domain.UserVO;
import yaksok.model.YaksokDAOMyBatis;
import yaksok.model.YaksokVO;

public class YaksokAddAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		req.setCharacterEncoding("UTF-8");
		
		//세션에서 꺼내오기
		HttpSession session=req.getSession();
		UserVO user=(UserVO) session.getAttribute("loginUser");
		int useridx=user.getIdx();
		String idx=Integer.toString(useridx);
		
		String yaksokname=req.getParameter("yaksokname");
		
		YaksokVO item=new YaksokVO(null, yaksokname, null, idx);
		
		YaksokDAOMyBatis dao=new YaksokDAOMyBatis();
		
		int suc=dao.insertYaksok(item);
		
		String message=(suc>0)? "등록 성공":"등록 실패";
		String loc=(suc>0)? "yaksok.me":"javascript:history.back()";
		
		req.setAttribute("message", message);
		req.setAttribute("loc", loc);
		
		this.setViewPage("msg.jsp");
		this.setRedirect(false);

	}

}
