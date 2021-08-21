package yaksok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import yaksok.model.YaksokDAOMyBatis;
import yaksok.model.YaksokInfoVO;

public class YaksokMenuActions extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		
		String yidx=req.getParameter("yidx");
		
		YaksokDAOMyBatis dao=new YaksokDAOMyBatis();
		YaksokInfoVO info=dao.selectYaksokInfo(yidx);
		
		req.setAttribute("info", info);
		
		this.setViewPage("yaksok/yaksokMenu.jsp");
		this.setRedirect(false);

	}

}