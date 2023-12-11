package mvc.control;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc.action.Action;

import java.io.IOException;
import java.io.PrintWriter;

public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1 저쪽에서 넘어오는걸 utf-8로 받는다
		request.setCharacterEncoding("utf-8");
		//2 페이지를 가져온다.cmd 던져줄 페이지 약속
		String cmd = request.getParameter("cmd");
		//4 cmd가 널이라면
		if (cmd != null) {
		ActionFactory factory = ActionFactory.getInstance();
		//5 factory로 cmd 를 전달
		//컨트롤 서비스가 액션 팩토리 를 만들었고 액션이 객체를 만들고 getAction만들어서 객체불러와 action에게 넘긴다.
		Action action = factory.getAction(cmd);
		//여기서 action.execute 불러서 indexAction에서 실행한다.
		ActionForward af= action.execute(request, response);
		if(af.isRedirect() == true) { //redirect로 해달라는거고
			//index.jsp를 보낸다.
			response.sendRedirect(af.getUrl());
		}else { //forward로 해달라는거
			//forward 였으면 request에 직접 값을 넣었을것이다.
			RequestDispatcher rd = request.getRequestDispatcher(af.getUrl());
			rd.forward(request, response);
		}
	} else {
			//3 페이지요청이 없는 잘못된 명령어 들어오는것이므로 잘못된 메세지가 출력된다.
			// url
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head><title>Error</title></head>");
			out.println("<body>");
			out.println("<h4>올바른 요청이 아닙니다!</h4>");
			out.println("<h4>http://localhost:8080/mvc/test.do?cmd=요청키워드</h4>");
			out.println("</body>");
			out.println("</html>");
			
		}
	}

	
	
	// 생성자도 없으면 자동으로 만들어져서 상관없다.
//    public ControlServlet() {
//        super();
//    }

	// 서비스로 불러주면되서 doget dopost 필요가없다.
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
