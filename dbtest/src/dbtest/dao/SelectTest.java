package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	
	public SelectTest() { // 드라이버 로딩 - 생성자
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // getConnection()
	
	public void selectArticle() { // select는 외부로부터 scanner로 데이터받을 필요 x
		String sql = "select * from dbtest";
		getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql); // 생성
			rs = pstmt.executeQuery(); // 결과물리턴 - 수정갯수x
			
			while(rs.next()) {
				System.out.println(rs.getString("name")+"\t"
									+ rs.getInt("age")+"\t"
									+ rs.getDouble("height")+"\t"
									+ rs.getString("logtime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close(); // rs도 꼭 close해줘야 함!!
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		SelectTest st = new SelectTest();
		st.selectArticle();		
	} // main

}
