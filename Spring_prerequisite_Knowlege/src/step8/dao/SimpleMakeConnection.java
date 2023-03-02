package step8.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SimpleMakeConnection implements ConnectionMaker {
	
	public SimpleMakeConnection() {
		System.out.println("SimpleMakeConnection 생성자 호출!");
		// bean이 잘 들어왔는지 확인하는 방법 = 생성자 호출 = public으로 기본 메소드로 생성
	}
	// 외부에서 사용할거니까 public으로 해 주기 
	@Override
	public Connection getConnection() throws Exception {
		// 1. driver loading - mysql에 대한 연결!
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 2. 연결 해 보기
		String jdbcUrl="jdbc:mysql://127.0.0.1:3306/spring?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		String id = "root";
		String pw = "test1234";
		
		Connection con = DriverManager.getConnection(jdbcUrl, id, pw);
		return con;
		//사가는 곳에서 연결정보를 만들어 줘야 하는 부분
		//사간 곳에서는 implements로 내가 구현한 커넥션 메이커를 구현함
		
	}
}
