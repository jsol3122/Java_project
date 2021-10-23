package nested;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO { // DB�� ������ �Է� ���� Ŭ���� DAO ����
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
	} // ������
	
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(url, username, password);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	} // ����
	
	public int insertMember(MemberDTO dto) { // dto�� setter�� ���� ������ �޾ƿ���
		int su=0;
		try {
			this.getConnection(); 
			
			ps = conn.prepareStatement("insert into member values(?, ?, ?)"); 
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getId());
			ps.setString(3, dto.getPwd());
			
			su = ps.executeUpdate(); //  ���� - ���� ����
			
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
			return su; // int���� ������
		
	} // ȸ������ �޼ҵ�
	
	public String selectMember(String id, String pwd) {
		String name = null;
		try {
			String sql = "select * from member where id=? and pwd=?";
			this.getConnection(); 
			
			ps = conn.prepareStatement(sql); 
			ps.setString(1, id);
			ps.setString(2, pwd);
			rs = ps.executeQuery(); //  ���� - �ݵ�� resultset���� return 
			
			// �α����� ���̵��ߺ� �Ƚ�Ű�ϱ� while�Ⱦ��� if�� ���
			if(rs.next()) name = rs.getString("name");
			// rs���� ã�� �� �´°� ���ٸ� null�� �״�� ����
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close(); // rs�� ���� close����� ��
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return name;
	} // �α��� ���� or ����
	
}
