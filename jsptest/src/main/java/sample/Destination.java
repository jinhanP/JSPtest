package sample;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


public class Destination extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Destination() {
        super();
    
    }

	
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	//String name=(String) request.getAttribute("name");
    	//String age= (String) request.getParameter("age");
    	//String age= (String) request.getParameter("age");
    	//내가 요청하는거기 때문에 request.getParameter("age");
    	
    	HttpSession session = request.getSession(false);
    	//false 를 줘야 기존객체를 주고 없으면 null을 준다.
    	String name = (String) session.getAttribute("name");
    	String age = (String) session.getAttribute("age");
    	
    	response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Destination</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Destination Servlet 입니다</h1>");
            out.println("<h1> "+ name +"---"+ age +"</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally { 
            out.close();
        }
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get post 으로 올지 헷갈리면 메소드 하나 만들어서 확인하기
		processRequest(request,response);
	}

	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
