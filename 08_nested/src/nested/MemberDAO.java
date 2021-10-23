package nested;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO { // DB에 데이터 입력 전용 클래스 DAO 설정
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String username="c##java";
	private String password="bit";
	
	public MemberDAO() {
		try { // driver loading
			Class.forName(driver);
		} catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		} 
	} // 생성자
	
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(url, username, password);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	} // 접속
	
	public int insertMember(MemberDTO dto) { // dto의 setter에 담은 데이터 받아오기
		int su=0;
		try {
			this.getConnection(); 
			
			ps = conn.prepareStatement("insert into member values(?, ?, ?)"); 
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getId());
			ps.setString(3, dto.getPwd());
			
			su = ps.executeUpdate(); //  실행 - 개수 리턴
			
			} catch(SQLException e1) {
				e1.printStackTrace();
			} finally { 
				try {
					if(ps!=null)ps.close(); 
					if(conn!=null)conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			return su; // int값을 리턴함
		
	} // 회원가입 메소드
	
	public String selectMember(String id, String pwd) {
		String name = null;
		try {
			String sql = "select * from member where id=? and pwd=?";
			this.getConnection(); 
			
			ps = conn.prepareStatement(sql); 
			ps.setString(1, id);
			ps.setString(2, pwd);
			rs = ps.executeQuery(); //  실행 - 반드시 resultset으로 return 
			
			// 로그인은 아이디중복 안시키니까 while안쓰고 if문 사용
			if(rs.next()) name = rs.getString("name");
			// rs에서 찾을 때 맞는게 없다면 null값 그대로 유지
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close(); // rs를 먼저 close해줘야 함
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return name;
	} // 로그인 성공 or 실패
	
}
