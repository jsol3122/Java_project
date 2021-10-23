package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String username="c##java";
	private String password="bit";
	
	private static MemberDAO instance;
	
	public static MemberDAO getInstance() { // 싱글톤 설정 - 동기화 처리도 병행
		synchronized(MemberDAO.class) {
			if(instance == null) { // 맨 처음 한번만 해당
				instance = new MemberDAO(); // 한번만 생성해라
			}
		}
		// System.out.println("instance = "+instance);
		return instance;
	}
	
	public MemberDAO() { 
		try { 
			Class.forName(driver);
		} catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		} 
	} // 생성자
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // getConnection()
	
	public String checkMember(String id) {
		String yn=null;
		getConnection();
		String sql = "select * from membertest where id=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				yn = rs.getString("id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close(); 
				if(conn!=null)conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return yn;
	} // writeMember()
	
	public void insertMember(MemberDTO dto) {
		getConnection();
		String sql = "insert into membertest values(?, ?, ?, ?)";
		
		try {
			ps = conn.prepareStatement(sql); 
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getId());
			ps.setString(3, dto.getPwd());
			ps.setString(4, dto.getMail());
			
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally { 
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close(); 
				if(conn!=null)conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public String loginMember(String id, String pwd) {
		String name = null;
		
		try {
			String sql = "select * from membertest where id=? and pwd=?";
			this.getConnection(); 
			
			ps = conn.prepareStatement(sql); 
			ps.setString(1, id);
			ps.setString(2, pwd);
			rs = ps.executeQuery(); 
			
			if(rs.next()) name = rs.getString("name");
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close(); 
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return name;

	} // loginMember()
	
	public List<MemberDTO> listMember() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		String sql = "select * from membertest order by name"; // 이름으로 오름차순 출력
		// DB연동해서 출력할 때는 java에서 sort할 필요 없이 order by이용하면 간단
		// 데이터의 양이 많아지면 sort돌리는 것이 시간이 굉장히 오래걸리기 떄문에, DB에서 필요한 정보만 select해서 order출력함
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); // 실행 - select 일때 사용
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setMail(rs.getString("mail"));

				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
		} finally { 
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close(); 
				if(conn!=null)conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return list;
	} // listMember()
}
