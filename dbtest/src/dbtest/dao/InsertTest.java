package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertTest {
	private Connection conn; // java.sql ��Ű�� / interface��
	private PreparedStatement pstmt; // ��״� ���� ���ϰ� ���� ������ null�� �������� / interface��
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	// driver�� ������Ű��, oracle�ߴٰ� mysql�ߴٰ� �ٲܶ����� �ٽ� �� �ٲ���� �ϴϱ� �ʵ忡 ����
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String username="c##java";
	private String password="bit";
	
	public InsertTest() {
		try {
		// driver loading
		Class.forName(driver); // ���ϸ��� �ָ� ClassŸ������ �������ְڴ� - ���ϸ��� ��Ű������� Ǯ��������
		System.out.println("����̹� �ε� ����");
		} // try���� - �����߻����� / ���� �ȶ߸� catch�Ȱ�ħ
		catch(ClassNotFoundException e) {
			e.printStackTrace(); // �������� ��� - �̰� �������
		} // 
	} // ������
	
	public void getConnection() {
		try {
		conn=DriverManager.getConnection(url, username, password); // static�̶� new���ص���
		System.out.println("���Ӽ���");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertArticle() {
		Scanner scan = new Scanner(System.in);
		System.out.print("�̸� �Է� : ");
		String name=scan.next();
		System.out.print("���� �Է� : ");
		int age=scan.nextInt();
		System.out.print("Ű �Է� : ");
		Double height=scan.nextDouble();
		
		try {
		this.getConnection(); // sql���� ������ �� connection���ִ� ����
		
		pstmt = conn.prepareStatement("insert into dbtest values(?, ?, ?, sysdate)"); // �޼ҵ� ���� ����
		pstmt.setString(1,name);
		pstmt.setInt(2, age);
		pstmt.setDouble(3, height);
		
		int su = pstmt.executeUpdate(); //  ���� - ���� ����
		System.out.println(su+"���� ���� ����������ϴ�");
		
		} catch(SQLException e) {
			e.printStackTrace();
		} finally { // ������ ������ �ְ� ���� ������ �����Ѵ�
			try {
				if(pstmt!=null)pstmt.close(); // null�̸� ���� ���ʿ� �����ϱ�
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		InsertTest it = new InsertTest();
		it.insertArticle();
	}

}
