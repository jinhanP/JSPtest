package jdbc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class TempMemberDAO  {
	
  
    public void tempMemberDAO() {}
    
    
    public Vector<TempMemberVO> getMemberList() {
    ConnectionPool pool = null;
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    Vector<TempMemberVO> vecList = new Vector<TempMemberVO>();
    try {
             pool = ConnectionPool.getInstance();
             conn = pool.getConnection();
             String strQuery = "select * from tempMember";
             stmt = conn.createStatement();
             rs = stmt.executeQuery(strQuery);
        while (rs.next()) {
          TempMemberVO vo = new TempMemberVO();
         vo.setId (rs.getString("id"));
         vo.setPasswd (rs.getString("passwd"));
          vo.setName (rs.getString("name"));
          vo.setMem_num1 (rs.getString("mem_num1"));
          vo.setMem_num2 (rs.getString("mem_num2"));
          vo.setEmail (rs.getString("e_mail"));
          vo.setPhone (rs.getString("phone"));
          vo.setZipcode (rs.getString("zipcode"));
          vo.setAddress (rs.getString("address"));
          vo.setJob (rs.getString("job"));
                  vecList.add(vo);
             }
         } catch (Exception ex) {
              System.out.println("Exception" + ex);
         } finally {
               if(rs!=null)   try{rs.close();}  catch(SQLException e){}
          if(stmt!=null) try{stmt.close();}catch(SQLException e){}
          if(conn!=null) try{conn.close();}catch(SQLException e){}
         }
         return vecList;
    }
 
}
