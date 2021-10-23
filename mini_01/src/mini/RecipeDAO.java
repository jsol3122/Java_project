package mini;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class RecipeDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	
	private static RecipeDAO instance; 
	
	
	public static RecipeDAO getInstance() { //�̱���
		synchronized (RecipeDAO.class) {
			if(instance == null)
				instance = new RecipeDAO();
		}
		
		return instance;
	}//RecipeDAO getInstance()
	
	
	public RecipeDAO() { //������
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}//RecipeDAO()
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//getConnection()
//----------------------------------------------------------	
	public void recipeWrite(RecipeDTO dto) { //������ ���
		String sql = "insert into recipe values(?, ?, ?, ?, ?)";
		getConnection(); //����
		
		try {
			pstmt = conn.prepareStatement(sql); //����
			pstmt.setString(1, dto.getRecipeName());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getCategory());
			pstmt.setString(4, dto.getRecipeDetail());
			pstmt.setString(5, dto.getRecipeImg());
			
			pstmt.executeUpdate(); //����
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(null, "�����ǰ� ��� �Ϸ�Ǿ����ϴ�");
	}//recipeWrite(RecipeDTO dto)
//-------------------------------------------------------------------
	public List<RecipeDTO> categorySearch(String category) { // �ѽ�, ���, �߽�, �Ͻ� ������ ���
		List<RecipeDTO> list = new ArrayList<RecipeDTO>();
		String sql = "select * from recipe where category=? order by recipeName";
		getConnection(); // ����

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);

			rs = pstmt.executeQuery(); // ����

			while (rs.next()) {
				RecipeDTO dto = new RecipeDTO();
				dto.setRecipeName(rs.getString("recipeName"));
				dto.setId(rs.getString("id"));
				dto.setCategory(rs.getString("category"));
				dto.setRecipeDetail(rs.getString("recipeDetail"));
				dto.setRecipeImg(rs.getString("recipeImg"));

				list.add(dto);
			} // while

		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
//-------------------------------------------------------------------------	
	public List<RecipeDTO> idSearch(String id) { // ���̵�� �˻�(�� ������ ����)
		List<RecipeDTO> list = new ArrayList<RecipeDTO>();
		String sql = "select * from recipe where id=? order by recipeName";
		getConnection(); // ����

		try {
			pstmt = conn.prepareStatement(sql); // ����
			pstmt.setString(1, id);

			rs = pstmt.executeQuery(); // ����

			while (rs.next()) {
				RecipeDTO dto = new RecipeDTO();
				dto.setRecipeName(rs.getString("recipeName"));
				dto.setId(rs.getString("id"));
				dto.setCategory(rs.getString("category"));
				dto.setRecipeDetail(rs.getString("recipeDetail"));
				dto.setRecipeImg(rs.getString("recipeImg"));

				list.add(dto);
			} // while

		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
//-------------------------------------------------------------------------	
	public List<RecipeDTO> recipeNameSearch(String recipeName) { // �����Ǹ� �˻� (�˻�â)
		List<RecipeDTO> list = new ArrayList<RecipeDTO>();
		String sql = "select * from recipe where recipeName like ? order by recipeName";
		getConnection(); // ����

		try {
			pstmt = conn.prepareStatement(sql); // ����
			pstmt.setString(1, "%" + recipeName + "%");

			rs = pstmt.executeQuery(); // ����

			while (rs.next()) {
				RecipeDTO dto = new RecipeDTO();
				dto.setRecipeName(rs.getString("recipeName"));
				dto.setId(rs.getString("id"));
				dto.setCategory(rs.getString("category"));
				dto.setRecipeDetail(rs.getString("recipeDetail"));
				dto.setRecipeImg(rs.getString("recipeImg"));

				list.add(dto);
			}// while

		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
//-------------------------------------------------------------------------		
	public RecipeDTO recipeUpdate(RecipeDTO dto, String recipeName) { // ������ ����
		String sql = "update recipe set recipeName=?,category=?,recipeDetail=?,recipeImg=? where id=? and recipeName=?";
		getConnection(); // ����

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getRecipeName());
			pstmt.setString(2, dto.getCategory());
			pstmt.setString(3, dto.getRecipeDetail());
			pstmt.setString(4, dto.getRecipeImg());
			pstmt.setString(5, dto.getId());
			pstmt.setString(6, recipeName);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

//-------------------------------------------------------------------------	
	public int recipeDelete(String id, String recipeName) { // ������ ����
		int su=0;
		String sql = "delete recipe where id=? and recipeName=?";
		getConnection(); // ����

		try {
			pstmt = conn.prepareStatement(sql); // ����
			pstmt.setString(1, id);
			pstmt.setString(2, recipeName);

			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return su;
	}// recipeDelete(String id, String recipeName)
//----------------------------------------------------------------	
	public RecipeDTO detailSearch(String recipeName) { // ���̵�� �˻�(�� ������ ����)
		RecipeDTO dto = new RecipeDTO();
		String sql = "select * from recipe where recipeName=?";
		getConnection(); // ����

		try {
			pstmt = conn.prepareStatement(sql); // ����
			pstmt.setString(1, recipeName);

			rs = pstmt.executeQuery(); // ����

			if (rs.next()) {
				dto.setRecipeName(rs.getString("recipeName"));
				dto.setId(rs.getString("id"));
				dto.setCategory(rs.getString("category"));
				dto.setRecipeDetail(rs.getString("recipeDetail"));
				dto.setRecipeImg(rs.getString("recipeImg"));
			} // while

		} catch (SQLException e) {
			e.printStackTrace();
			dto = null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	} // detailSearch

}
	




























