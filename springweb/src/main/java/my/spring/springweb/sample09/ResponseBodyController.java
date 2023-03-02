package my.spring.springweb.sample09;

import java.nio.charset.Charset;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import my.spring.springweb.sample09.vo.User;

@RestController
@Controller
@RequestMapping(value="/body")
public class ResponseBodyController {
	
	// 1. 문자열로 방식 - 일반적인 방식 
	@RequestMapping(value="text/{id}", 
					produces="text/plain; charset=UTF-8") // 최종적으로 만들 것을 정하기
//	@ResponseBody
	public String method01(@PathVariable String id) { // 위의 id와 동일하게 잡음 -> because 이름이 같아야 들고 오니까 
		
		
		return "<h1>고양이는 야옹야옹" + id + "</h1>";  // 이 결과가 body에 담겨서 전달됨
	}
	
	// 2. response entity 리턴하기
	@RequestMapping(value="textObject/{id}", 
				produces="text/plain; charset=UTF-8") // 최종적으로 만들 것을 정하기
//	@ResponseBody
	public ResponseEntity<String> method02(@PathVariable String id) { 
		// 어떤 결과를 줄 것인지 작성하고 
		String msg = "<h1>고양이는 야옹야옹" + id + "</h1>";
		
		// header를 만들고(당연히 객체로)
		HttpHeaders headers = new HttpHeaders(); // 헤더를 만들어서 직접 지정
		headers.setContentType(new MediaType("text","html",  // "plain" -> "html" 바꾸면 헤더가 읽혀지면서 클라이언트가 받는 것도 html로 된다
								Charset.forName("UTF-8")));   // mediatype = MIME type
		// 객체형태로 리턴하자 (단, 제네릭스도 잡아야 함)
	
	return new ResponseEntity<String>(msg, headers,HttpStatus.CREATED);  // 내가 보낼 메세지, 헤더정보, 상수 (HttpStatus.CREATED)
	} // 이 방법이 어려워서 1번의 방법을 많이 씀
	
		// 3. VO 리턴하기
		@RequestMapping(value="json/{name}",produces="application/json; charset=UTF-8")
		
//		@ResponseBody
		public User method03(@PathVariable String name) { // vo -> json으로 바꾸고 이로써 자동으로 되어서 적절하게 변환해줌
			User user = new User();
			user.setName(name);
			user.setAddr("서울시");
		
		return user; // json data 내보내기
		} // 모든 핸들러마다 리스폰스바디가 붙여져 있고 핸들러에게 응답으로 데이터를 날려주는 것이 얘네가 하는 일 -> 그럼 이걸 날릴 수 있는데
}
