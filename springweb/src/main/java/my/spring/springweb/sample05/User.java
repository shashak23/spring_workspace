package my.spring.springweb.sample05;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private int userNumber;
	private String userName;
	private String userDept;
	
	// vo를 무겁게 만들기 -> 왜 써요? -> 편해서 ㅋ 
}
