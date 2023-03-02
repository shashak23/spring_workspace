package step9.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import step9.vo.User;

// db처리하는 로직을 갖고 있는 db처리용 class
// 2개의 메소드를 작성해야 함
// 사용자 입력, 조회 메소드 생성
public class UserDao {
	
	ConnectionMaker connectionMaker;
	
	public UserDao() {
		// 이걸 안쓰면 생성자가 안들어와요~!
		System.out.println("기본 생성자 호출!");
	}
	
	// 생성자를 통한 injection 호출
	public UserDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
		
		System.out.println("UserDao 생성자 호출!");
	}
	
	// setter를 통한 injection 호출
	public void setConnectionMaker(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
		System.out.println("setter 호출!");
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

