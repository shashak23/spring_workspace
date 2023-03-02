package step8;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import step8.dao.ConnectionMaker;
import step8.dao.SimpleMakeConnection;
import step8.dao.UserDao;

@Configuration
public class DaoFactory {
	@Bean
	public UserDao userDao() {
		
		UserDao dao = new UserDao(connectionMaker());
		return dao;
	}
	@Bean
	public ConnectionMaker connectionMaker() {
		return new SimpleMakeConnection();
		// 다른 객체를 주입받아서 쓰고 있어요, 연결관계가 맺어져 있음
		// 그래서 bean이 두 개가 필요한데,
		// 하나는 simple~ 이고 다른 하나는 userDao임
		// 객체를 만들어 내는 메소드를 bean으로 하니까
		
		// 위의 메소드 두개 전부 @Bean을 붙인다.(엣빈이라고 읽어용)
	}
} // 이 클래스가 bean으로 등록되기 위해 @Configuration을 import 한다.

