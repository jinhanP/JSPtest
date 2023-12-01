package bbs;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class VisitInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String writer;
    private String memo;
   
    public VisitInsert() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request로 값을 가져온다. 패턴검색 
		writer = request.getParameter("writer");
		memo = request.getParameter("memo");
		System.out.println("writer = "+ writer);
		System.out.println("memo = "+ memo);
		
		//데이터베이스 저장 오라클 insert
		StringBuffer query = new StringBuffer();
		query.append("insert into visit(no, writer,memo,regdate) values(visit_seq.nextval,?,?,sysdate)");
		//데이터베이스 연결
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "HR", "hr");
				ps = con.prepareStatement(query.toString());
				ps.setString(1, writer);
				ps.setString(2, memo);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//보여줄 화면설계된 페이지 요청 (다음 창에 연결)
//		response.sendRedirect("VisitList");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
