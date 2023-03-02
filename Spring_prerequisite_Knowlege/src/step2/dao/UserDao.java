package step2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import step2.vo.User;

// db처리하는 로직을 갖고 있는 db처리용 class
// 2개의 메소드를 작성해야 함
// 사용자 입력, 조회 메소드 생성
public class UserDao {
	//외부에서는 사용할 필요가 없기때문에 method가 무조건 public은 아니다!
	//method를 따로 분리시키자!
	private Connection getConnection() throws Exception {
		// 1. driver loading - mysql에 대한 연결!
		// class에 대한 package명 적기 - mysql이 우리에게 제공해 준 정보 적기
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 2. 연결 해 보기
		// 기본적인 3개가 필요함 - id. pw. url
		String jdbcUrl="jdbc:mysql://127.0.0.1:3306/spring?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		String id = "root";
		String pw = "test1234";
		// 객체 연결을 위한 커넥션 생성 및 삽입
		Connection con = DriverManager.getConnection(jdbcUrl, id, pw);
		return con; // 리턴 반드시 있어야 해요.

		
	}
	// insert를 위한 메소드
	public void insert(User user)throws Exception {
		// pure jdbc를 이용해서 database 처리를 해 보자(for 이론) 
		// 총 6단계
		
		// 여기있던 connection이 위의 메소드로 옮겨갔으니까
		// 위의 connection을 주워오자
		Connection con = getConnection();
		
		// 3. preparedStatement 를 만들기
		// 사용자 정보를 가지고 USERTABLE에 하나의 레코드를 밀어 넣기
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

	// 이번에는 select 하는 메소드 만들기 , 인자로 들어가는 id가 겹치지 않게 신경써주세요
	public User select(String userid) throws Exception {
		// 그냥 만들면 빨간줄이 뜨는데 코드 입력하면 괜춘
		// 총 6단계
				// 중복된 1번~2번 코드 날리고 위의 메소드를 적용한 connection을 적기
				Connection con = getConnection();
				
				// 3. preparedStatement 를 만들기
				// 사용자 정보를 가지고 USERTABLE에 하나의 레코드를 밀어 넣기
				String sql = "SELECT * FROM users WHERE id= ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				// sql table에서 만든 속성대로 넣기 
				pstmt.setString(1, userid);
				
				// 4. sql 구문 실행
				ResultSet result = pstmt.executeQuery();
				
				// 5. 결과처리하기  - db처리하는 곳
				result.next();
				// vo생성 - db에서 얻은거 vo에 넣기
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

