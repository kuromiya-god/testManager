package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.RegisterDTO;

public class RegisterDAO {
	//データベース接続に使用する情報
			private final String JDBC_URL = "jdbc:postgresql://localhost:5432/testManager";
			private final String DB_USER = "postgres";
			private final String DB_PASS = "password";
			
			public int RegisterCustomer(RegisterDTO dto) {
				int result = 0;
				//DBと接続
				try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
					//自動コミット機能をoff
					conn.setAutoCommit(false);
					
					//sql文を作成
					String sql = "INSERT INTO Account VALUES(?,?,?,?,?)";
					PreparedStatement pS = conn.prepareStatement(sql);
					pS.setString(1, dto.getUserId());
					pS.setString(2, dto.getPass());
					pS.setString(3, dto.getEmail());
					pS.setString(4, dto.getJob());
					pS.setInt(5, dto.getAge());
					
					
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
}
