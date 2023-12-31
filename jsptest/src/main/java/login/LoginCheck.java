package login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void processRequest(HttpServletRequest request,
			 HttpServletResponse response)
			 throws ServletException, IOException {
			 request.setCharacterEncoding("utf-8");// 한글처리
			 String id = request.getParameter("id");
			 String pwd = request.getParameter("pwd");
			 //db에서 사용자 정보 조회.... 이부분의 코딩을 수정해서 만들어 볼것 //db에서 조회한 사용자의 아이디 비번이 일치하는 경우
			 //클라이언트의 정보를 HttpSession객체에 유지 시킨다.
			 String dbID = "PJH";
			 String dbPWD = "1234";
			 if(dbID.equals(id) && dbPWD.equals(pwd)){
			 //HttpSession객체 얻기
			 HttpSession session = request.getSession();
			//클라이언트의 정보를 HttpSession객체에 저장
			 session.setAttribute("user", id);
			 }else{
				System.out.println("다시 입력해주세요");
			 }
			 response.sendRedirect("Login");
			 }
			
			 @Override
			 protected void doGet(HttpServletRequest request,
			 HttpServletResponse response)
			 throws ServletException, IOException {
			 processRequest(request, response);
			 }
			 @Override
			 protected void doPost(HttpServletRequest request,
			 HttpServletResponse response)
			 throws ServletException, IOException {
			 processRequest(request, response);
			 }
			}

