package my.spring.springweb.sample07.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
// @AllArgsConstructor 이거 안써서 안만들어도 돼요
public class Member {
	private String memberId;
	private String memberName;
	private String memberAddr;
	private String memberHobby;
	private String memberContent;
}
