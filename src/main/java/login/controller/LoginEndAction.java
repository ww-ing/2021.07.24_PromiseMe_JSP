package login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;

public class LoginEndAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("LoginEndAction의 execute()");
		
		this.setViewPage("login/loginEnd.jsp");
		System.out.println("LoginEndAction setViewPage login/loginEnd.jsp");
		//this.setRedirect(true);//redirect방식으로 이동
		this.setRedirect(false);//forward방식으로 이동
		System.out.println("LoginEndAction setRedirect false");

	}

}
