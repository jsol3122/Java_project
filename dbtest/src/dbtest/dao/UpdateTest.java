package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTest {
	private Connection conn;
	private PreparedStatement pstmt;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	
	public UpdateTest() {
		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	} // 생성자
	
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("접속성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // getConnection()
	
	public void insertArticle() {
		Scanner scan = new Scanner(System.in);
		System.out.print("수정할 이름 입력 : ");
		String name = scan.next();
		
		
		try {
			this.getConnection();
			pstmt = conn.prepareStatement("update dbtest set age=age+1, height=height-1 where name like '%"+name+"%'");
			// 이름변수를 ?로 주고 따로 매핑할 경우, "%"+name+"%" 로 해서 '' 안에 안넣어도 됨 --> sql문 안에서만 ''맞춰주면됨
			// pstmt.setString(1, "%"+name+"%"); 처럼 쓰면 됨
			int su = pstmt.executeUpdate();
			System.out.println(su+"개의 행을 수정하였습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//-------------------------------------------------
	public static void main(String[] args) {
		UpdateTest ut = new UpdateTest();
		ut.insertArticle();		
	} // main
}
