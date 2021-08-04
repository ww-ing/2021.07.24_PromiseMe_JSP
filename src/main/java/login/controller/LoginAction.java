package login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;

public class LoginAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		System.out.println("LoginAction의 execute()");
		
		this.setViewPage("login/login.jsp");
		System.out.println("LoginAction setViewPage join.jsp");
		this.setRedirect(false);

	}

}
