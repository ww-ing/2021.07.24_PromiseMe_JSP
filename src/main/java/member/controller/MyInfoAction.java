package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;

public class MyInfoAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("MyInfoAction의 execute()");
		
		this.setViewPage("member/myInfo.jsp");
		System.out.println("MyInfoAction setViewPage myInfo.jsp");
		//this.setRedirect(true);//redirect방식으로 이동
		this.setRedirect(false);//forward방식으로 이동
		System.out.println("MyInfoAction setRedirect false");

	}

}
