package my.spring.springweb.sample01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// client request method에 따른 handler 호출
// method=requestmethod.GET

@Controller
@RequestMapping(value="/testController03")
public class TestController03 {

		private static final Logger Logger = 
				LoggerFactory.getLogger(TestController03.class);
		
		@RequestMapping(value="", method = RequestMethod.GET)  // method를 안적으면 무조건 GET, requestmethod 상수 적기
		String myMethod1() {
			
			return null; 
		}
		
		@RequestMapping(value="1234", method = RequestMethod.GET)  
		String myMethod2() {
			
			return null; 
		}
		
		@RequestMapping(value="123", method = RequestMethod.GET)  
		String myMethod3() {
			
			return null; 
		}
}
