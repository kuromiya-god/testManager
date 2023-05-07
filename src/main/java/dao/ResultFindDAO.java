package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResultFindDAO {
	private final String JDBC_URL = "jdbc:postgresql://localhost:5432/testManager";
	private final String DB_USER = "postgres";
	private final String DB_PASS = "password";
	
	public ArrayList<ArrayList<String>> ResultFindResultListDAO(String userid) {
		ArrayList<ArrayList<String>> rf = new ArrayList<>();
    	ResultSet rs = null;
    	String sql = "SELECT * FROM result WHERE user_id = ?";
     // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement stmt = conn.prepareStatement(sql)){
        		stmt.setString(1, userid);
           
           // SQL文を実行し、結果を取得
           rs = stmt.executeQuery();

           // 結果を処理
           while (rs.next()) {
        	   ArrayList<String> i = new ArrayList<>();
               
               String results = rs.getString("result");
               String[] qi = results.split(",");
               for (String str : qi) {
            	   i.add(str);
            	}
               
               rf.add(i);
               
           }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return rf;
	    }
	
	public ArrayList<ArrayList<String>> ResultFindQuesListDAO(String userid) {
		ArrayList<ArrayList<String>> rf = new ArrayList<>();
    	ResultSet rs = null;
    	String sql = "SELECT * FROM result WHERE user_id = ?";
     // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement stmt = conn.prepareStatement(sql)){
        		stmt.setString(1, userid);
           
           // SQL文を実行し、結果を取得
           rs = stmt.executeQuery();

           // 結果を処理
           while (rs.next()) {
               ArrayList<Integer> questionid = new ArrayList<>();
               String questionids = rs.getString("question_id");
               String[] qi = questionids.split(",");
               for (String str : qi) {
            	   questionid.add(Integer.parseInt(str));
            	}
               
               QuestionsetDAO l = new QuestionsetDAO();
               rf.add(l.findByQuestionDAO(questionid));
               
               
               
           }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return rf;
	    }
	
	public ArrayList<Float> ResultFindPercentageDAO(String userid) {
    	ArrayList<Float> rf = new ArrayList<>();
    	ResultSet rs = null;
    	String sql = "SELECT * FROM result WHERE user_id = ?";
     // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement stmt = conn.prepareStatement(sql)){
        		stmt.setString(1, userid);
           
           // SQL文を実行し、結果を取得
           rs = stmt.executeQuery();

           // 結果を処理
           while (rs.next()) {
        	   
               float rp = rs.getFloat("resultpercentage");
               
               
               rf.add(rp);
               
           }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return rf;
	    }
	
	public ArrayList<String> ResultFindTitleDAO(String userid) {
    	ArrayList<String> rf = new ArrayList<>();
    	ResultSet rs = null;
    	String sql = "SELECT * FROM result WHERE user_id = ?";
     // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement stmt = conn.prepareStatement(sql)){
        		stmt.setString(1, userid);
           
           // SQL文を実行し、結果を取得
           rs = stmt.executeQuery();

           // 結果を処理
           while (rs.next()) {
        	   
               String title = rs.getString("title");
               
               rf.add(title);
               
           }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return rf;
	    }
	
	public ArrayList<Integer> ResultFindTimeDAO(String userid) {
    	ArrayList<Integer> rf = new ArrayList<>();
    	ResultSet rs = null;
    	String sql = "SELECT * FROM result WHERE user_id = ?";
     // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement stmt = conn.prepareStatement(sql)){
        		stmt.setString(1, userid);
           
           // SQL文を実行し、結果を取得
           rs = stmt.executeQuery();

           // 結果を処理
           while (rs.next()) {
        	   
               int wt = rs.getInt("workbooktime");
               
               rf.add(wt);
               
           }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return rf;
	    }
	
	public ArrayList<ArrayList<String>> ResultFindResultListMakesDAO(String authorid,String title) {
		ArrayList<ArrayList<String>> rf = new ArrayList<>();
    	ResultSet rs = null;
    	String sql = "SELECT * FROM result WHERE author_name = ? AND title = ?";
     // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement stmt = conn.prepareStatement(sql)){
        		stmt.setString(1, authorid);
        		stmt.setString(2, title);
           
           // SQL文を実行し、結果を取得
           rs = stmt.executeQuery();

           // 結果を処理
           while (rs.next()) {
        	   ArrayList<String> i = new ArrayList<>();
               
               String results = rs.getString("result");
               String[] qi = results.split(",");
               for (String str : qi) {
            	   i.add(str);
            	}
               
               rf.add(i);
               
           }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return rf;
	    }
	
	public ArrayList<ArrayList<String>> ResultFindQuesListMakesDAO(String authorid,String title) {
		ArrayList<ArrayList<String>> rf = new ArrayList<>();
    	ResultSet rs = null;
    	String sql = "SELECT * FROM result WHERE author_name = ? AND title = ?";
     // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement stmt = conn.prepareStatement(sql)){
        		stmt.setString(1, authorid);
        		stmt.setString(2, title);
           
           // SQL文を実行し、結果を取得
           rs = stmt.executeQuery();

           // 結果を処理
           while (rs.next()) {
               ArrayList<Integer> questionid = new ArrayList<>();
               String questionids = rs.getString("question_id");
               String[] qi = questionids.split(",");
               for (String str : qi) {
            	   questionid.add(Integer.parseInt(str));
            	}
               
               QuestionsetDAO l = new QuestionsetDAO();
               rf.add(l.findByQuestionDAO(questionid));
               
               
               
           }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return rf;
	    }
	
	public ArrayList<Float> ResultFindPercentageMakesDAO(String authorid,String title) {
    	ArrayList<Float> rf = new ArrayList<>();
    	ResultSet rs = null;
    	String sql = "SELECT * FROM result WHERE author_name = ? AND title = ?";
     // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement stmt = conn.prepareStatement(sql)){
        		stmt.setString(1, authorid);
        		stmt.setString(2, title);
           
           // SQL文を実行し、結果を取得
           rs = stmt.executeQuery();

           // 結果を処理
           while (rs.next()) {
        	   
               float rp = rs.getFloat("resultpercentage");
               
               
               rf.add(rp);
               
           }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return rf;
	    }
	
	public ArrayList<String> ResultFindTitleMakesDAO(String authorid,String title) {
    	ArrayList<String> rf = new ArrayList<>();
    	ResultSet rs = null;
    	String sql = "SELECT * FROM result WHERE author_name = ? AND title = ?";
     // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement stmt = conn.prepareStatement(sql)){
        		stmt.setString(1, authorid);
        		stmt.setString(2, title);
           
           // SQL文を実行し、結果を取得
           rs = stmt.executeQuery();

           // 結果を処理
           while (rs.next()) {
        	   
               String titles = rs.getString("title");
               
               rf.add(titles);
               
           }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return rf;
	    }
	
	public ArrayList<Integer> ResultFindTimeMakesDAO(String authorid,String title) {
    	ArrayList<Integer> rf = new ArrayList<>();
    	ResultSet rs = null;
    	String sql = "SELECT * FROM result WHERE author_name = ? AND title = ?";
     // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement stmt = conn.prepareStatement(sql)){
        		stmt.setString(1, authorid);
        		stmt.setString(2, title);
           
           // SQL文を実行し、結果を取得
           rs = stmt.executeQuery();

           // 結果を処理
           while (rs.next()) {
        	   
               int wt = rs.getInt("workbooktime");
               
               rf.add(wt);
               
           }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return rf;
	    }
	
	public ArrayList<String> ResultFindUserMakesDAO(String authorid,String title) {
    	ArrayList<String> rf = new ArrayList<>();
    	ResultSet rs = null;
    	String sql = "SELECT * FROM result WHERE author_name = ? AND title = ?";
     // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement stmt = conn.prepareStatement(sql)){
        		stmt.setString(1, authorid);
        		stmt.setString(2, title);
           
           // SQL文を実行し、結果を取得
           rs = stmt.executeQuery();

           // 結果を処理
           while (rs.next()) {
        	   
               String user_id = rs.getString("user_id");
               
               rf.add(user_id);
               
           }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return rf;
	    }

}
