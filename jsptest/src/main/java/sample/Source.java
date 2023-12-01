package sample;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


public class Source extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Source() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("start point");
		//Forward 이동방법
		//값을 가져와서 분석하고 -> 디비 (CURD)
		//데이터 찍어주기
//		request.setAttribute("name", "Park.J.H");		
		//화면에(view) 뿌려줄 서블릿 콜한다.
//		RequestDispatcher rd =request.getRequestDispatcher("Destination");
//		//Destination 값을 받아야 되서 새로 만들기
//		rd.forward(request, response);
		
		
		//Redirect 이동 방법 넘어오는데 값은 안넘어 오니깐 값을 주고 싶을걸 저장한다.
		HttpSession session = request.getSession();
		String age = request.getParameter("age");
		session.setAttribute("name", "Park.J.H");
		session.setAttribute("age", age);
		response.sendRedirect("Destination");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
