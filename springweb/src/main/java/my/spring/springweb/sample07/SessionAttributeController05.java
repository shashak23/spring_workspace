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
@SessionAttributes({ "data1", "kim" })
@RequestMapping(value = "/sessionAttributesTest05")
public class SessionAttributeController05 {

	Logger log = LogManager.getLogger("case3");
	
	// handler가 호출되기 이전에 아래의 메소드가 호출되요!
	// data1이라는 key로 메소드의 리턴값이 Model에 저장되요!
	@ModelAttribute("data1")
	public String createString1() {
		log.debug("createString1() 호출되었어요!");
		return "createString1";
	}

	@ModelAttribute("data2") // 모델객체 주입받기 
	public String createString2(Model model) {   // 맵핑이 잡힌 핸들러에서만 하는게 아니고 여기서도 가능해요 

		Student student = new Student(30,"신사임당","국어국문");
		model.addAttribute("kim", model);  // 모델객체가 해당 객체로 리턴이 됐을 떄 그때 이름이 kim이 있으면 session에 들어간다 ! 
		log.debug("createString2() 호출되었어요!"); // 모델말고 session에도 저장을 해주는 걸 해 보는 겁니다?
		
		return "createString2";
	}
	
	@PostMapping
	public String handler(@ModelAttribute("data1") String str1,
			@ModelAttribute("data2") String str2,
			@RequestParam(value = "msg") String requestMsg,
			@ModelAttribute("newStudent") Student studentVO,   // 인자에 붙어있는 경우가 있어요
			Model model) {						// 클라이언트가 보내주는 객체를 가지고 커멘드 객체를 만든다음에 모델에 저장하세요 였는데
				// 근데 그 key값이 여기서 오다가 보니까? 상단의 key로 되어있는거야~~ 이거 만들고 값을 만들기 이전에 --> 이게 안되니까 오류가 떠버려요!!  
				// 그러면 뭐를 하냐? -> session에서 값을 땡겨요! -> 이렇게 먼저 되버리는 거에요!
				// 세션에서 자동으로 땡기는 거에요 
			// 내가 저장한 학생 객체를 가져다가 쓰고 싶으면 컨트롤러 돌아다니면서 쓰고 싶은데~
			// 일단 어디선가는 이걸 넣어야해~ 근데 지금 넣는 부분이 없어요? 
		
		log.debug("handler()에서 출력 : " + str1 + ", " + str2);
		log.debug("msg : " + requestMsg);
		log.debug("student : " + studentVO);
		
		
		return "sample07/sessionResult05";
	}
}
