package board.action;

import board.model.BoardDAO;
import board.model.BoardVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		 String pageNum = request.getParameter("pageNum");
		BoardVO article = new BoardVO();
		 article.setNum(Integer.parseInt(request.getParameter("num")));
		 article.setWriter(request.getParameter("writer"));
		 article.setEmail(request.getParameter("email"));
		 article.setSubject(request.getParameter("subject"));
		 article.setContent(request.getParameter("content"));
		 article.setPass(request.getParameter("pass"));
		BoardDAO dbPro = BoardDAO.getInstance();
		 int check = dbPro.updateArticle(article);
		 request.setAttribute("pageNum", (pageNum));
		 request.setAttribute("check", (check));
		 return "/board/updatePro.jsp";
		 }
		}
