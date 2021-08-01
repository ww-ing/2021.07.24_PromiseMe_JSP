package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("MainAction execute()");
		
		this.setViewPage("main.jsp");
		System.out.println("MainAction setViewPage main.jsp");
		//this.setRedirect(true);//redirect방식으로 이동
		this.setRedirect(false);//forward방식으로 이동
		System.out.println("MainAction setRedirect false");

	}

}