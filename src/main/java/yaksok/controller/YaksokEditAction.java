package yaksok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import yaksok.model.YaksokDAOMyBatis;
import yaksok.model.YaksokInfoVO;

public class YaksokEditAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		String yidx=req.getParameter("yidx");
		String yaksokurl=req.getParameter("yaksokurl");
		String locarte=req.getParameter("locate");
		
		String number1_1=req.getParameter("number1_1");
		String number1_2=req.getParameter("number1_2");
		String number1_3=req.getParameter("number1_3");
		String number2_1=req.getParameter("number2_1");
		String number2_2=req.getParameter("number2_2");
		String number2_3=req.getParameter("number2_3");
		
		String image1=req.getParameter("image1");
		String image2=req.getParameter("image1");
		String image3=req.getParameter("image1");
		String image4=req.getParameter("image1");
		String image5=req.getParameter("image1");
		
		String content_main_title=req.getParameter("content_main_title");
		String content_main=req.getParameter("content_main");
		
		String content1_title=req.getParameter("content1_title");
		String content1=req.getParameter("content1");
		
		String content2_title=req.getParameter("content2_title");
		String content2=req.getParameter("content2");
		
		String content3_title=req.getParameter("content3_title");
		String content3=req.getParameter("content3");
		
		String templates=req.getParameter("templates");
		
		//해당 약속의 정보 얻어오기
		YaksokDAOMyBatis dao=new YaksokDAOMyBatis();
		YaksokInfoVO info= new YaksokInfoVO(yidx,yaksokurl,locarte,
				number1_1,number1_2,number1_3,
				number2_1,number2_2,number2_3,
				image1,image2,image3,image4,image5,
				content_main_title,content_main,
				content1_title,content1,
				content2_title,content2,
				content3_title,content3,
				templates);
		int n=dao.updateYaksokInfo(info);
		
		if(n>0) {
			req.setAttribute("info", info);
			this.setRedirect(false);
			this.setViewPage("yaksokSetForm.me");
		}else {
			this.setRedirect(false);
			this.setViewPage("javascript:history.back()");
			return;
		}
		

	}

}