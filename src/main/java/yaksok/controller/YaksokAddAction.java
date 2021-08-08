package yaksok.controller;

import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import yaksok.model.YaksokDAOMyBatis;
import yaksok.model.YaksokVO;

public class YaksokAddAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		req.setCharacterEncoding("UTF-8");
		
		//쿠키 꺼내오기
		Cookie[] cks = req.getCookies();
		System.out.println("cks="+cks);
		String userid = "";
		if(cks!=null){
			for(Cookie ck : cks){
				String key = ck.getName();//쿠키의 키값을 반환
				if(key.equals("uid")){
					userid=ck.getValue();//사용자 아이디
					break;
				}
				
			}
		}
		
		String yaksokname=req.getParameter("yaksokname");
		
		YaksokVO item=new YaksokVO(null, userid, yaksokname, null, null);
		
		YaksokDAOMyBatis dao=new YaksokDAOMyBatis();
		
		int suc=dao.insertYaksok(item);
		
		String message=(suc>0)? "등록 성공":"등록 실패";
		String loc=(suc>0)? "yaksok.me":"javascript:history.back()";
		
		req.setAttribute("message", message);
		req.setAttribute("loc", loc);
		
		this.setViewPage("msg.jsp");
		this.setRedirect(false);

	}

}
