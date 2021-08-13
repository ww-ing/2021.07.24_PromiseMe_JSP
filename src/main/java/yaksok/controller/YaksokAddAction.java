package yaksok.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import user.domain.UserVO;
import yaksok.model.YaksokDAOMyBatis;
import yaksok.model.YaksokInfoVO;
import yaksok.model.YaksokVO;

public class YaksokAddAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		req.setCharacterEncoding("UTF-8");
		
		//세션에서 꺼내오기
		HttpSession session=req.getSession();
		
		//로그인회원의 정보 가져오기
		UserVO user=(UserVO) session.getAttribute("loginUser");
		int idx=user.getIdx();
		String yaksokname=req.getParameter("yaksokname");
		
		//약속 등록
		YaksokVO yaksok=new YaksokVO(null,yaksokname,null,Integer.toString(idx));
		YaksokDAOMyBatis dao=new YaksokDAOMyBatis();
		int yaksoksuc=dao.insertYaksok(yaksok);
		
		//약속 데이터 등록
		YaksokInfoVO info=new YaksokInfoVO(null,yaksokname+numberGen(12,1),
				"위치","02","1234","6578","010","1234","5678",
				"imageSample1.png","imageSample2.png","imageSample3.png",
				"imageSample4.png","imageSample5.png",
				"메인 제목","메인 설명","설명1 제목","설명1","설명2 제목","설명2","설명3 제목","설명3","1");
		int infosuc=dao.insertYaksokInfo(info);
		
		
		String message=((yaksoksuc>0)&&(infosuc>0))? "등록 성공":"등록 실패";
		String loc=((yaksoksuc>0)&&(infosuc>0))? "yaksok.me":"javascript:history.back()";
		
		req.setAttribute("message", message);
		req.setAttribute("loc", loc);
		
		this.setViewPage("msg.jsp");
		this.setRedirect(false);

	}
	
	//약속 url 생성
	public static String numberGen(int len, int dupCd ) {
	        
	        Random rand = new Random();
	        String numStr = ""; //난수가 저장될 변수
	        
	        for(int i=0;i<len;i++) {
	            
	            //0~9 까지 난수 생성
	            String ran = Integer.toString(rand.nextInt(10));
	            
	            if(dupCd==1) {
	                //중복 허용시 numStr에 append
	                numStr += ran;
	            }else if(dupCd==2) {
	                //중복을 허용하지 않을시 중복된 값이 있는지 검사한다
	                if(!numStr.contains(ran)) {
	                    //중복된 값이 없으면 numStr에 append
	                    numStr += ran;
	                }else {
	                    //생성된 난수가 중복되면 루틴을 다시 실행한다
	                    i-=1;
	                }
	            }
	        }
	        return numStr;
	    }

}