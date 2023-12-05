package memberone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;



public class ZipCodeVO {
	private String zipcode;
	private String sido;
	private String gugun;
	private String dong;
	private String ri;
	private String bunji;
	
	public String getRi() {
		return ri;
	}
	public void setRi(String ri) {
		this.ri = ri;
	}
	public String getZipcode() {
	return zipcode;
	}
	public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
	}
	public String getSido() {
	return sido;
	}
	public void setSido(String sido) {
	this.sido = sido;
	}
	public String getGugun() {
	return gugun;
	}
	public void setGugun(String gugun) {
	this.gugun = gugun;
	}
	public String getDong() {
	return dong;
	}
	public void setDong(String dong) {
	this.dong = dong;
	}
	public String getBunji() {
	return bunji;
	}
	public void setBunji(String bunji) {
	this.bunji = bunji;
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
		tempZipcode.setRi(rs.getString("ri"));
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
	private Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
	}
