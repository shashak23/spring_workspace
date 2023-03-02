package my.spring.springweb.sample07;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import my.spring.springweb.sample07.vo.Member;

@Controller		// 모델이 "" 이름으로 저장되면 세션에도 같이 저장이 되겠따는 뜻! 
@SessionAttributes(value= {"memberInfo"})  //세션에 저장을 하기 위해 벨류 만들기 , 사용자 정보 - 멤버 vo , 내가 저  key로 저장하겠다는 뜻
public class memberRegisterController {
	
	
	Logger log = LogManager.getLogger("case3");
	
	// 처음에 세션에 키를 만들어주는 역할
	@ModelAttribute("memberInfo")  // 이렇게 해야 세션이 올라가요 
	public Member createMember() { // log를 이용해서 어떻게 수행되는지 확인해봅시다 
		
		log.debug("createMember가 호출되었어요");
		
		Member member = new Member();
		return member;
	}
	@PostMapping(value="memberRegisterStep1")
	public String handler1 () {
		log.debug("handler1  호출 - 회원가입 첫 페이지 ");
		
		return "sample07/step1"; // step1이라는 jsp가 나오겠죠 ?
	} // 여기서 받은 정보를 쟁여둬야해요 -> model에는 안돼요 -> jsp가 닫으면 model에 닫아져요 -> 그래서 상대적으로 살아있느 시간이 긴 session에 저장함
	
	
	
	@PostMapping(value="memberRegisterStep2")				// member의 7번 member로 잡으세요 
	public String handler2 (@ModelAttribute("memberInfo") Member member) { 
		log.debug("handler2  호출 - 회원가입 두번째 페이지 ");  // 두번째 페이지로 이동 버튼을 누르면 여기로 오고 제대로 되는지 찍어보쟈!
							// 핸들러 호출을 하고 나면 두번째는 또 안돼? -> 세션이 초기화가 되지 않아요! 
							// 이게 맨처음에 에러를 방지하기 위해서 했는데 안돼는 군요? -> 근데 처음부터 다시 시도를 하니까? 또 됐어요?
							// 호출이 되느냐 안되느냐는 세션에 객체존재 여부가 중요한데 -> 객체가 이미 있다면 호출이 안되는 거고 ! 
							// -> 객체가 없어야 초기화가 되는 거고 호출이 되는거!
		log.debug(member);  //세션안에 있는 빈 객체를 불러와서 값3개를 불러다 적은 데이터가 나오겠쬬?
		
		return "sample07/step2";
	}
	
//	@PostMapping(value="memberRegisterStep3")
//	public String handler3 (@ModelAttribute("memberInfo") Member member,
//				SessionStatus sessionStatus) {
//		log.debug("handler3  호출 - 회원가입 첫 페이지 ");
//		log.debug(member);
//		
//		// @Service와 @Repository 를 이용해서 처리함
//		
//		
//		sessionStatus.setComplete(); // 세션에서 key를 제거하는 것
//		
//		return "redirect:memberRegiterStep1"; //근데 redirect는 GET방식이에요 
//	}
	// 저장버튼을 누르면 나오는 곳 서비스를 호출해서 서비스는 또 dao호출해서 세션에 담겨 있는 데이터를 넣고 
	// 넣는게 완료되면 쵝화 화면으로 보내면 
	@PostMapping(value="memberRegisterStep3")
	public String handler3 () {
		log.debug("handler3  호출 - 회원가입 완료 페이지 ");
//		log.debug(member);
		// @Service와 @Repository 를 이용해서 처리함
//		sessionStatus.setComplete(); // 세션에서 key를 제거하는 것
		
		return "sample07/step3";
	}
}
