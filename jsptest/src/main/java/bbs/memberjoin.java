package bbs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class memberjoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String id;
	private String password;
	private String name;
	private String phone;
	private String email;
	private String gender;
	private String address;
   
    public memberjoin() {
        super();
       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		id = request.getParameter("id");
		password = request.getParameter("password");
		name = request.getParameter("name");
		phone = request.getParameter("phone");
		email = request.getParameter("email");
		gender = request.getParameter("gender");
		address = request.getParameter("address");
		System.out.println("id = " + id);
		System.out.println("password = " + password);
		System.out.println("name = " + name);
		System.out.println("phone = " + phone);
		System.out.println("email = " + email);
		System.out.println("gender = " + gender);
		System.out.println("address = " + address);

		// 데이터베이스 저장 오라클 insert
		StringBuffer query = new StringBuffer();
		query.append("insert into memberjoin(id,password,name,phone,email,gender,address) "
				+ "values(?,?,?,?,?,?,?)");
		// 데이터베이스 연결
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "HR", "hr");
				ps = con.prepareStatement(query.toString());
				ps.setString(1, id);
				ps.setString(2, password);
				ps.setString(3, name);
				ps.setString(4, phone);
				ps.setString(5, email);
				ps.setString(6, gender);
				ps.setString(7, address);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		// 보여줄 화면설계된 페이지 요청 (다음 창에 연결)
		response.sendRedirect("Login");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
