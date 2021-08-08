package yaksok.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import yaksok.model.YaksokDAOMyBatis;
import yaksok.model.YaksokVO;

public class YaksokAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		
		//쿠키 꺼내오기
		Cookie[] cks = req.getCookies();
		System.out.println("cks="+cks);
		String uid = "";
		if(cks!=null){
			for(Cookie ck : cks){
				String key = ck.getName();//쿠키의 키값을 반환
				if(key.equals("uid")){
					uid=ck.getValue();//사용자 아이디
					break;
				}
				
			}
		}

		YaksokDAOMyBatis dao=new YaksokDAOMyBatis();
		
		
		//샘플
		int cnt=dao.getTableCount();
		
		req.setAttribute("msg", "약속 카운터수 체크");
		req.setAttribute("count", cnt);
		
		//selectAllYaksok
		List<YaksokVO> yaksokList=dao.selectAllYaksok(uid);
		System.out.println("yaksokList="+yaksokList);
		
		req.setAttribute("yaksokList", yaksokList);
		
		this.setViewPage("yaksok/yaksok.jsp");
		this.setRedirect(false);
		
	}

}
