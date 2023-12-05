package memberone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class StudentDAO {
	private Connection getConnection() {
		Connection conn = null;
		try {
			InitialContext init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/myOracle");
			 conn = ds.getConnection();

		}catch(Exception e) {
			System.out.println("Connection 생성 실패");
		}
	
		return conn;
	}
	public boolean idCheck(String id) {
		boolean result = true;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from student where id = ?");
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			if(!rs.next()) result = false;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}finally {
			if(rs != null)try{rs.close();}catch (SQLException sqle1) {}
			if(pstmt != null)try{pstmt.close();}catch(SQLException sqle2){}
			 if(conn != null)try{conn.close();}catch(SQLException sqle3){}
		}
		return false;
		
	}
	public boolean memberInsert(StudentVO vo) {
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 boolean flag = false;
		 try {
		 conn = getConnection();
		 String strQuery = "insert into student values(?,?,?,?,?,?,?,?,?,?)";
		 pstmt = conn.prepareStatement(strQuery);
		 pstmt.setString(1,vo.getId());
		 pstmt.setString(2,vo.getPass());
		 pstmt.setString(3,vo.getName());
		 pstmt.setString(4,vo.getPhone1());
		 pstmt.setString(5,vo.getPhone2());
		 pstmt.setString(6,vo.getPhone3());
		 pstmt.setString(7,vo.getEmail());
		 pstmt.setString(8,vo.getZipcode());
		 pstmt.setString(9,vo.getAddress1());
		 pstmt.setString(10,vo.getAddress2());
		 int count = pstmt.executeUpdate();
		 if(count>0)flag = true;
		 }catch(Exception ex) {
		 System.out.println("Exception" + ex);
		 }finally{
		if(rs != null)try{rs.close();}catch(SQLException sqle1){}
		if(pstmt != null)try{pstmt.close();}catch(SQLException sqle2){}
		if(conn != null)try{conn.close();}catch(SQLException sqle3){}
		 }
		return flag;
	}
	public Vector<ZipCodeVO> zipcodeRead(String dong) {
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 Vector<ZipCodeVO> vecList = new Vector<ZipCodeVO>();
		 try {
		conn = getConnection();
		String strQuery =
		"select * from zipcode where dong like '"+ dong +"%'";
		pstmt = conn.prepareStatement(strQuery);
		rs = pstmt.executeQuery();
		while(rs.next()){
		ZipCodeVO tempZipcode = new ZipCodeVO();
		tempZipcode.setZipcode(rs.getString("zipcode"));
		tempZipcode.setSido(rs.getString("sido"));
		tempZipcode.setGugun(rs.getString("gugun"));
		tempZipcode.setDong(rs.getString("dong"));
		tempZipcode.setBunji(rs.getString("bunji"));
		vecList.addElement(tempZipcode);
		}
		 }catch(SQLException sqle) {
		sqle.printStackTrace();
		 }finally{
		if(rs != null)try{rs.close();}catch(SQLException sqle1){}
		if(pstmt != null)try{pstmt.close();}catch(SQLException sqle2){}
		if(conn != null)try{conn.close();}catch(SQLException sqle3){}
		 }
		 return vecList;
		}
	
	public int loginCheck(String id, String pass) {
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 int check = -1;
		 try {
		conn = getConnection();
		String strQuery = "select pass from student where id = ?";
		pstmt = conn.prepareStatement(strQuery);
		pstmt.setString(1,id);
		rs = pstmt.executeQuery();
		if(rs.next()){
		String dbPass = rs.getString("pass");
		if(pass.equals(dbPass)) check = 1;
		else check = 0;
		}
		 }catch(Exception ex) {
		System.out.println("Exception" + ex);
		 }finally{
		if(rs != null)try{rs.close();}catch(SQLException sqle1){}
		if(pstmt != null)try{pstmt.close();}catch(SQLException sqle2){}
		if(conn != null)try{conn.close();}catch(SQLException sqle3){}
		 }
		 return check;
		}

}
