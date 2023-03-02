package my.spring.springweb.sample01.vo;

// javabean 규약이란게 있어요 
// class를 만들 때 적합한 규칙이다
// 1. 기본생성자가 존재해야해요
// 2. 모든 field는 private이어야 해요
// 3. 각 field를 사용하기 위해public으로 되어 있는 setter, getter
// 이렇게 java bean규약을 지켜서 만들 클래스의 객체를 생성했을 떄
// fiedl를 우리가 뭐라고 하냐면 => property라고 불러요


public class User {
	private String userName;
	private int userAge;
	
	public User() {
		
	}

	public User(String userName, int userAge) {
		super();
		this.userName = userName;
		this.userAge = userAge;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	
}
