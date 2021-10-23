package collection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SungJukDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String username="c##java";
	private String password="bit";
	
	public SungJukDAO() { // driver loading
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
	} // 접속

	public void insertArticle(SungJukDTO dto) {
		getConnection();
		
		try {
			ps = conn.prepareStatement("insert into sungjuk values(?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, dto.getNum());
			ps.setString(2, dto.getName());
			ps.setInt(3, dto.getKor());
			ps.setInt(4, dto.getEng());
			ps.setInt(5, dto.getMath());
			ps.setInt(6, dto.getSum());
			ps.setDouble(7, dto.getAvg());
			
			ps.executeUpdate(); // 실행 - insert , update , delete 일때 사용
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
	} // insert
	
	public List<SungJukDTO> printArticle(){
		List<SungJukDTO> list = new ArrayList<SungJukDTO>();
		String sql = "select * from sungjuk";
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); // 실행 - select 일때 사용
			
			while(rs.next()) {
				SungJukDTO dto = new SungJukDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMath(rs.getInt("math"));
				dto.setSum(rs.getInt("sum"));
				dto.setAvg(rs.getDouble("avg"));

				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			list = null; // 오류뜰 걸 대비
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
	} // print
	
	public SungJukDTO searchArticle(int n) {
		SungJukDTO dto=null;
		String sql = "select * from sungjuk where num=?";
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, n);
			
			rs = ps.executeQuery(); // 실행
			
			if(rs.next()) { // 한줄만 결과가 나올테니 hasNext로 반복문 돌릴필요x
				dto = new SungJukDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMath(rs.getInt("math"));
				dto.setSum(rs.getInt("sum"));
				dto.setAvg(rs.getDouble("avg"));
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
		return dto;
	} // search
	
	public int deleteArticle(int n){ // 검색 후 삭제
		int su=0;
		String sql = "delete sungjuk where num=?";
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, n);
			
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
	} // delete
	
	public List<SungJukDTO> sortArticle(int num) {
		List<SungJukDTO> list = new ArrayList<SungJukDTO>();
		String sql = null;
		
		if(num==1) sql = "select * from sungjuk order by name asc";
		if(num==2) sql = "select * from sungjuk order by sum desc";
		
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				SungJukDTO dto = new SungJukDTO(); // 정렬된 dto를 list에 담아서 return하기
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMath(rs.getInt("math"));
				dto.setSum(rs.getInt("sum"));
				dto.setAvg(rs.getDouble("avg"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			list = null; // 중간에 오류나면 오류난 리스트가 DB로 안보내지도록 없애버리는 것(예방책)
		} finally { 
			try {
				if(ps!=null)rs.close();
				if(ps!=null)ps.close(); 
				if(conn!=null)conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return list;
	} // sort
	
}
