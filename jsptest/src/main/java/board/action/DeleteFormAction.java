package board.action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int num = Integer.parseInt(request.getParameter("num"));
		 String pageNum = request.getParameter("pageNum");
		//해당 뷰에서 사용할 속성
		 request.setAttribute("num", (num));
		  request.setAttribute("pageNum", (pageNum));
		  return "/board/deleteForm.jsp";//해당뷰
	}

}
