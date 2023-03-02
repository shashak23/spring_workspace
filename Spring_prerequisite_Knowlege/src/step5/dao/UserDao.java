package step5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import step5.vo.User;

// db처리하는 로직을 갖고 있는 db처리용 class
// 2개의 메소드를 작성해야 함
// 사용자 입력, 조회 메소드 생성
public class UserDao {
	
	ConnectionMaker connectionMaker;
	
	public UserDao() {
		//userdao가 명시적으로 아래 코드를 이용하고 있죠? -> 연결되어있음
		//정확하게는 의존관계를 맺고 있음(의존성)
		//userdao와 simplemakeconnection은 의존관계에 있다
		connectionMaker = new SimpleMakeConnection();
		//여기서 simplemakerconnection은 두 개의 객체를 연결해주는 클래스 
		//userdao와 실제로 구현체인 simplemaeconnection의 관계를 분리시키자
		
		//simple~하고 객체 만드는 거를 userdaotest가 담당하여
		//userdaotest가 simple~을 생성하는 것!
		//그러면 어떻게 되냐? -> 상위 interface가 아래의 interface를 구현하고 있다는 거고
		//userdao는 connectionmaker를 사용하고 
		//원래는 userdao가 siple~를 생성해야하는데 userdaotest가 객체를 가져와서
		//userdao에게 객체를 제공한다.(우회해서 한다)
	}

	
	public void insert(User user)throws Exception {
		// class차원에서 분리함
		Connection con = connectionMaker.getConnection();
		
		// 3. preparedStatement 를 만들기
		String sql = "INSERT INTO users VALUES(?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		// sql table에서 만든 속성대로 넣기 
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPw());
		pstmt.setString(3, user.getName());
		
		// 4. sql 구문 실행
		int result = pstmt.executeUpdate();
		
		// 5. 결과(로직)처리하기  - db처리하는 곳, sysout은 걍 해봅시다
		if(result ==1) {
			System.out.println("정상적으로 입력됐습니다");
		}
		
		// 6. resource 해제
		pstmt.close();
		con.close();
		}
	
	public User select(String userId) throws Exception {

		
		Connection con = connectionMaker.getConnection();
		
		// 3. PreparedStatemenet를 만들어요!
		String sql = "SELECT * FROM users WHERE id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, userId);
		
		// 4. SQL구문 실행
		ResultSet result = pstmt.executeQuery();
		
		// 5. 결과처리
		result.next();
		User user = new User();
		user.setId(result.getString("id"));
		user.setPw(result.getString("pw"));
		user.setName(result.getString("name"));
		
		// 6. resource 해제
		pstmt.close();
		con.close();
		
		return user;
	}

	}

