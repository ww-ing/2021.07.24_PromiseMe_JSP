package login.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;

public class LoginAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		
		Cookie[] cks = req.getCookies();
		if(cks!=null){
			for(Cookie ck : cks){
				String key = ck.getName();
				if(key.equals("uid")){
					req.setAttribute("checked", "checked");
					req.setAttribute("uid", ck.getValue());
					break;
				}
				
			}
		}
		
		this.setRedirect(false);
		this.setViewPage("login/login.jsp");

	}

}
