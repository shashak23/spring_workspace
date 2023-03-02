package my.spring.springweb.sample01;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping(value="/123")
//public class TestController07 {
//	private static final Logger Logger =
//			LoggerFactory.getLogger(TestController07.class);
//	
//	@GetMapping
//	public String myMethod(Model model) { //내가 만든 모델이라는 객체를 랜더링해서 보낼거얌
//		
//		// model 객체가 주입되요(ApplicationContext에 의해서)
//		// modle은 map으로 되어 있고 (key,value)형태로 데이터를 저장함
//		Logger.debug("TestController07 호출됨!");
//		
//		model.addAttribute("myName", "김베리");
//		model.addAttribute("myAge", "20");
//		
//		// 결과로 전달한 jsp의 이름을 쓰기
//		return "TestController07";
//	}
//}
