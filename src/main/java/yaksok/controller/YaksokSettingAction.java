package yaksok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import yaksok.model.YaksokDAOMyBatis;
import yaksok.model.YaksokOnOffVO;

public class YaksokSettingAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		
		String yidx=req.getParameter("yidx");
		
		YaksokDAOMyBatis dao=new YaksokDAOMyBatis();
		YaksokOnOffVO onoffData=dao.selectYaksokOnOff(yidx);
		
		req.setAttribute("onoffData", onoffData);
		
		String yaksokonoffCheck="";
		if(onoffData.getYaksokonoff().equals("1")) {
			yaksokonoffCheck="checked";
		}
		String calendaronoffCheck="";
		if(onoffData.getCalendaronoff().equals("1")) {
			calendaronoffCheck="checked";
		}
		String overlaponoffCheck="";
		if(onoffData.getOverlaponoff().equals("1")) {
			overlaponoffCheck="checked";
		}
		String payonoffCheck="";
		if(onoffData.getPayonoff().equals("1")) {
			payonoffCheck="checked";
		}
		String maxreserveonoffCheck="";
		if(onoffData.getMaxreserve().equals("1")) {
			maxreserveonoffCheck="checked";
		}
		
		req.setAttribute("yaksokonoffCheck", yaksokonoffCheck);
		req.setAttribute("calendaronoffCheck", calendaronoffCheck);
		req.setAttribute("overlaponoffCheck", overlaponoffCheck);
		req.setAttribute("payonoffCheck", payonoffCheck);
		req.setAttribute("maxreserveonoffCheck", maxreserveonoffCheck);
		
		
		
		this.setRedirect(false);
		this.setViewPage("yaksok/yaksokSetting.jsp");

	}

}
