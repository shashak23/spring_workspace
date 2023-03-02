package step3;

import step3.dao.NUserDao;
import step3.dao.UserDao;
import step3.vo.User;
// 우리가 앞으로 여기서 점진적으로 변화를 시킬 "제일 기본 클래스"에요
public class UserDaoTest {
	public static void main(String[] args) throws Exception {
		// 1. 사용자 입력하기 - 리팩토링이기때문에 바뀔 것이 없는 부분이에요
		User user = new User();
		user.setId("kim");
		user.setPw("1111");
		user.setName("김베리");
		
		// 2. dao 생성 - 여기서는 userdao 가 nuserdao로 바뀌어야 해요.
		// 확장성이 있도록 들고 가서 쓸 수 있도록 이렇게 변경을 해주는 거에요.
		UserDao dao = new NUserDao();
		
		// 3. 사용자 입력
		dao.insert(user);
		// 근데 그냥 dao.inser(user)라고 쓰면 try / catch를 쓰라고 나오는데
		// 이를 그냥 넘어가고 싶다면.... throws exception하기 
		System.out.println("사용자 등록하기");
		
		// 4. 사용자 조회
		User result = dao.select("kim");
		System.out.println(result.getName());  // 결과가 김베리여야해요.
		
		// mysql connector j 까지 라이브러리에 입력하면 끝!
	}

}
