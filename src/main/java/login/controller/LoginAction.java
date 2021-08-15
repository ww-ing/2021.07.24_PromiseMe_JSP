package login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;

public class LoginAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		this.setRedirect(false);
		this.setViewPage("login/login.jsp");

	}

}
