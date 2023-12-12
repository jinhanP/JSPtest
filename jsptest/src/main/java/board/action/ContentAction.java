package board.action;

import board.model.BoardDAO;
import board.model.BoardVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ContentAction implements CommandAction {

	@Override
		public String requestPro(HttpServletRequest request,
				 HttpServletResponse response)throws Throwable {
				 //해당 글번호
				 int num = Integer.parseInt(request.getParameter("num"));
				 //해당 페이지 번호
				 String pageNum = request.getParameter("pageNum");
				 BoardDAO dbPro = BoardDAO.getInstance();//DB처리
				 //해당 글번호에 대한 해당 레코드
				 BoardVO article = dbPro.getArticle(num);
				 //해당 뷰에서 사용할 속성
				 request.setAttribute("num", new Integer(num));
				 request.setAttribute("pageNum", new Integer(pageNum));
				 request.setAttribute("article", article);
				 return "/board/content.jsp";//해당 뷰
	}

}
