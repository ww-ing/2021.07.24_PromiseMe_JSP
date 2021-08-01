package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StartAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("StartAction execute()");
		
		this.setViewPage("start.jsp");
		System.out.println("StartAction setViewPage start.jsp");
		//this.setRedirect(true);//redirect방식으로 이동
		this.setRedirect(false);//forward방식으로 이동
		System.out.println("StartAction setRedirect false");

	}

}