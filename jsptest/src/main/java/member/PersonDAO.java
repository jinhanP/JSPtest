package member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbc.ConnectionPool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class PersonDAO  {
	
  
    public void PersonDAO() {}
    
    
    public Vector<PersonVO> getPersonList() { //셀렉트
    ConnectionPool pool = null;
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    Vector<PersonVO> PersonList = new Vector<PersonVO>();
    try {
             pool = ConnectionPool.getInstance();
             //마음대로 가져와서 쓰기위해 pool
             conn = pool.getConnection();
             String strQuery = "select * from Person";
             stmt = conn.createStatement();
             rs = stmt.executeQuery(strQuery);
        while (rs.next()) {
        	PersonVO person = new PersonVO();
        	person.setId (rs.getString("id"));
        	person.setName(rs.getString("name"));
        	person.setEmail(rs.getString("email"));
        		PersonList.add(person);
             }
         } catch (Exception ex) {
              System.out.println("Exception" + ex);
         } finally {
               if(rs!=null)   try{rs.close();}  catch(SQLException e){}
          if(stmt!=null) try{stmt.close();}catch(SQLException e){}
          if(conn!=null) try{conn.close();}catch(SQLException e){}
         }
         return PersonList;
    }
 
    
    public void insertPerson(PersonVO person) {
    	
    }
}
