package bbs;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//화면을 출력해야 할 내용

public class VisitList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request,HttpServletResponse response)
			 throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		 try {
			 out.println("<html>");
			 out.println("<head><title>방명록 리스트</title></head>");
			 out.println("<body>");
			 StringBuffer sql = new StringBuffer();
			 sql.append("select no, writer, memo, regdate ");
			 sql.append("from visit ");
			 sql.append("order by no desc ");
			 Connection con = null;
			 PreparedStatement pstmt = null;
			 ResultSet rs = null;
			 
			 try{
				 Class.forName("oracle.jdbc.driver.OracleDriver");
				 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr", "hr");
				 pstmt = con.prepareStatement(sql.toString());
				 rs = pstmt.executeQuery();
				 while(rs.next()){
				 int no = rs.getInt("no");
				 String writer = rs.getString("writer");
				 String memo = rs.getString("memo");
				 java.sql.Date regdate = rs.getDate("regdate");
				 out.println("<table align=center width=500 border=1>");
				 out.println("<tr>");
				 out.println("<th width=50>번호</th>");
				 out.println("<td width=50 align=center>"+ no +"</td>");
				 out.println("<th width=70>작성자</th>");
				 out.println("<td width=180 align=center>"+ writer +"</td>");
				 out.println("<th width=50>날짜</th>");
				 out.println("<td width=100 align=center>"+ regdate+"</td>");
				 out.println("</tr>");
				 out.println("<tr>");
				 out.println("<th width=50>내용</th>");
				 out.println("<td colspan=5>&nbsp;<textarea rows=3 cols=50>" + memo + "</textarea></td>");
				 out.println("</tr>");
				 out.println("</table>");
				 out.println("<p>");
				 }
			}catch(SQLException e){
				 e.printStackTrace();
		    }catch(ClassNotFoundException e){
				 e.printStackTrace();
		   }finally{
				 try{if(pstmt != null)pstmt.close();}catch(SQLException e){}
				 try{if(con != null)con.close();}catch(SQLException e){}
		   }
		   out.println("<p align=center><a href=/jsptest/bbs/write.html>글쓰기</a></p>");
		   out.println("</body>");
		   out.println("</html>");
		   } finally {
		   out.close();
		   }
		}  
	@Override
	 protected void doGet(HttpServletRequest request,HttpServletResponse response)
			 throws ServletException, IOException {
		 processRequest(request, response);
	 }
	 @Override
	 protected void doPost(HttpServletRequest request,HttpServletResponse response)
			 throws ServletException, IOException {
		 processRequest(request, response);
	 }

}
