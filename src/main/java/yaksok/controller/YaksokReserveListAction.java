package yaksok.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import yaksok.model.YaksokDAOMyBatis;
import yaksok.model.YaksokReserveVO;

public class YaksokReserveListAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		 String yidx=req.getParameter("yidx");
		 req.setAttribute(yidx, yidx);
		 
		 YaksokDAOMyBatis dao=new YaksokDAOMyBatis();
		 List<YaksokReserveVO> reserveList=dao.selectAllYaksokReserve(yidx);
		 req.setAttribute("reserveList", reserveList);
		 
		this.setRedirect(false);
		this.setViewPage("yaksok/yaksokReserveList.jsp");

	}

}