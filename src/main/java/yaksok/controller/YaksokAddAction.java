package yaksok.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import member.model.UserVO;
import yaksok.model.YaksokDAOMyBatis;
import yaksok.model.YaksokInfoVO;
import yaksok.model.YaksokOnOffVO;
import yaksok.model.YaksokVO;

import common.util.RandomNumber;

public class YaksokAddAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		req.setCharacterEncoding("UTF-8");
		
		//세션에서 꺼내오기
		HttpSession session=req.getSession();
		
		//로그인회원의 정보 가져오기
		UserVO user=(UserVO) session.getAttribute("loginUser");
		String idx=user.getIdx();
		String yaksokname=req.getParameter("yaksokname");
		
		//약속 등록
		YaksokVO yaksok=new YaksokVO(null,yaksokname,null,idx);
		YaksokDAOMyBatis dao=new YaksokDAOMyBatis();
		int n=dao.insertYaksok(yaksok);
		
		String yaksokurl=yaksokname+RandomNumber.randomNumber(8,1);
		
		//약속 데이터 등록
		YaksokInfoVO info=new YaksokInfoVO(null,yaksokurl,
				"위치","02","1234","6578","010","1234","5678",
				"imageSample1.png","imageSample2.png","imageSample3.png",
				"imageSample4.png","imageSample5.png",
				"메인 제목","메인 설명","설명1 제목","설명1","설명2 제목","설명2","설명3 제목","설명3","1");
		int infosuc=dao.insertYaksokInfo(info);
		
		//약속 OnOff 등록
		YaksokOnOffVO onoff=new YaksokOnOffVO(null,"1","1","1","1","1");
		int onoffsuc=dao.insertYaksokOnOff(onoff);
		
		String message=((n>0)&&(infosuc>0)&&(onoffsuc>0))? "등록 성공":"등록 실패";
		String loc=((n>0)&&(infosuc>0)&&(onoffsuc>0))? "yaksok.me":"javascript:history.back()";
		
		req.setAttribute("message", message);
		req.setAttribute("loc", loc);
		
		this.setViewPage("msg.jsp");
		this.setRedirect(false);

	}
	
}