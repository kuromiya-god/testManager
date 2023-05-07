package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Ques;
import model.Workbook;



public class QuesUpDAO {
	private final String JDBC_URL = "jdbc:postgresql://localhost:5432/testManager";
	private final String DB_USER = "postgres";
	private final String DB_PASS = "password";
	
	public void quesUpDAO(Ques ques) {
		
		
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			//SELECT文を準備
			String sql = "INSERT INTO question(question,option1,option2,option3,option4,answer,explanation,user_id) VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement pS = conn.prepareStatement(sql);
			pS.setString(1, ques.getQuestion());
			pS.setString(2, ques.getOption1());
			pS.setString(3, ques.getOption2());
			pS.setString(4, ques.getOption3());
			pS.setString(5, ques.getOption4());
			pS.setInt(6, ques.getAnswer());
			pS.setString(7, ques.getExplanation());
			pS.setString(8, ques.getUser_id());
			
			//INSERT文を実行する
			pS.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		//何も返さない
		return;
	}
	
	public void quesEditDAO(Ques ques) {
		
		
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			//SELECT文を準備
			String sql = "UPDATE question SET question=?,option1=?,option2=?,option3=?,option4=?,answer=?,explanation=? WHERE id = ? ";
			PreparedStatement pS = conn.prepareStatement(sql);
			pS.setString(1, ques.getQuestion());
			pS.setString(2, ques.getOption1());
			pS.setString(3, ques.getOption2());
			pS.setString(4, ques.getOption3());
			pS.setString(5, ques.getOption4());
			pS.setInt(6, ques.getAnswer());
			pS.setString(7, ques.getExplanation());
			pS.setInt(8, ques.getId());
			
			//INSERT文を実行する
			pS.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		//何も返さない
		return;
	}
	
public void workbookChangeDAO(Workbook workbook) {
		
		
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			//SELECT文を準備
			String sql = "UPDATE workbook SET title=?,genre=?,list=?,author_name=? WHERE workbook_id = ? ";
			PreparedStatement pS = conn.prepareStatement(sql);
			pS.setInt(5, workbook.getWorkbook_id());
			pS.setString(2, workbook.getGenre());
			pS.setString(3, workbook.getList());
			pS.setString(4, workbook.getAuthor_name());
			pS.setString(1, workbook.getTitle());
			
			
			//INSERT文を実行する
			pS.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		//何も返さない
		return;
	}
	
	public void quesDeleteDAO(Ques ques) {
		
		
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			//SELECT文を準備
			String sql = "UPDATE question SET deleted = true WHERE id = ? ";
			PreparedStatement pS = conn.prepareStatement(sql);
			pS.setInt(1, ques.getId());
			
			//INSERT文を実行する
			pS.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		//何も返さない
		return;
	}
	
	public int workbookUpDAO(Workbook workbook) {

		int result = 0;
		//DBと接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			//自動コミット機能をoff
			conn.setAutoCommit(false);
			
			//sql文を作成
			String sql = "INSERT INTO workbook VALUES(?,?,?,?,?)";
			PreparedStatement pS = conn.prepareStatement(sql);
			pS.setString(1, workbook.getUser_id());
			pS.setString(2, workbook.getTitle());
			pS.setString(3, workbook.getGenre());
			pS.setString(4, workbook.getList());
			pS.setString(5, workbook.getAuthor_name());
			
			
			result = pS.executeUpdate();
			
			//INSERT出来なかった場合
			if(result==0) {
				conn.rollback();
				return result;
			}
			//INSERTできた場合
			
				conn.commit();
				return result;
			
			
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				return result;
			}
	}
	
	public void workbookChangeDAO(String user_id, String title, String genre, String list, String author_name,int workbook_id,boolean random,int limits) {
		
		
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			//SELECT文を準備
			String sql = "UPDATE workbook SET title=?,genre=?,list=?,author_name=?,random=?,limits=? WHERE workbook_id = ? ";
			PreparedStatement pS = conn.prepareStatement(sql);
			pS.setInt(7, workbook_id);
			pS.setString(2, genre);
			pS.setString(3, list);
			pS.setString(4, author_name);
			pS.setString(1, title);
			pS.setBoolean(5, random);
			pS.setInt(6, limits);
			
			//INSERT文を実行する
			pS.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		//何も返さない
		return;
	}
	
public void workbookChangeDAO(String user_id, String title, String genre, String list, String author_name,int workbook_id,boolean random) {
		
		
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			//SELECT文を準備
			String sql = "UPDATE workbook SET title=?,genre=?,list=?,author_name=?,random=? WHERE workbook_id = ? ";
			PreparedStatement pS = conn.prepareStatement(sql);
			pS.setInt(6, workbook_id);
			pS.setString(2, genre);
			pS.setString(3, list);
			pS.setString(4, author_name);
			pS.setString(1, title);
			pS.setBoolean(5, random);
			
			
			//INSERT文を実行する
			pS.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		//何も返さない
		return;
	}

public void workbookChangeDAO(String user_id, String title, String genre, String list, String author_name,int workbook_id,int limits) {
	
	
	//データベースへ接続
	try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
		
		//SELECT文を準備
		String sql = "UPDATE workbook SET title=?,genre=?,list=?,author_name=?,limits=? WHERE workbook_id = ? ";
		PreparedStatement pS = conn.prepareStatement(sql);
		pS.setInt(6, workbook_id);
		pS.setString(2, genre);
		pS.setString(3, list);
		pS.setString(4, author_name);
		pS.setString(1, title);
		pS.setInt(5, limits);
		System.out.println("DAO"+limits);
		
		//INSERT文を実行する
		pS.executeUpdate();
		
		
	}catch(SQLException e) {
		e.printStackTrace();
		
	}
	//何も返さない
	return;
}

public void workbookChangeDAO(int workbook_id,boolean stealth) {
	
	
	//データベースへ接続
	try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
		
		//SELECT文を準備
		String sql = "UPDATE workbook SET stealth=? WHERE workbook_id = ? ";
		PreparedStatement pS = conn.prepareStatement(sql);
		pS.setInt(2, workbook_id);
		pS.setBoolean(1, stealth);
		
		
		//INSERT文を実行する
		pS.executeUpdate();
		
		
	}catch(SQLException e) {
		e.printStackTrace();
		
	}
	//何も返さない
	return;
}
	
}
