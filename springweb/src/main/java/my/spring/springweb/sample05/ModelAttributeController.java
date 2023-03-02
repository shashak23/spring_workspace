package my.spring.springweb.sample05;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelAttributeController {
	
	Logger log = LogManager.getLogger("case3");

	@ModelAttribute("v1")   
	// 메소드 위에 이걸 줄떄에는 annotation에 이름을 줘야해요! 
	// -> why? 이 메소드는 핸들러는 호출되기 이전에 먼저 호출되는 메소드여서!
	// -> 그리고 해당 메소드의 리턴값이 어디에 저장되냐면 모델에 자동으로 저장이 돼요 
	public String createString() {  //일반 메소드  --> 얘가 결과적으로는 jsp에 있는 문자열이 나온다!
	
		log.debug("문자열 객체 생성");
		return "고양이는 냐옹냐옹";
	} // v1이라는 key 값으로 return값이 나오고 여기는 먼저 호출되는 곳이고 
	
	@ModelAttribute("v2")
	public User createUser() {
	
		log.debug("VO 객체 생성");
		User user = new User(25, "김베리", "컴공과");
		return user;
	} // 근데 또 이게 순서개념은 없어요
	
	@ModelAttribute("data1")
	public int createNumber1() {
	
		log.debug("첫 번째 숫자 생성");
		return 100;
	}
	

	@ModelAttribute("data2")
	public int createNumber2() {
	
		log.debug("두 번째 숫자 생성");
		return 200;
	}
	
	//핸들러 만들기 --> 클라이언트가 보내는 resource를 실제 request에 넣는 걸 핸들러라고 해요 ?!! --> 찾아보기 
	@RequestMapping(value="modelAttributes1") // 위에 있는 data1을 댕겨서 받아보기 
	public String myMethod1(@ModelAttribute("data1") int num1,  
			// model attribute로 결정된 key들을 model에 받아서 사용할 수 있음
			@ModelAttribute("data2") int num2, Model model ) { 
			// num1과 num2는 모델어트리뷰트 붙으면 vo를 만드는 건줄 알았느데 뿐만아니라 모델어트리뷰트에서 나온 결과를 댕겨서 쓸 수도 있따 
		
		model.addAttribute("sum", num1 + num2);  // jsp에서 합에 넣을 값인데 key를 따라가면 됨 
		
		log.debug("handler 11 호출");
		return "sample05/modelResult";
	}
	
	@PostMapping(value="modelAttributes2")
	// return type만 조심하면 돼요 
	public String myMethod2(@ModelAttribute User user) { 
		// 이렇게 클라이언트가 보내준 데이터로 객체를 생성할 수 있어요
		// command객체라고 불러요 
		
		// 이게 사실 순서가 있는데 --> 순서대로 하지 않으면 순서가 뒤바껴서 나오기 때문에 
		// 1. 만약 sessionAttribute가 지정되어 있으면 -- 세션의 속성으로 붙이는 거에요 -- 클라이언트마다 하나씩 할당되는 세션 !  
		// 서브릿할 떄에는 수동으로 코드를 얻어왔는데 --> 그거를 자동화시켜서 사용할 수 있는거에요 
		// 2. User의 생성자를 찾아 호출해서 객체를 생성해쇼
		// public 생성자를 찾아요
		// 만약 여러개면 그 중 인자가 가장 적은 생성자를 찾아요 -> 일반적으로 default 생성자가 선택 
		// 그러고 생성자를 이용해서 객체를 빵! 하고 만든 다음에 
		// 3. 어떤 생성자를 사용하건 상관이 없지만, 여기서는 Setter를 이용해서 클라이언트가 보내준 데이터를 vo에 저장해요
		// setter와 getter를 인식하고 있지만 이거는 메소드의 이름 형태를 지칭하는 거라서
		// 그 안에 들어가는 코드는 내가 나름대로 정리할 수 있어요 ^^ 
		// 4. @ModelAttribute 이거는 실제로 model이 존재하지 않지만
		// 지금 만든 이 user command 객체를 기본적으로 앞글자 소문자로 변형해서 Model에 저장해요 :) 
		// 만약 내가 이름을 달리해서 저장하고 싶으면 @ModelAttribute("다른이름") 이렇게 지정을 해주면 돼요 
		// 프로그램은 결국 annotation을 간소화해서 어떻게 다루느냐의 문제여서 이걸 잘 이해해야해요 
		
		
		// 필드명과 html이 똑같아야해요 
		log.debug("handler 22 호출");
		return "sample05/testController08.html";
		
	}
}
