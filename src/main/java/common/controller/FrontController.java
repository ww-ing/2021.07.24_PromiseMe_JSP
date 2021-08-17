package common.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet(
		urlPatterns = { "*.me" }, 
		initParams = { 
				@WebInitParam(name = "config", 
						value = "/Users/ww/eclipse-workspace/PromiseMe/src/main/webapp/WEB-INF/Command.properties")
		})
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Command.properties파일에 설정된 값들을 해쉬맵에 옮길 예정
	private HashMap<String, Object> cmdMap = new HashMap<>();
	
	@Override
	public void init(ServletConfig conf) throws ServletException {
		String prpos = conf.getInitParameter("config");
		
		Properties pr = new Properties();
		
		try {
			FileReader fr = new FileReader(prpos);
			pr.load(fr);
			if(fr !=null) fr.close();
			
			Set<Object> set = pr.keySet();
			
			for(Object key : set) {
				String cmd = key.toString();//key값
				String className = pr.getProperty(cmd);//클래스이름
				
				//Command.properties 파일의 경로에 공백값을 넣었을 경우
				if(className !=null) {
					className = className.trim();
				}
				
				//className 인스턴스화 //className을 넣으면 반환해준다
				Class<?> cls = Class.forName(className);
				
				//해당 클래스의 객체를 메모리에 올려준다.
				Object cmdInstance = cls.newInstance();
				
				//해쉬맵에 저장
				cmdMap.put(cmd, cmdInstance);
			}//--for()
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(); 
		}
		
	}//--init()

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//1. 클라이언트의 요청 URI를 분석해서 해당 요청을 처리함 SubController(XXXAction) 를 생성하고
		//	execute()를 호출한다.
		/*
		String cmd=request.getRequestURI();
		System.out.println("cmd=="+cmd);// "/MvcWeb/index.do"
		String ctx=request.getContextPath(); // "/MvcWeb"
		int len=ctx.length(); //7
		cmd=cmd.substring(len);
		System.out.println("cmd2=="+cmd);
		*/
		String cmd=request.getServletPath();
		
		//----------------------------------------------------------
		Object instance =cmdMap.get(cmd);
		if(instance==null) {
			System.out.println("FrontController의 Action이 null입니다");
			throw new ServletException("FrontController의 Action이 null입니다");
		}
		
		AbstractAction action=(AbstractAction)instance;
		//----------------------------------------------------------
		
		try {
		action.execute(request, response);
		
		String viewPage=action.getViewPage();
		boolean isRedirect=action.isRedirect();
		
		if(isRedirect) {
			//redirect방식으로 이동
			response.sendRedirect(viewPage);
			
		}else {
			//forward방식으로 이동
			RequestDispatcher disp=request.getRequestDispatcher(viewPage);
			disp.forward(request, response);
			//서버 내부에서 이동, 이 때 request, response를 가져감
			
			
		}
		
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}
