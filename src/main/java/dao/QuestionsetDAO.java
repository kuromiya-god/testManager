package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Ques;
import model.Workbook;

public class QuestionsetDAO {
	
	private final String JDBC_URL = "jdbc:postgresql://localhost:5432/testManager";
	private final String DB_USER = "postgres";
	private final String DB_PASS = "password";

    public ArrayList<Ques> findByQuestion(ArrayList<Integer> questionId) {
    	ArrayList<Ques> questionList = new ArrayList<Ques>();
    	ResultSet rs = null;
     // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
            // データベースに接続
           

            // SQL文を準備
        	StringBuilder sb = new StringBuilder();
        	sb.append("SELECT * FROM question WHERE deleted = false AND id IN (");
        	for (int i = 0; i < questionId.size(); i++) {
        	    sb.append("?");
        	    if (i != questionId.size() - 1) {
        	        sb.append(",");
        	    }
        	}
        	sb.append(") ORDER BY array_position(ARRAY[");
        	for (int i = 0; i < questionId.size(); i++) {
        	    sb.append("?");
        	    if (i != questionId.size() - 1) {
        	        sb.append(",");
        	    }
        	}
        	sb.append("], id)");

        	PreparedStatement pStmt = conn.prepareStatement(sb.toString());

        	int index = 1;
        	for (int i = 0; i < questionId.size(); i++) {
        	    pStmt.setInt(index++, questionId.get(i));
        	}

        	for (int i = 0; i < questionId.size(); i++) {
        	    pStmt.setInt(index++, questionId.get(i));
        	}

        
           

            // SQL文を実行し、結果を取得
            rs = pStmt.executeQuery();

            // 結果を1件取得できた場合、Questionインスタンスを生成
            // そして、選択肢も取得してQuestionインスタンスにセット
            while (rs.next()) {
            	String question = rs.getString("question");
            	String option1 = rs.getString("option1");
            	String option2 = rs.getString("option2");
            	String option3 = rs.getString("option3");
            	String option4 = rs.getString("option4");
        		int answer = rs.getInt("answer");
        		String explanation = rs.getString("explanation");
        		int id = rs.getInt("id");
        		Ques ques = new Ques(question,option1,option2,option3,option4,answer,explanation,id);
        		System.out.println(option1);
        		questionList.add(ques);
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return questionList;
	    }
    
    public ArrayList<String> findByQuestionTitle(ArrayList<Integer> questionId) {
    	ArrayList<String> questionList = new ArrayList<>();
    	ResultSet rs = null;
     // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
            // データベースに接続
           

            // SQL文を準備
        	StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM question WHERE deleted = false AND id IN (");
            for (int i = 0; i < questionId.size(); i++) {
                sb.append("?");
                if (i != questionId.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");
            PreparedStatement pStmt = conn.prepareStatement(sb.toString());
            for (int i = 0; i < questionId.size(); i++) {
                pStmt.setInt(i + 1, questionId.get(i));
            }
           

            // SQL文を実行し、結果を取得
            rs = pStmt.executeQuery();

            // 結果を1件取得できた場合、Questionインスタンスを生成
            // そして、選択肢も取得してQuestionインスタンスにセット
            while (rs.next()) {
            	String question = rs.getString("question");
            	questionList.add(question);
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return questionList;
	    }
    
    public ArrayList<Integer> findByWorkbook(int wi) {
    	ArrayList<Integer> questionId = new ArrayList<Integer>();
    	ResultSet rs = null;
    	try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			//SELECT文を準備
			String sql = "SELECT * FROM workbook WHERE workbook_id IN (?)";
			PreparedStatement pS = conn.prepareStatement(sql);
			pS.setInt(1, wi);
			
			
			//INSERT文を実行する
			rs = pS.executeQuery();

            // 結果を1件取得できた場合、Questionインスタンスを生成
            // そして、選択肢も取得してQuestionインスタンスにセット
            while (rs.next()) {
            	String list = rs.getString("list");
            	String[] strArray = list.split(",");
            	ArrayList<String> arrayList = new ArrayList<String>();

            	for (String s : strArray) {
            	    arrayList.add(s);
            	}
            	
            	for (String s : arrayList) {
            		questionId.add(Integer.parseInt(s));
            	}
        		
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return questionId;
	    }
    
    public int findByWorkbookTimes(Workbook wi) {
    	int workbookTimes = 0;
    	ResultSet rs = null;
    	try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			//SELECT文を準備
			String sql = "SELECT * FROM result WHERE workbook_id = ? AND user_id = ?";
			PreparedStatement pS = conn.prepareStatement(sql);
			pS.setInt(1, wi.getWorkbook_id());
			pS.setString(2, wi.getUser_id());
			
			
			//INSERT文を実行する
			rs = pS.executeQuery();

            // 結果を1件取得できた場合、Questionインスタンスを生成
            // そして、選択肢も取得してQuestionインスタンスにセット
            while (rs.next()) {
            	workbookTimes++;
            	}
        		
            
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return (Integer) null;
        }
        return workbookTimes;
	    }
    
    public void resultSetDAO(String user_id,int workbook_id,String title,String question_id,String result,float accuracy,int workbooktime,String author_name) {
    	
    	try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			//SELECT文を準備
			String sql = "INSERT INTO result(user_id,workbook_id,title,question_id,result,resultpercentage,workbooktime,author_name) VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement pS = conn.prepareStatement(sql);
			pS.setString(1, user_id);
			pS.setInt(2, workbook_id);
			pS.setString(3, title);
			pS.setString(4, question_id);
			pS.setString(5, result);
			pS.setFloat(6, accuracy);
			pS.setInt(7, workbooktime);
			pS.setString(8, author_name);
			
			
			
			
			//INSERT文を実行する
			pS.executeUpdate();

            
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        return;
	    }
    public ArrayList<String> findByQuestionDAO(ArrayList<Integer> questionId) {
    	ArrayList<String> questionList = new ArrayList<>();
    	ResultSet rs = null;
     // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
            // データベースに接続
           

            // SQL文を準備
        	StringBuilder sb = new StringBuilder();
        	sb.append("SELECT * FROM question WHERE deleted = false AND id IN (");
        	for (int i = 0; i < questionId.size(); i++) {
        	    sb.append("?");
        	    if (i != questionId.size() - 1) {
        	        sb.append(",");
        	    }
        	}
        	sb.append(") ORDER BY array_position(ARRAY[");
        	for (int i = 0; i < questionId.size(); i++) {
        	    sb.append("?");
        	    if (i != questionId.size() - 1) {
        	        sb.append(",");
        	    }
        	}
        	sb.append("], id)");

        	PreparedStatement pStmt = conn.prepareStatement(sb.toString());

        	int index = 1;
        	for (int i = 0; i < questionId.size(); i++) {
        	    pStmt.setInt(index++, questionId.get(i));
        	}

        	for (int i = 0; i < questionId.size(); i++) {
        	    pStmt.setInt(index++, questionId.get(i));
        	}
           

            // SQL文を実行し、結果を取得
            rs = pStmt.executeQuery();

            // 結果を1件取得できた場合、Questionインスタンスを生成
            // そして、選択肢も取得してQuestionインスタンスにセット
            while (rs.next()) {
            	String question = rs.getString("question");
            	
        		questionList.add(question);
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return questionList;
	    }
    
}
    
