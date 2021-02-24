package com.lec.java.db02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DB02Main {

	// 1. Oracle 연동을 위한 정보들(상수들)을 정의(세팅)
	// JDBC 드라이버 클래스 정보
	public static final String DRIVER =
			"oracle.jdbc.driver.OracleDriver";
	// DB 서버 정보
	public static final String URL =
			"jdbc:oracle:thin:@localhost:1521:XE";
	// DB 사용자 계정 정보
	public static final String USER = "scott26";
	public static final String PASSWD = "tiger26";

	public static final String TBL_NAME = "test_member";
	public static final String COL_LABEL_NO = "mb_no";
	public static final String COL_LABEL_NAME = "mb_name";
	public static final String COL_LABEL_BIRTHDATE = "mb_birthdate";

	public static void main(String[] args) {
		System.out.println("DB 2 - Statement");
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName(DRIVER);
			System.out.println("DB 드라이버 로딩 성공");
			
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("DB Connection 성공");
			
			stmt = conn.createStatement();
			System.out.println("Statement 생성 성공");
			
			String sql = "";
			
			// SQL문이 문자열로 조립해야 하는 상황!  SQL 구문 주의! 띄어쓰기, 콤마, 구두점들...
			sql = "UPDATE " + TBL_NAME + " SET "
					+ COL_LABEL_NAME + " = '슈퍼맨', " 
					+ COL_LABEL_BIRTHDATE + " = '1966-07-17'"
					+ " WHERE " + COL_LABEL_NO + " = 100"
					; 
			System.out.println(sql);  // 내가 만든 쿼리문 눈으로도 확인해보자
			int cnt = stmt.executeUpdate(sql);
			System.out.println(cnt + "개 행(row) UPDATE 성공");
			
			
					
			
			sql = "SELECT * FROM " + TBL_NAME;
			System.out.println(sql);
	
			rs = stmt.executeQuery(sql);		
			while(rs.next()) {
				String no = rs.getString(COL_LABEL_NO);
				String name = rs.getString(COL_LABEL_NAME);
				String birthdate = rs.getString(COL_LABEL_BIRTHDATE);
				System.out.println(no + "\t|" + name + "\t|" + birthdate);			
			} // end while
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 8. 자원 반납
				// 나중에 만들어진 인스턴스들을 먼저 close 한다.
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	} // end main()

} // end class DB02Main













