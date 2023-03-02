package step4.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SimpleMakeConnection {
	// 외부에서 사용할거니까 public으로 해 주기 
	public Connection getConnection() throws Exception {
		// 1. driver loading - mysql에 대한 연결!
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 2. 연결 해 보기
		String jdbcUrl="jdbc:mysql://127.0.0.1:3306/spring?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		String id = "root";
		String pw = "test1234";
		
		Connection con = DriverManager.getConnection(jdbcUrl, id, pw);
		return con;
		//사가는 곳에서 만들어야 할 부분
		
	}
}
