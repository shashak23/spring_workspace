package step3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import step3.vo.User;


public abstract class UserDao {
	
	 protected abstract Connection getConnection() throws Exception ;
	//추상화가 됐다는 의미로 abstract를 붙여주기
	//method 자체가 추상화여서 정해지지 않은거라서 userdao라는 class도 abtstract라고 잡아야 함
	//private으로 되어있으면 override를 못 해요 -> 이 때 protected를 사용해야해요! 
	//이렇게 해야지 내 코드를 확장시켜서 사용할 수 있어요!
	//이거를 상속해야하니까 class를 새로 만들어야 해요!
	
		// 변할 여지가 있는 이 부분은 날리기 
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		String jdbcUrl="jdbc:mysql://127.0.0.1:3306/spring?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
//		String id = "root";
//		String pw = "test1234";
//		Connection con = DriverManager.getConnection(jdbcUrl, id, pw);
//		return con; // 리턴 반드시 있어야 해요.

		
	// insert를 위한 메소드
	public void insert(User user)throws Exception {

		// 총 6단계

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

