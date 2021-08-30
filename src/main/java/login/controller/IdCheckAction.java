package login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import member.model.UserDAOMyBatis;
import member.model.UserVO;

public class IdCheckAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		String userid=req.getParameter("userid");
		
		UserDAOMyBatis userDao=new UserDAOMyBatis();
		UserVO user=userDao.selectUserById(userid);
		
		if(user!=null) {
			this.setRedirect(false);
			this.setViewPage("");
		}else {
			this.setRedirect(false);
			this.setViewPage("join.me");
		}
		
	}

}