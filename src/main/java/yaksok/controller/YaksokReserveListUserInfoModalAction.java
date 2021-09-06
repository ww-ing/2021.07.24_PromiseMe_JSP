package yaksok.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.views.AbstractView;
import org.w3c.dom.views.DocumentView;

import common.controller.AbstractAction;
import yaksok.model.YaksokDAOMyBatis;
import yaksok.model.YaksokReserveVO;

public class YaksokReserveListUserInfoModalAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)  
	throws Exception {
		
		String yidx=req.getParameter("yidx");
		String ridx=req.getParameter("ridx");
		req.setAttribute("yidx", yidx);
		req.setAttribute("ridx", ridx);
		
		YaksokDAOMyBatis dao=new YaksokDAOMyBatis();
		YaksokReserveVO vo=dao.selectYaksokReserve(ridx);
		
		String rusername=vo.getRusername();
		String rhp=vo.getRhp();
		Date rindate=vo.getRindate();
		String rcontent=vo.getRcontent();
		req.setAttribute("rusername", rusername);
		req.setAttribute("rhp", rhp);
		req.setAttribute("rindate", rindate);
		req.setAttribute("rcontent", rcontent);
		
		if(vo.getRcheckedstate().equals("1")) {
			dao.updateYaksokReserve(ridx);
		}
		
		this.setRedirect(false);
		this.setViewPage("yaksok/modal/yaksokReserveListUserInfoModal.jsp");
	
	}

}
