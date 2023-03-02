package step7;

import step7.dao.ConnectionMaker;
import step7.dao.SimpleMakeConnection;
import step7.dao.UserDao;

public class DaoFactory {
	// dao 자체를 return 시켜줄겁니다
	//우리가 갖고 있는 user dao를 사용할거에요
	public UserDao userDao() {
//		ConnectionMaker connectionMaker = new SimpleMakeConnection();
//		UserDao dao = new UserDao(connectionMaker);
//		위의 두 줄과 같은 것~! 
		
		// simple객체 가져와서 userdao에 넣어서 dao를 생성하고 dao를 반환함
		UserDao dao = new UserDao(connectionMaker());
		return dao;
	}
	
	public ConnectionMaker connectionMaker() {
		return new SimpleMakeConnection();
		// 이렇게 메소드를 따로 호출해두면, 위에서 new simplemakerconnection 했던 거를 
		// connectionMaker()롸 트레이드가 가능해요
		// 이런식으로  자체를 넘겨주는 factory를 만들고 dao
		
		//main자체는 클래스에 관심이 없고 factory한테 dao를 하나 줘! 요청하면
		// 어떤 클래스를 이용해서 어떤 메소드로 만들지는 관심이 없고 
		// 로직의 흐름에 따라 능동적으로 객체를 생성해주고 처리하는 거에요
		// 이거를 우리가 제어의 흐름이라고 해요
	}
}

