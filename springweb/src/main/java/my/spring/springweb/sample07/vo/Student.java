package my.spring.springweb.sample07.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private int studentNumber;  //클라이언트가 넘겨주는 html의 key(=name)와 필드가 같아야해요
	private String studentName;
	private String studentDept;
	
}
