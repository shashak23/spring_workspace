package step8;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import step8.dao.UserDao;
import step8.vo.User;
// 우리가 앞으로 여기서 점진적으로 변화를 시킬 "제일 기본 클래스"에요
public class UserDaoTest {
	public static void main(String[] args) throws Exception {
		// 1. 사용자 입력하기 - 리팩토링이기때문에 바뀔 것이 없는 부분이에요
		User user = new User();
		user.setId("kim");
		user.setPw("1111");
		user.setName("김베리");
		
		// UserDao dao = new DaoFactory().userDao();
		// dao를 직접 만들지 않으니까 bean으로 등록해서 application context를 이용해서
		// 요청해서 dao를 받아서 쓸거에요! 그래서 없어짐!
		// Application context를 생성 -> userdao 객체를 요청 -> 받아와서 사용
		// 그러면 application context가 있어야 하고 
		ApplicationContext context =
				new AnnotationConfigApplicationContext(DaoFactory.class);
		// import까지 하기 
		// 해당 클래스에 대한 정보를 인자로 넣어주기
		// 그럼 자동적으로 bean으로 등록을 한다
		
		// 이게 singleton이라는 건가? ----> 빨리 배우고 여쭤보기
		
		UserDao dao = context.getBean("userDao",UserDao.class); 
		// bean의 고유 id를 알려드릴테니 bean을 주세요
		// () 안에는 bean의 id를 작성
		// 실제로 커넥션을 해서 생성된 dao가 짜잔!
		// 오브젝트 타입으로 나오는 걸 (UserDao)해서 잡아줌 = casting  -- 기본
		
		// 캐스팅을 자꾸 하면 잘못할 수도 있고 그러면 오류가 발생할 수도 있음
		// 그래서 정확하게 하기 위해 ("")뒤에 인자(정확한 클래스)를 줌   -- 활용
		// 그러면 앞에 작성했던 (UserDao)=casting을 없앨 수 있어요
		
		// 3. 사용자 입력
		dao.insert(user);
		System.out.println("사용자 등록하기");
//		
//		// 4. 사용자 조회
		User result = dao.select("kim");
		System.out.println(result.getName());
		
	}

}
