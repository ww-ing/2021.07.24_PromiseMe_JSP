package yaksok.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;

public class YaksokAddFormAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
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
		
		req.setAttribute("userid", userid);
		
		this.setViewPage("yaksok/yaksokAddForm.jsp");
		this.setRedirect(false);

	}

}
