package yaksok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import yaksok.model.YaksokCalendarVO;
import yaksok.model.YaksokDAOMyBatis;

public class YaksokCalendarEditModalAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		
		String yidx=req.getParameter("yidx");
		String cidx=req.getParameter("cidx");
		req.setAttribute("yidx", yidx);
		req.setAttribute("cidx", cidx);
		
		YaksokDAOMyBatis dao=new YaksokDAOMyBatis();
		YaksokCalendarVO vo=dao.selectYaksokCalendarSchedule(cidx);
		
		String ctitle=vo.getCtitle();
		String ccontent=vo.getCcontent();
		req.setAttribute("ctitle", ctitle);
		req.setAttribute("ccontent", ccontent);

		this.setRedirect(false);
		this.setViewPage("yaksok/modal/yaksokCalendarEditModal.jsp");
		
	}

}