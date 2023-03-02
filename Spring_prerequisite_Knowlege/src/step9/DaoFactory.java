package step9;

import step9.dao.ConnectionMaker;
import step9.dao.SimpleMakeConnection;
import step9.dao.UserDao;


public class DaoFactory {

	public UserDao userDao() {
		

		UserDao dao = new UserDao();
		dao.setConnectionMaker(connectionMaker());
		
		return dao;
	}

	public ConnectionMaker connectionMaker() {
		return new SimpleMakeConnection();
		
	}
}

