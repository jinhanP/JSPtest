package mvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberProcess implements CommandProcess {
	//액션 > 인설트액션 > 컨트롤서블릿(url 이름으로 자동화)
	//인설트액셕
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setAttribute("message", "멤버 프로세스 실행 결과 전달");
		 return "/mvc/process.jsp";
	}

}
