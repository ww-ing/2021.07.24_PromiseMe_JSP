package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.UserDAOMybatis;
import user.domain.UserVO;

public class StartAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		
		this.setViewPage("start.jsp");
		this.setRedirect(false);

	}

}