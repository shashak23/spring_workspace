package step9;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import step9.dao.UserDao;
import step9.vo.User;
// 우리가 앞으로 여기서 점진적으로 변화를 시킬 "제일 기본 클래스"에요
public class UserDaoTest {
	public static void main(String[] args) throws Exception {
		// 1. 사용자 입력하기 - 리팩토링이기때문에 바뀔 것이 없는 부분이에요
		User user = new User();
		user.setId("kim");
		user.setPw("1111");
		user.setName("김베리");
		
		ApplicationContext context =
				new AnnotationConfigApplicationContext(DaoFactory.class);
		
		
		UserDao dao = context.getBean("userDao",UserDao.class); 
		
		dao.insert(user);
		System.out.println("사용자 등록하기");

		User result = dao.select("kim");
		System.out.println(result.getName());
		
	}

}
