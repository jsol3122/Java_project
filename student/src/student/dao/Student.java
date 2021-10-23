package student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {
	private Connection conn; // 나중에 환경설정으로 빼버릴 수도 있음
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
			//System.out.println("접속성공1");
		} catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		} 
	
		for(;true;) {
		System.out.println("************");
		System.out.println("    관리");
		System.out.println("************");
		System.out.println("  1. 입력");
		System.out.println("  2. 검색");
		System.out.println("  3. 삭제");
		System.out.println("  4. 종료");
		System.out.println("************");
		
		System.out.print("  번호 : ");
		int num = scan.nextInt();
		
		if(num==1) insertArticle();
		else if(num==2) selectArticle();
		else if(num==3) deleteArticle();
		else if(num==4) {System.out.println("프로그램을 종료합니다"); break;}
		} // 첫 메뉴 출력
	} // 생성자
	
	public void getConnection() {
		try {
		conn=DriverManager.getConnection(url, username, password);
		//System.out.println("접속성공2");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	} // 접속
	
	public void insertArticle() {
		for(;true;) { // 입력 내부 메뉴선택
			System.out.println("************");
			System.out.println("  1. 학생");
			System.out.println("  2. 교수");
			System.out.println("  3. 관리자");
			System.out.println("  4. 이전메뉴");
			System.out.println("************");
			
			System.out.print("  번호 : ");
			int num = scan.nextInt(); // code 따로 안잡고 num으로 대체가능
			
			if(num==1) { // 이름은 공통이니까 if문 밖으로 빼도 됨
				System.out.print("이름 입력 : ");
				name=scan.next();
				System.out.print("학번 입력 : ");
				value=scan.next();
				code = 1;
			}
			else if(num==2) {
				System.out.print("이름 입력 : ");
				name=scan.next();
				System.out.print("과목 입력 : ");
				value=scan.next();
				code = 2;
			}
			else if(num==3) {
				System.out.print("이름 입력 : ");
				name=scan.next();
				System.out.print("부서 입력 : ");
				value=scan.next();
				code = 3;
			}
			else if(num==4) return;
			
		try { // 실제 DB로 입력
		this.getConnection(); 
		//System.out.println("접속성공3");
		String sql = "insert into student values(?, ?, ?)";
		
		pstmt = conn.prepareStatement(sql); // 메소드 통해 생성
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
	} // 입력
	
	public void selectArticle() {
		for(;true;) { 
		System.out.println("************");
		System.out.println("  1. 이름검색");
		System.out.println("  2. 전체검색");
		System.out.println("  3. 이전메뉴");
		System.out.println("************");
		
		System.out.print("  번호 : ");
		int num = scan.nextInt();
		
		String sql = "select * from student";
		getConnection();
		
		if(num==1) {
		System.out.print("검색할 이름 입력 : ");
		String n = scan.next();
		try {
			pstmt = conn.prepareStatement(sql+" where name like '%"+n+"%'"); // 생성
			rs = pstmt.executeQuery(); // 결과물리턴 - 수정갯수x
			
			while(rs.next()) { // 이름은 동일하니 if문 밖으로 뺄 수 있음
				if(rs.getInt("code")==1) {
				System.out.println("이름="+rs.getString("name")+"\t학번="
									+ rs.getString("value"));
				}else if(rs.getInt("code")==2) {
				System.out.println("이름="+rs.getString("name")+"\t과목="
									+ rs.getString("value"));
				}else if(rs.getInt("code")==3) {
				System.out.println("이름="+rs.getString("name")+"\t부서="
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
				pstmt = conn.prepareStatement(sql); // 생성
				rs = pstmt.executeQuery(); 
				
				while(rs.next()) { // 이름은 동일하니 if문 밖으로 뺄 수 있음
					if(rs.getInt("code")==1) {
					System.out.println("이름="+rs.getString("name")+"\t학번="
										+ rs.getString("value"));
					}else if(rs.getInt("code")==2) {
					System.out.println("이름="+rs.getString("name")+"\t과목="
										+ rs.getString("value"));
					}else if(rs.getInt("code")==3) {
					System.out.println("이름="+rs.getString("name")+"\t부서="
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
	} // 검색
		
	public void deleteArticle() {
		String sql = "delete student where name=?";
		getConnection();
		
		System.out.print("삭제를 원하는 이름 입력 : ");
		String n = scan.next();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n);
			rs = pstmt.executeQuery(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 위에서 에러가 있건 없건 무조건 실행한다
			try {
				if(pstmt!=null)pstmt.close(); // null이면 굳이 끌필요 없으니까
				if(conn!=null)conn.close();
				if(rs!=null)rs.close(); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // 삭제

	
	public static void main(String[] args) {
		new Student();
	} // main
}
