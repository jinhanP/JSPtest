package sample;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LifeCycle() {
        super();
       System.out.println("LifeCycle constructor");
    }

	
	public void init(ServletConfig config) throws ServletException {
		 System.out.println("init");
	}

	
	public void destroy() {
		System.out.println("destroy");
	}

	
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("service");
//		service 를 부르면 doGet , doPost 는 없어도 된다.
//	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
	}

}
