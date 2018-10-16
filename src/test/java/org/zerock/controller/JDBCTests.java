package org.zerock.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	
	@Test
	public void testConnection() throws Exception {
		
		log.info("test connection start.........");
		
		String url = "jdbc:mysql://10.10.10.101:3306/honeyrock?useSSL=false&serverTimezone=Asia/Seoul";
		String id = "injae";
		String pw = "12345678";

		Class.forName("com.mysql.cj.jdbc.Driver");  

		Connection con = DriverManager.getConnection(url, id, pw);
		
		log.info(con);
		
		PreparedStatement pstmt = con.prepareStatement("select * from honeyrock.tbl_sample");	
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			log.info(rs.getString(1));
		}
		
		rs.close();
		pstmt.close();
		con.close();
	}
}
