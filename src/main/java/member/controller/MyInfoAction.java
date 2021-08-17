package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import member.model.UserDAOMyBatis;
import member.model.UserVO;

public class MyInfoAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		
		HttpSession session=req.getSession();
		UserVO loginUser=(UserVO) session.getAttribute("loginUser");
		String idx=loginUser.getIdx();
		
		UserDAOMyBatis userDao=new UserDAOMyBatis();
		
		UserVO user=userDao.selectUser(idx);
		req.setAttribute("user", user);
		
		String mstate=user.getMstate();
		if(mstate.equals("0")) {
			req.setAttribute("mstate1", "checked");
		}else if(mstate.equals("1")) {
			req.setAttribute("mstate2", "checked");
		}else if(mstate.equals("-1")) {
			req.setAttribute("mstate3", "checked");
		}
		
		this.setRedirect(false);
		this.setViewPage("member/myInfo.jsp");

	}

}