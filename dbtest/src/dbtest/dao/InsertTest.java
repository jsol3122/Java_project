package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertTest {
	private Connection conn; // java.sql 패키지 / interface임
	private PreparedStatement pstmt; // 얘네는 생성 안하고 선언만 했으니 null값 갖고있음 / interface임
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	// driver를 고정시키면, oracle했다가 mysql했다가 바꿀때마다 다시 다 바꿔줘야 하니까 필드에 설정
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String username="c##java";
	private String password="bit";
	
	public InsertTest() {
		try {
		// driver loading
		Class.forName(driver); // 파일명을 주면 Class타입으로 생성해주겠다 - 파일명은 패키지명까지 풀네임으로
		System.out.println("드라이버 로딩 성공");
		} // try구역 - 에러발생구역 / 에러 안뜨면 catch안거침
		catch(ClassNotFoundException e) {
			e.printStackTrace(); // 에러내용 출력 - 이거 꼭써야함
		} // 
	} // 생성자
	
	public void getConnection() {
		try {
		conn=DriverManager.getConnection(url, username, password); // static이라 new안해도됨
		System.out.println("접속성공");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertArticle() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String name=scan.next();
		System.out.print("나이 입력 : ");
		int age=scan.nextInt();
		System.out.print("키 입력 : ");
		Double height=scan.nextDouble();
		
		try {
		this.getConnection(); // sql문장 실행할 때 connection해주는 것임
		
		pstmt = conn.prepareStatement("insert into dbtest values(?, ?, ?, sysdate)"); // 메소드 통해 생성
		pstmt.setString(1,name);
		pstmt.setInt(2, age);
		pstmt.setDouble(3, height);
		
		int su = pstmt.executeUpdate(); //  실행 - 개수 리턴
		System.out.println(su+"개의 행이 만들어졌습니다");
		
		} catch(SQLException e) {
			e.printStackTrace();
		} finally { // 위에서 에러가 있건 없건 무조건 실행한다
			try {
				if(pstmt!=null)pstmt.close(); // null이면 굳이 끌필요 없으니까
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
