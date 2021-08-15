package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import common.util.CommonUtil;
import user.domain.UserVO;
import user.persistence.UserDAO;

public class JoinEndAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		
		String name=req.getParameter("name");
		String userid=req.getParameter("userid");
		String pwd=req.getParameter("pwd");
		String hp1=req.getParameter("hp1");
		String hp2=req.getParameter("hp2");
		String hp3=req.getParameter("hp3");
		String zipcode=req.getParameter("zipcode");
		String addr1=req.getParameter("addr1");
		String addr2=req.getParameter("addr2");
		
		UserVO user = new UserVO(0,name,userid,pwd,hp1,hp2,hp3,zipcode,addr1,addr2,null,0,1);
		if(user.getName()==null || user.getUserid()==null){
			
			CommonUtil.addMsgBack(req, "잘못된 경로입니다.");
			
			this.setRedirect(false);
			this.setViewPage("join.me");	
			return;
		}
		
		UserDAO userDao=new UserDAO();
		
		int	n = userDao.createUser(user);

		String msg=(n>0)?"회원가입 성공! 로그인 페이지로 이동합니다":"회원가입 실패";
		String loc=(n>0)?"login.me":"javascript:history.back()";
		
		CommonUtil.addMsgLoc(req,msg,loc);
		
		this.setRedirect(false);
		this.setViewPage("msg.jsp");

	}

}