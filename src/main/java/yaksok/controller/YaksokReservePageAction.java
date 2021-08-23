package yaksok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import yaksok.model.YaksokDAOMyBatis;
import yaksok.model.YaksokInfoVO;

public class YaksokReservePageAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		
		String yaksokurl=req.getParameter("url");
		
		YaksokDAOMyBatis dao=new YaksokDAOMyBatis();
		YaksokInfoVO info=dao.selectYaksokInfoByURL(yaksokurl);
		
		String template=info.getTemplates();
		req.setAttribute("info", info);
		
		this.setRedirect(false);
		this.setViewPage("yaksok/templates_reserve/template"+template+"/template"+template+".jsp");

	}

}