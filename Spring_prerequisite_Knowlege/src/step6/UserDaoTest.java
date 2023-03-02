package step6;

import step6.dao.ConnectionMaker;
import step6.dao.SimpleMakeConnection;
import step6.dao.UserDao;
import step6.vo.User;
// 우리가 앞으로 여기서 점진적으로 변화를 시킬 "제일 기본 클래스"에요
public class UserDaoTest {
	public static void main(String[] args) throws Exception {
		// 1. 사용자 입력하기 - 리팩토링이기때문에 바뀔 것이 없는 부분이에요
		User user = new User();
		user.setId("kim");
		user.setPw("1111");
		user.setName("김베리");
		
		// 주입(insection)해주는 부분
		ConnectionMaker connectionMaker = new SimpleMakeConnection();
		
		// 2. dao 생성
		UserDao dao = new UserDao(connectionMaker);
		
		// 3. 사용자 입력
		dao.insert(user);
		System.out.println("사용자 등록하기");
		
		// 4. 사용자 조회
		User result = dao.select("kim");
		System.out.println(result.getName());
		
	}

}
