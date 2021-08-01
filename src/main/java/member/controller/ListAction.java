package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;

public class ListAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("ListAction의 execute()");
		
		this.setViewPage("member/list.jsp");
		System.out.println("ListAction setViewPage list.jsp");
		//this.setRedirect(true);//redirect방식으로 이동
		this.setRedirect(false);//forward방식으로 이동
		System.out.println("ListAction setRedirect false");

	}

}
