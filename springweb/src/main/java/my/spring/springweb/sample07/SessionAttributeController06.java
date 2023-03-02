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
@SessionAttributes({ "data1", "kim" , "newStudent"})
@RequestMapping(value = "/sessionAttributesTest06")
public class SessionAttributeController06 {

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

		Student student = new Student(20,"김베리","철학과");
		model.addAttribute("kim", student);  // 모델객체가 해당 객체로 리턴이 됐을 떄 그때 이름이 kim이 있으면 session에 들어간다 ! 
		log.debug("createString2() 호출되었어요!"); // 모델말고 session에도 저장을 해주는 걸 해 보는 겁니다?
		
		return "createString2";
	}
	

	@ModelAttribute("newStudent") // 모델객체 주입받기 
	public Student createString3(Model model) {   // 맵핑이 잡힌 핸들러에서만 하는게 아니고 여기서도 가능해요 

		Student student = new Student();   // 빈객체로 리턴을 하는 거에요! -> 결과적으로 setter만 호출이 됩니다?
		
		return student; // 메소드는 리턴을 Student로 타입을 정해야한다 ! 
	}
	// 순서
	// 1. @Controller 의 @SessionAttributes({ "data1", "kim" , "newStudent"}) 이렇게 있는데
	// 그러고 핸들러의 인자를 봤더니 key값이 인식을 잘못해서 역할이 바뀌어요 
	// (원래는 모델 어트리뷰트가 커멘드 객체를 받아요!) 그랬는데 지금 key값을 잘못인시글 해서 커멘듣 객체를 잡기 이전에 다른 일을 해버리는데
	// key값에 가서 인자를 먼저 받는 다른 일을 하게 돼요 !  그래서 ! 
	// 2. @ModelAttribute("newStudent") Student student 가 오류가 안나려면 세션에 key값이 있어야 해요 근데 그게 처음에 들어오면 없어요 (05)
	// 요골로 되어 있는 key값의 객체를 찾아서 인자로 주입을 하는 겁니다? 
	
	// 이 코드가 오류가 안날려면 당연히 session에 newStudent 키 값으로 저장되어 있는 객체가 있어야해요
	// -> newStudent가 session에 존재해야 해요 -> 저게 존재하지 않기때문에 오류가 발생하는 겁니다 
	
	// 이 문제를 해결하기 위해서 처음들어오면 당연히 session에 해당 key값이 존재하지 않지요?
	// 코드 오류를 피하려면 우리가 했었던 @ModelAttribute이거를 method위에 붙이고 return으로 빈 commond를 생성해서 
	// model에 저장해야해요! 당연히 session에 저장될거고 session에 바로 들어간다
	// 그 다음에 핸들러가 호출되기때문에 오류를 피할수가 있어진다 
	
	// 핸들러는 command객체를 생성하지 않겠꼬 그러고 클라이언트가 보내준 데이터를 이용해서 setter를 이요해서 command 객체에 데이터를 삽입해요
	
	
	// 500 오류 문제를 해결해봅시다 
	@PostMapping
	public String handler(@ModelAttribute("data1") String str1,
			@ModelAttribute("data2") String str2,
			@RequestParam(value = "msg") String requestMsg,
			@ModelAttribute("newStudent") Student studentVO,  // 이 KEY값을 VO로 가져가서 하는게 이 친구의 일
			Model model) { 		// 핸들러 보다 모델이 먼저 실행되니까 새로 만들어주면 해결이 될거에요!
		
		log.debug("handler()에서 출력 : " + str1 + ", " + str2);
		log.debug("msg : " + requestMsg);
		log.debug("student : " + studentVO);
		
		return "sample07/sessionResult06";
	}
}
