package step6.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import step6.vo.User;

// db처리하는 로직을 갖고 있는 db처리용 class
// 2개의 메소드를 작성해야 함
// 사용자 입력, 조회 메소드 생성
public class UserDao {
	
	ConnectionMaker connectionMaker;
	
	public UserDao(ConnectionMaker connectionMaker) {
		//클래스 이름이 날라가면서 느슨한 연결고리만 남게 되요 --> '주입' insection 이라고 함
		this.connectionMaker = connectionMaker;
		//하나이ㅡ 객체가 다른 객체의 레퍼런스를 받아들이는 행위를 insection이라고 함
		//객체 주소값이 전달되고 일반적인 필드에 세팅을 하는 현상 자체를 '주입'이라고 함
		
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

