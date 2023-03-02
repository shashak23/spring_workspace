package my.spring.springweb.sample06.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lotto {
	private int lottoNum;   // 예는 html에 있는 값고 ㅏ같아야 해요 
	private String result;
}
