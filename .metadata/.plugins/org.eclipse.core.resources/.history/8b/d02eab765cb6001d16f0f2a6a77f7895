package my.spring.springweb.sample01;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("testController05")
public class TestController05 {
	
	private static final Logger Logger = 
			LoggerFactory.getLogger(TestController05.class);
	
	@GetMapping(params="myName")
	String myMethod1() {
		Logger.debug("testController05 호출 - myName");
		return "TestController05";
	}
	
	@GetMapping(params="myName=김베리")
	String myMethod2() {
		Logger.debug("testController05 호출 - myName=김베리");
		return "TestController05";
	}
	
}
