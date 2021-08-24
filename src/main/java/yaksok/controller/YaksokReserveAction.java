package yaksok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import common.util.CommonUtil;
import common.util.RandomNumber;
import yaksok.model.YaksokDAOMyBatis;
import yaksok.model.YaksokReserveVO;

public class YaksokReserveAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		String yidx=req.getParameter("yidx");
		String rusername=req.getParameter("rusername");
		String rhp=req.getParameter("rhp");
		String rcontent=req.getParameter("rcontent");
		String rnumber=RandomNumber.randomNumber(6,1);
		
		if(rusername==null||rusername.trim().isEmpty()||rhp==null||rhp.trim().isEmpty()) {
			CommonUtil.addMsgBack(req, "모든 정보를 입력해주세요.");
			this.setRedirect(false);
			this.setViewPage("msg.jsp");
			return;
		}
		
		String yaksokurl=req.getParameter("yaksokurl");
		
		YaksokDAOMyBatis dao=new YaksokDAOMyBatis();
		YaksokReserveVO reserveVo=new YaksokReserveVO(null,rusername,rhp,rcontent,
				rnumber,null,"1",yidx);
		
		int n=dao.insertYaksokReserve(reserveVo);
		
		String msg=(n>0)? "약속완료! 약속번호는 \""+rnumber+"\"입니다.":"약속실패";
		String loc=(n>0)? "yaksokReservePage.me?url="+yaksokurl:"javascript:history.back()";
		CommonUtil.addMsgLoc(req, msg, loc);
		
		this.setRedirect(false);
		this.setViewPage("msg.jsp");

	}

}