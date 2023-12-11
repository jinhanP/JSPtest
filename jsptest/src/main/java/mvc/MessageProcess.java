package mvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MessageProcess implements CommandProcess {
	//액션 > 인설트액션 > 컨트롤서블릿(url 이름으로 자동화)
	//인설트액셕
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setAttribute("message", "요청 파라미터로 명령어를 전달");
		 return "/mvc/process.jsp";
	}

}
