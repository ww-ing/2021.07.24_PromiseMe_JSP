package yaksok.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import yaksok.model.YaksokDAOMyBatis;
import yaksok.model.YaksokReserveVO;

public class YaksokReserveListAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		
		String yidx=req.getParameter("yidx");
		req.setAttribute("yidx", yidx);
		
		String cpageStr=req.getParameter("cpage");
		
		//default 페이지 창을 1로 지정
		if(cpageStr==null||cpageStr.trim().isEmpty()) {
			cpageStr="1";
		}
		
		int cpage=Integer.parseInt(cpageStr.trim());
		if(cpage<1) {
			cpage=1;
		}
		
		//페이지 사이즈를 유동적으로 받기 위함
		String pageSizeStr=req.getParameter("pageSize");
		if(pageSizeStr==null||pageSizeStr.trim().isEmpty()) {
			pageSizeStr="5";
		}
		
		YaksokDAOMyBatis dao=new YaksokDAOMyBatis();
		
		//약속 예약 정보 개수 가져오기
		int count=dao.getYaksokReserveCount(yidx);
		req.setAttribute("reserveCount", count);
		
		//한 페이지 당 보여줄 게시글 수
		int pageSize=Integer.parseInt(pageSizeStr);
		
		int pageCount=(count-1)/pageSize+1;
		req.setAttribute("pageCount", pageCount);
		
		if(cpage>pageCount) {
			cpage=pageCount;
		}
		
		int end=cpage*pageSize;
		int start=end-(pageSize-1);
		
		//약속 예약 정보 리스트
		List<YaksokReserveVO> reserveList=dao.selectAllYaksokReserve(yidx, start, end);		
		req.setAttribute("reserveList", reserveList);
		 
		this.setRedirect(false);
		this.setViewPage("yaksok/yaksokReserveList.jsp");

	}

}