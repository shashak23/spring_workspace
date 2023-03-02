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
@SessionAttributes({ "data1", "kim" , "newStudent"}) // 근데 newStudent를 저장하는 곳이 없으니까 
@RequestMapping(value = "/sessionAttributesTest04")
public class SessionAttributeController04 {

	Logger log = LogManager.getLogger("case3");
	

	@ModelAttribute("data1")
	public String createString1() {
		log.debug("createString1() 호출되었어요!");
		return "createString1"; // 이 스트링이 모델에도 저장되고 세션에도 저장이 되는구나 
	}

	@ModelAttribute("data2") // 이거는 모델에만 저장이 될거고 
	public String createString2(Model model) {  

		Student student = new Student(30,"신사임당","국어국문");
		model.addAttribute("kim", model);  
		log.debug("createString2() 호출되었어요!"); // kim이라는 key가 모델에도 저장이 되고 위에 이름이 있으니까 세션에도 저장이 되겠구나 
		
		return "createString2";
	}
	
	@PostMapping
	public String handler(@ModelAttribute("data1") String str1,
			@ModelAttribute("data2") String str2,
			@RequestParam(value = "msg") String requestMsg,
			@ModelAttribute("newStudent") Student studentVO) { // 이렇게 진행을 시키고 5번으러 긔긔
		
		log.debug("handler()에서 출력 : " + str1 + ", " + str2);
		log.debug("msg : " + requestMsg);
		log.debug("student : " + studentVO);
		
		
		return "sample07/sessionResult04";
	}
}
