package step9.dao;

import java.sql.Connection;

public interface ConnectionMaker {
	Connection getConnection() throws Exception;
	//connection maker를 이용해서 interface잉름을 바꿈
	
}
