package yaksok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import yaksok.model.YaksokDAOMyBatis;
import yaksok.model.YaksokInfoVO;

public class YaksokSetFormAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		req.setCharacterEncoding("UTF-8");
		
		String yidx=req.getParameter("yidx");
		req.setAttribute("yidx", yidx);
		
		YaksokDAOMyBatis dao=new YaksokDAOMyBatis();
		YaksokInfoVO info=dao.selectYaksokInfo(yidx);
		
		req.setAttribute("info", info);
		
		
		this.setViewPage("yaksok/yaksokSetForm.jsp");
		this.setRedirect(false);

	}

}