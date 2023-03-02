package my.spring.springweb.sample03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogTestController {
	
	// 어떤 로그형태로 어떤 걸 출력을 할건가를 적기 
	Logger log = LogManager.getLogger("case1");
	
	// 클라이언트가 데이터를 어떻게 주느냐의 차이 
	@RequestMapping(value="/log1")
	public String myMethod() {
		//log를 찍어보는 일, web.xml 에 쓰인대로 적용하기
		log.debug("고양이는 냐옹냐옹");
		
		return "sample03/logview";
	}
}
