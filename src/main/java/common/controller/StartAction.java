package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.UserDAOMybatis;
import user.domain.UserVO;

public class StartAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {

		
		//User테스트
		UserDAOMybatis userDao=new UserDAOMybatis();;
		
		UserVO user=userDao.selectUser("1");
		
		req.setAttribute("user", user);
		
		
		this.setViewPage("start.jsp");
		this.setRedirect(false);//forward방식으로 이동

	}

}