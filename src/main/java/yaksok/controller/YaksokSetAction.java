package yaksok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import yaksok.model.YaksokDAOMyBatis;
import yaksok.model.YaksokInfoVO;

public class YaksokSetAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		

		String editNum=req.getParameter("editNum");
		
		String readonly="";
		if(editNum.equals("0")) {
			readonly="readonly";
			req.setAttribute("readonly", readonly);
		}
		else if(editNum.equals("1")) {
			readonly="";
			req.setAttribute("readonly", readonly);
		}
		
		String yidx=req.getParameter("yidx");
				
		YaksokDAOMyBatis dao=new YaksokDAOMyBatis();
		YaksokInfoVO info=dao.selectYaksokInfo(yidx);
		req.setAttribute("info", info);
		
		this.setRedirect(false);
		
		//선택한 탬플릿 번호
		String templates=req.getParameter("templates");
		this.setViewPage("yaksok/templates/template"+templates+".jsp");

	}

}