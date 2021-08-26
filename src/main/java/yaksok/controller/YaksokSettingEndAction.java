package yaksok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import common.util.CommonUtil;
import yaksok.model.YaksokDAOMyBatis;
import yaksok.model.YaksokOnOffVO;

public class YaksokSettingEndAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		
		String yidx=req.getParameter("yidx");
		
		String yaksokOnOffStr=req.getParameter("yaksokOnOff");
		String calendarOnOffStr=req.getParameter("calendarOnOff");
		String overlapOnOffStr=req.getParameter("overlapOnOff");
		String payOnOffStr=req.getParameter("payOnOff");
		
		String yaksokOnOff="0";
		if(yaksokOnOffStr!=null) {
			yaksokOnOff="1";
		}
		
		String calendarOnOff="0";
		if(calendarOnOffStr!=null) {
			calendarOnOff="1";
		}
		
		String overlapOnOff="0";
		if(overlapOnOffStr!=null) {
			overlapOnOff="1";
		}
		
		String payOnOff="0";
		if(payOnOffStr!=null) {
			payOnOff="1";
		}
		
		YaksokOnOffVO onoffVo=new YaksokOnOffVO(yidx,yaksokOnOff,calendarOnOff,
				overlapOnOff,payOnOff);
		
		YaksokDAOMyBatis dao=new YaksokDAOMyBatis();
		int n=dao.updateYaksokOnOff(onoffVo);
		
		String msg=(n>0)? "수정 완료":"수정 실패";
		String loc=(n>0)? "start.me":"javascript:history.back()";		
		CommonUtil.addMsgLoc(req, msg, loc);
		
		this.setRedirect(false);
		this.setViewPage("msg.jsp");

	}

}