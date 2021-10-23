package mini;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String username="c##java";
	private String password="bit";
	
	public MemberDAO() {
		try { 
			Class.forName(driver);
		} catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		} 
	} // 积己磊
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // 立加
	
	public void insertMember(MemberDTO dto) {
		getConnection();
		String sql = "insert into member values(?, ?, ? , ?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getPwd());
			ps.setString(4, dto.getEmail());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			try {
				if(ps!=null)ps.close(); 
				if(conn!=null)conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	} // insertMember
	
	public String checkId(String id) {
		String name = null;
		getConnection();
		String sql = "select * from member where id = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			if(rs.next()) name = rs.getString("name");
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
		return name;
	} // checkId
	
	public int deleteMember(String pwdCheck) {
		int su = 0;
		getConnection();
		String sql = "delete member where pwd = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pwdCheck);
			
			su = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			try {
				if(ps!=null)ps.close(); 
				if(conn!=null)conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return su;
	} // deleteMember
	
	public String loginMember(String id, String pwd) {
		String check = null;
		getConnection();
		String sql = "select * from member where id = ? and pwd = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			
			rs = ps.executeQuery();
			if(rs.next()) check = rs.getString("id");
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
		return check;		
	}

	public int updateMember(String id, String pwd, String email, String pwdCheck) {
		int su = 0;
		getConnection();
		String sql = "update member set id=?, pwd=?, email=? where pwd=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			ps.setString(3, email);
			ps.setString(4, pwdCheck);
			
			su = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return su;
	}
}
