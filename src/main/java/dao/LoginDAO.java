package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class LoginDAO {
	private final String JDBC_URL = "jdbc:postgresql://localhost:5432/testManager";
	private final String DB_USER = "postgres";
	private final String DB_PASS = "password";
	
	public Account findByLogin(Login login) {
		Account account = null;
		
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			//SELECT文を準備
			String sql = "SELECT USER_ID,PASS,MAIL,JOB,AGE FROM ACCOUNT WHERE USER_ID = ? AND PASS = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getUserId());
			pStmt.setString(2, login.getPass());
			
			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			//一致したユーザーが存在した場合
			//そのユーザーを表すAccountインスタンスを生成
			if (rs.next()) {
				//結果表からデータを取得
				String userId = rs.getString("USER_ID");
				String pass = rs.getString("PASS");
				String mail = rs.getString("MAIL");
				String job = rs.getString("JOB");
				int age = rs.getInt("AGE");
				account = new Account(userId,pass,mail,job,age);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		//見つかったユーザーまたはNULLを返す
		return account;
	}
}
