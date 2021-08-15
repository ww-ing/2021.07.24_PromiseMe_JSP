package login.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import user.persistence.UserDAO;
import user.domain.UserVO;

public class LoginEndAction extends AbstractAction {
	
	

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		
		String id = req.getParameter("userid");
		String pwd = req.getParameter("pwd");
		System.out.println("id="+id);
		System.out.println("pwd="+pwd);
		
		//아이디 저장 체크박스에 체크한 값 받아오기
		String saveId = req.getParameter("saveId");
		
		//유효성 체크
		if(id==null || pwd==null || "".equals(id.trim())||"".equals(pwd.trim())){
			this.setViewPage("login.me");
			this.setRedirect(true);
			return;
		}
		
		UserDAO userDao=new UserDAO();
		UserVO loginUser = userDao.loginCheck(id, pwd);
		
		if(loginUser!=null){
			HttpSession session = req.getSession();
			session.setAttribute("loginUser", loginUser);
			
			java.util.Date d = new java.util.Date();
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy_MM_dd hh:mm:ss");
			String time = sdf.format(d);
			session.setAttribute("loginTime", time);
			
			//[1] saveId에 체크한 경우 하지 않은 경우를 나눠서 처리하자
			//	-체크를 했다면 쿠키를 생성하고 해당 쿠키에 사용자 아이디를 저장한 뒤에 유효시간을 설정(7일간 유효)
			//  -체크하지 않았다면 쿠키를 삭제 처리
			
			Cookie ck = new Cookie("uid",loginUser.getUserid());//로그인한 유저의 아이디를 저장 키 값 = "uid" //쿠키 생성
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
			
			this.setViewPage("main.me");
			this.setRedirect(false);
			
			/*회원인증을 받았다면 인증받은 회원정보를 session에 저장하자.
			session 내장객체 : HttpSession 타입
				-setAttribute (String key, Object value)
					:세션에 저장할 때 사용
				- Object getAttribute(String key)
					:세션에 저장된 값을 꺼낼때 사용
			*/
		}
		

	}

}