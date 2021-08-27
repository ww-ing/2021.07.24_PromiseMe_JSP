package yaksok.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import common.util.CommonUtil;
import yaksok.model.YaksokDAOMyBatis;
import yaksok.model.YaksokOnOffVO;

public class YaksokSettingUpdateAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		
		String yidx=req.getParameter("yidx");
		req.setAttribute("yidx", yidx);
		
		String yaksokOnOffStr=req.getParameter("yaksokOnOff");
		String calendarOnOffStr=req.getParameter("calendarOnOff");
		String overlapOnOffStr=req.getParameter("overlapOnOff");
		String payOnOffStr=req.getParameter("payOnOff");
		String maxreserveStr=req.getParameter("maxreserveOnOff");
		
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
		
		String maxreserveOnOff="0";
		if(maxreserveStr!=null) {
			maxreserveOnOff="1";
		}
		
		YaksokOnOffVO onoffVo=new YaksokOnOffVO(yidx,yaksokOnOff,calendarOnOff,
				overlapOnOff,payOnOff,maxreserveOnOff);
		
		YaksokDAOMyBatis dao=new YaksokDAOMyBatis();
		int n=dao.updateYaksokOnOff(onoffVo);
		
		String loc=(n>0)? "yaksokSetting.me?yidx="+yidx:"javascript:history.back()";
		this.setRedirect(false);
		this.setViewPage(loc);

	}

}