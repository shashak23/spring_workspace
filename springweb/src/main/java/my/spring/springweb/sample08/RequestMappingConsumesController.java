package my.spring.springweb.sample08;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestMappingConsumesController {
	
	Logger log = LogManager.getLogger("case3");
	
	@RequestMapping(value="/testController1",
					method=RequestMethod.GET, // get방식으로 호출할 이름과 방식 적어주기
					consumes = {"application/json", "application/xml"}) 
					// 특정 데이터 형식을 명시해주는 방법
					// 근데 그 헤더가 저걸로 잡혀 있어야지 처리할거에요 -> 조건을 명시 
	public String myMethod1() {
		
		log.debug("GET방식으로 호출되었어요");
		
		return null;
	}
	
	@RequestMapping(value="/testController2",
					method=RequestMethod.POST, // POST방식으로 호출할 이름과 방식 적어주기
					// post방식을 지원해주는 형식을 정확하게 기입해야 한다 - 정해진 문자열
					consumes = {"application/json","applcation/x-www-form-urlencoded"}) 
		public String myMethod2() {
		
		log.debug("post방식으로 호출되었어요");
		
		return null;
		}
    }

