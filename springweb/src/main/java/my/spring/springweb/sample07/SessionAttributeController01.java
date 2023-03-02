package my.spring.springweb.sample07;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import my.spring.springweb.sample07.vo.Student;

@Controller
@SessionAttributes({"data1"})
//(value= {"a","b","c"}) 에서 value가 생략되어서 쓰임, 이렇게 기본으로 쓰여요
@RequestMapping(value="/sessionAttributesTest01")  // 어떤 url로 갈 지 정하겠쥬? 
public class SessionAttributeController01 {
	
	
	Logger log = LogManager.getLogger("case3");
	
	
	// 핸들러가 호출되기 이전에 아래의 메소드가 호출되요 
	// 내가 명시적으로 호출한 적이 없지만 핸들러보다 먼저 호출이 된다는 말
	// data1이란 key로 method의 리턴값이 model에 저장이 되요
	// 문자열이 자동으로 model에 저장이 될거에요 
	@ModelAttribute("data1")  // 메소드에 지정함, 명시하기
	public String createString1() {
		log.debug("createString1() 호출되었어요! ");
		return "createString1";  // 문자열이 저장이 됨 --> 이거를 세션에도 저장을 해주겠어 
	}
	
	@ModelAttribute("data2") 
	public String createString2() {
		log.debug("createString2() 호출되었어요! ");
		return "createString2";
	}
	
	// post 방식으로 넘어와서  // 01 핸들러 만들기 
	@PostMapping
	public String Handler(@ModelAttribute("datat1") String str1, 
			@ModelAttribute("datat2") String str2,  // 클라이언트가 나한테 전달해주는 정보가 msg 라는 거라서! 3번째 부터는 다르게! 
			@RequestParam(value="msg") String requestMsg,  // 4번째부터는 커멘드 객체로 받을거라서 다르게!, newStudent라는 key값으로 모델에 저장이 됨
			@ModelAttribute("newStudent") Student studentVO,
			Model model) {   
		
		log.debug("handler()에서 출력 : " + str1 + "," + str2);
		log.debug("msg :" + requestMsg);
		log.debug("student :" + studentVO);
		
//		model.addAllAttribute("myKey", "호호호");  
		// 이 값이 맨 위의 @SessionAttributes({"a","b","c"})여기에 나올 수도 있고
		// 여기게아닥 명시를 해줄 수도 있어요 
		
		return "sample07/sessionResult01";
	}
}
