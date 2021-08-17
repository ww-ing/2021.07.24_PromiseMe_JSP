package login.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import member.model.UserDAOMyBatis;
import member.model.UserVO;

import common.util.CommonUtil;

public class LoginEndAction extends AbstractAction {
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		
		String id = req.getParameter("userid");
		String pwd = req.getParameter("pwd");
		
		//아이디 저장 체크박스에 체크한 값 받아오기
		String saveId = req.getParameter("saveId");
		
		//유효성 체크
		if(id==null || pwd==null || "".equals(id.trim())||"".equals(pwd.trim())){
			
			this.setViewPage("login.me");
			this.setRedirect(true);
			return;
		}
		
		UserDAOMyBatis userDao=new UserDAOMyBatis();
		UserVO loginUser = userDao.selectUserById(id);
		
		if(loginUser==null) {
			CommonUtil.addMsgBack(req, id+"란 아이디는 존재하지 않아요");
			this.setRedirect(false);
			this.setViewPage("msg.jsp");
			return;
		}
		
		if(!pwd.equals(loginUser.getPwd())){
			CommonUtil.addMsgBack(req, "패스워드가 일치하지 않습니다.");
			this.setRedirect(false);
			this.setViewPage("msg.jsp");
			return;
		}
	
		
		if(loginUser!=null){
			HttpSession session = req.getSession();
			session.setAttribute("loginUser", loginUser);
			
			java.util.Date d = new java.util.Date();
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy_MM_dd hh:mm:ss");
			String time = sdf.format(d);
			session.setAttribute("loginTime", time);
			
			//쿠키 등록
			Cookie ck = new Cookie("uid",loginUser.getUserid());//쿠키 생성
			if(saveId!=null){//체크했다면
				//쿠키 속성을 설정
				ck.setMaxAge(60*60*24*7);//7일간 유효
				
			}else{//체크하지 않았다면
				ck.setMaxAge(0);//쿠키 삭제
				
			}
			
			//쿠키를 어디에서든 꺼내올수 있도록 설정
			ck.setPath("/");
			
			//쿠키를 클라이언트 쪽에 밀어넣기
			res.addCookie(ck);
			
			this.setRedirect(false);
			this.setViewPage("main.me");
		}

	}

}