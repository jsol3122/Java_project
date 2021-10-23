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
			System.out.println("����̹� �ε� ����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	} // ������
	
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("���Ӽ���");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // getConnection()
	
	public void insertArticle() {
		Scanner scan = new Scanner(System.in);
		System.out.print("������ �̸� �Է� : ");
		String name = scan.next();
		
		
		try {
			this.getConnection();
			pstmt = conn.prepareStatement("update dbtest set age=age+1, height=height-1 where name like '%"+name+"%'");
			// �̸������� ?�� �ְ� ���� ������ ���, "%"+name+"%" �� �ؼ� '' �ȿ� �ȳ־ �� --> sql�� �ȿ����� ''�����ָ��
			// pstmt.setString(1, "%"+name+"%"); ó�� ���� ��
			int su = pstmt.executeUpdate();
			System.out.println(su+"���� ���� �����Ͽ����ϴ�");
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
