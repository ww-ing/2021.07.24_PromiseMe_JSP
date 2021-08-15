package common.util;
import javax.servlet.http.*;

public class CommonUtil {
	
	public static void addMsgLoc(HttpServletRequest req, String message, String loc) {
		req.setAttribute("message", message);
		req.setAttribute("loc", loc);
		
	}
	
	public static void addMsgBack(HttpServletRequest req, String message) {
		req.setAttribute("message", message);
		req.setAttribute("loc", "javascript:history.back()");
		
	}

}
