package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import member.model.UserDAOMyBatis;
import member.model.UserVO;

import common.util.CommonUtil;

public class MyInfoEditAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		
		String idx=req.getParameter("idx");
		String username=req.getParameter("username");
		String userid=req.getParameter("userid");
		String pwd=req.getParameter("pwd");
		String hp1=req.getParameter("hp1");
		String hp2=req.getParameter("hp2");
		String hp3=req.getParameter("hp3");
		String mstate=req.getParameter("mstate");
		
		UserVO user=new UserVO(idx,username,userid,pwd,hp1,hp2,hp3,null, mstate);
		UserDAOMyBatis userDao=new UserDAOMyBatis();
		int n=userDao.updateMyInfo(user);
		
		String msg=(n>0)? "수정 완료":"수정 실패";
		String loc=(n>0)? "myInfo.me":"javascript:history.back()";
		
		CommonUtil.addMsgLoc(req, msg, loc);
		
		this.setRedirect(false);
		this.setViewPage("msg.jsp");
		

	}

}