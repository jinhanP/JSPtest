package mvcMem.control;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvcMem.action.Action;

public class MemControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    	   
    	request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset=utf-8");
    	String cmd = request.getParameter("cmd");
    	if(cmd != null) {
    		ActionFactory factory = ActionFactory.getInstance();
    		Action action = factory.getAction(cmd);
    		ActionForward af = action.execute(request, response);
    		// Redirect 사용여부, false이면 Forward 사용
    		if(af.isRedirect()) {
    			response.sendRedirect(af.getUrl());
    		}else {
    			RequestDispatcher rd = request.getRequestDispatcher(af.getUrl());
    			rd.forward(request, response);
    		}
    	}else {
    		PrintWriter out = response.getWriter();
    		out.println("<html>");
    		out.println("<head><title>Error</title></head>");
    		out.println("<body>");
    		out.println("<h4>올바른 요청이 아닙니다!!</h4>");
    		out.println("<h4>http://localhost:8080/myWeb/mvcMem/member.mdo?cmd=요청키워드</h4>");
    		out.println("</body>");
    		out.println("</html>");
    	}
    	   
       }// end service
  
		/*
		 * public MemControlServlet() { super(); }
		 * 
		 * 
		 * protected void doGet(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException {
		 * response.getWriter().append("Served at: ").append(request.getContextPath());
		 * }
		 * 
		 * 
		 * protected void doPost(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException { doGet(request, response); }
		 */
}
