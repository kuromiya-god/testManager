package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Ques;
import model.Workbook;

public class QuesListSetDAO {
	
	private final String JDBC_URL = "jdbc:postgresql://localhost:5432/testManager";
	private final String DB_USER = "postgres";
	private final String DB_PASS = "password";

    public ArrayList<Ques> findByQuesList(String user_id) {
    	ArrayList<Ques> quesList = new ArrayList<>();
    	ResultSet rs = null;
    	String sql = "SELECT id,question FROM question WHERE deleted = false AND user_id = ? ORDER BY id";
     // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement stmt = conn.prepareStatement(sql)){
        	stmt.setString(1, user_id);
           
           // SQL文を実行し、結果を取得
           rs = stmt.executeQuery();
           

           // 結果を処理
           while (rs.next()) {
        	   int id = rs.getInt("id");
               String question = rs.getString("question");
               Ques ques = new Ques(question,id);
               quesList.add(ques);
               
           }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return quesList;
	    }
    
    public ArrayList<Workbook> findByWorkbook() {
    	ArrayList<Workbook> workbook = new ArrayList<>();
    	ResultSet rs = null;
    	String sql = "SELECT * FROM workbook WHERE deleted = false AND stealth = false ORDER BY workbook_id";
     // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement stmt = conn.prepareStatement(sql)){
        	
           
           // SQL文を実行し、結果を取得
           rs = stmt.executeQuery();

           // 結果を処理
           while (rs.next()) {
        	   int workbook_id = rs.getInt("workbook_id");
               String title = rs.getString("title");
               String genre = rs.getString("genre");
               String list = rs.getString("list");
               String author_name = rs.getString("author_name");
               Workbook workbooks = new Workbook(title,genre,list,author_name,workbook_id);
               workbook.add(workbooks);
               
           }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return workbook;
	    }
    
    public ArrayList<Workbook> findByWorkbookSearch(String search) {
    	ArrayList<Workbook> workbook = new ArrayList<>();
    	ResultSet rs = null;
    	String sql = "SELECT * FROM workbook WHERE deleted = false AND title = ? ORDER BY workbook_id";
     // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement stmt = conn.prepareStatement(sql)){
        		stmt.setString(1, search);
           
           // SQL文を実行し、結果を取得
           rs = stmt.executeQuery();
           
           
			
           // 結果を処理
           while (rs.next()) {
        	   int workbook_id = rs.getInt("workbook_id");
               String title = rs.getString("title");
               String genre = rs.getString("genre");
               String list = rs.getString("list");
               String author_name = rs.getString("author_name");
               Workbook workbooks = new Workbook(title,genre,list,author_name,workbook_id);
               workbook.add(workbooks);
               
           }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return workbook;
	    }
    
    public ArrayList<Workbook> findByWorkbookSearchagains(String search) {
    	ArrayList<Workbook> workbook = new ArrayList<>();
    	ResultSet rs = null;
    	String sql = "SELECT * FROM workbook WHERE deleted = false AND title LIKE ? AND stealth = false ORDER BY workbook_id";
     // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement stmt = conn.prepareStatement(sql)){
        		stmt.setString(1, "%" + search + "%");
           
           // SQL文を実行し、結果を取得
           rs = stmt.executeQuery();
           
           // 結果を処理
           while (rs.next()) {
        	   int workbook_id = rs.getInt("workbook_id");
               String title = rs.getString("title");
               String genre = rs.getString("genre");
               String list = rs.getString("list");
               String author_name = rs.getString("author_name");
               Workbook workbooks = new Workbook(title,genre,list,author_name,workbook_id);
               workbook.add(workbooks);
               System.out.println(title);
           }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return workbook;
	    }
    
    public Workbook findByWorkbook(int wi) {
    	Workbook workbook = null;
    	ResultSet rs = null;
    	String sql = "SELECT * FROM workbook WHERE deleted = false AND workbook_id = ? ORDER BY workbook_id";
     // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement stmt = conn.prepareStatement(sql)){
        		stmt.setInt(1, wi);
           
           // SQL文を実行し、結果を取得
           rs = stmt.executeQuery();

           // 結果を処理
           while (rs.next()) {
        	   String user_id = rs.getString("user_id");
        	   int workbook_id = rs.getInt("workbook_id");
               String title = rs.getString("title");
               String genre = rs.getString("genre");
               String list = rs.getString("list");
               String author_name = rs.getString("author_name");
               boolean random = rs.getBoolean("random");
               int limit = rs.getInt("limits");
               workbook = new Workbook(user_id,title,genre,list,author_name,workbook_id,random,limit);
               
               
           }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return workbook;
	    }
    
    public ArrayList<Workbook> findByWorkbook(String user_id) {
    	ArrayList<Workbook> workbook = new ArrayList<>();
    	ResultSet rs = null;
    	String sql = "SELECT * FROM workbook WHERE deleted = false AND user_id = ? ORDER BY workbook_id";
     // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement stmt = conn.prepareStatement(sql)){
        		stmt.setString(1, user_id);
           
           // SQL文を実行し、結果を取得
           rs = stmt.executeQuery();

           // 結果を処理
           while (rs.next()) {
               String title = rs.getString("title");
               String genre = rs.getString("genre");
               String list = rs.getString("list");
               String author_name = rs.getString("author_name");
               Workbook workbooks = new Workbook(title,genre,list,author_name);
               workbook.add(workbooks);
               
           }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return workbook;
	    }
    
    public ArrayList<Workbook> findByWorkbooks(String user_id) {
    	ArrayList<Workbook> workbook = new ArrayList<>();
    	ResultSet rs = null;
    	String sql = "SELECT * FROM workbook WHERE deleted = false AND user_id = ? ORDER BY workbook_id";
     // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement stmt = conn.prepareStatement(sql)){
        		stmt.setString(1, user_id);
           
           // SQL文を実行し、結果を取得
           rs = stmt.executeQuery();

           // 結果を処理
           while (rs.next()) {
               String title = rs.getString("title");
               String genre = rs.getString("genre");
               String list = rs.getString("list");
               String author_name = rs.getString("author_name");
               boolean random = rs.getBoolean("random");
               boolean stealth = rs.getBoolean("stealth");
               int limit = rs.getInt("limits");
               Workbook workbooks = new Workbook(title,genre,list,author_name,random,stealth,limit);
               workbook.add(workbooks);
               
           }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return workbook;
	    }
    
    public Workbook findByWorkbookEdit(String user_id,String title) {
    	Workbook workbook = null;
    	ResultSet rs = null;
    	String sql = "SELECT * FROM workbook WHERE deleted = false AND user_id = ? AND title = ? ORDER BY workbook_id";
     // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement stmt = conn.prepareStatement(sql)){
        		stmt.setString(1, user_id);
        		stmt.setString(2, title);
           
           // SQL文を実行し、結果を取得
           rs = stmt.executeQuery();

           // 結果を処理
           while (rs.next()) {
               String user_ids = rs.getString("user_id");
        	   int workbook_id = rs.getInt("workbook_id");
        	   String genre = rs.getString("genre");
               String list = rs.getString("list");
               String author_name = rs.getString("author_name");
               String titles = rs.getString("title");
               workbook = new Workbook(user_ids,titles,genre,list,author_name,workbook_id);
           }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return workbook;
	    }
    
    public ArrayList<Ques> findByQuesList() {
    	ArrayList<Ques> quesList = new ArrayList<>();
    	ResultSet rs = null;
    	String sql = "SELECT id,question FROM question WHERE deleted = false ORDER BY id";
     // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement stmt = conn.prepareStatement(sql)){
        	
           
           // SQL文を実行し、結果を取得
           rs = stmt.executeQuery();
           

           // 結果を処理
           while (rs.next()) {
        	   int id = rs.getInt("id");
               String question = rs.getString("question");
               Ques ques = new Ques(question,id);
               quesList.add(ques);
           }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return quesList;
	    }
   }
    
