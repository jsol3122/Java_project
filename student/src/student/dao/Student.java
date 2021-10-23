package student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {
	private Connection conn; // ���߿� ȯ�漳������ ������ ���� ����
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String name,value;
	private int code;
	Scanner scan = new Scanner(System.in);
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String username="c##java";
	private String password="bit";
	
	public Student() {
		try { // driver loading
			Class.forName(driver);
			//System.out.println("���Ӽ���1");
		} catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		} 
	
		for(;true;) {
		System.out.println("************");
		System.out.println("    ����");
		System.out.println("************");
		System.out.println("  1. �Է�");
		System.out.println("  2. �˻�");
		System.out.println("  3. ����");
		System.out.println("  4. ����");
		System.out.println("************");
		
		System.out.print("  ��ȣ : ");
		int num = scan.nextInt();
		
		if(num==1) insertArticle();
		else if(num==2) selectArticle();
		else if(num==3) deleteArticle();
		else if(num==4) {System.out.println("���α׷��� �����մϴ�"); break;}
		} // ù �޴� ���
	} // ������
	
	public void getConnection() {
		try {
		conn=DriverManager.getConnection(url, username, password);
		//System.out.println("���Ӽ���2");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	} // ����
	
	public void insertArticle() {
		for(;true;) { // �Է� ���� �޴�����
			System.out.println("************");
			System.out.println("  1. �л�");
			System.out.println("  2. ����");
			System.out.println("  3. ������");
			System.out.println("  4. �����޴�");
			System.out.println("************");
			
			System.out.print("  ��ȣ : ");
			int num = scan.nextInt(); // code ���� ����� num���� ��ü����
			
			if(num==1) { // �̸��� �����̴ϱ� if�� ������ ���� ��
				System.out.print("�̸� �Է� : ");
				name=scan.next();
				System.out.print("�й� �Է� : ");
				value=scan.next();
				code = 1;
			}
			else if(num==2) {
				System.out.print("�̸� �Է� : ");
				name=scan.next();
				System.out.print("���� �Է� : ");
				value=scan.next();
				code = 2;
			}
			else if(num==3) {
				System.out.print("�̸� �Է� : ");
				name=scan.next();
				System.out.print("�μ� �Է� : ");
				value=scan.next();
				code = 3;
			}
			else if(num==4) return;
			
		try { // ���� DB�� �Է�
		this.getConnection(); 
		//System.out.println("���Ӽ���3");
		String sql = "insert into student values(?, ?, ?)";
		
		pstmt = conn.prepareStatement(sql); // �޼ҵ� ���� ����
		pstmt.setString(1, name);
		pstmt.setString(2, value);
		pstmt.setInt(3, code);
		
		pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally { 
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		} // for
	} // �Է�
	
	public void selectArticle() {
		for(;true;) { 
		System.out.println("************");
		System.out.println("  1. �̸��˻�");
		System.out.println("  2. ��ü�˻�");
		System.out.println("  3. �����޴�");
		System.out.println("************");
		
		System.out.print("  ��ȣ : ");
		int num = scan.nextInt();
		
		String sql = "select * from student";
		getConnection();
		
		if(num==1) {
		System.out.print("�˻��� �̸� �Է� : ");
		String n = scan.next();
		try {
			pstmt = conn.prepareStatement(sql+" where name like '%"+n+"%'"); // ����
			rs = pstmt.executeQuery(); // ��������� - ��������x
			
			while(rs.next()) { // �̸��� �����ϴ� if�� ������ �� �� ����
				if(rs.getInt("code")==1) {
				System.out.println("�̸�="+rs.getString("name")+"\t�й�="
									+ rs.getString("value"));
				}else if(rs.getInt("code")==2) {
				System.out.println("�̸�="+rs.getString("name")+"\t����="
									+ rs.getString("value"));
				}else if(rs.getInt("code")==3) {
				System.out.println("�̸�="+rs.getString("name")+"\t�μ�="
									+ rs.getString("value"));
				}
			}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs!=null)rs.close(); 
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // if = 1
		
		else if(num==2) {
			try {
				pstmt = conn.prepareStatement(sql); // ����
				rs = pstmt.executeQuery(); 
				
				while(rs.next()) { // �̸��� �����ϴ� if�� ������ �� �� ����
					if(rs.getInt("code")==1) {
					System.out.println("�̸�="+rs.getString("name")+"\t�й�="
										+ rs.getString("value"));
					}else if(rs.getInt("code")==2) {
					System.out.println("�̸�="+rs.getString("name")+"\t����="
										+ rs.getString("value"));
					}else if(rs.getInt("code")==3) {
					System.out.println("�̸�="+rs.getString("name")+"\t�μ�="
										+ rs.getString("value"));
					}
				}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if(rs!=null)rs.close(); 
						if(pstmt!=null)pstmt.close();
						if(conn!=null)conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			} // if = 2
		
		else if(num==3) return;
		
		} // for
	} // �˻�
		
	public void deleteArticle() {
		String sql = "delete student where name=?";
		getConnection();
		
		System.out.print("������ ���ϴ� �̸� �Է� : ");
		String n = scan.next();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n);
			rs = pstmt.executeQuery(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // ������ ������ �ְ� ���� ������ �����Ѵ�
			try {
				if(pstmt!=null)pstmt.close(); // null�̸� ���� ���ʿ� �����ϱ�
				if(conn!=null)conn.close();
				if(rs!=null)rs.close(); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // ����

	
	public static void main(String[] args) {
		new Student();
	} // main
}
