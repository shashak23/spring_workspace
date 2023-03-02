//package my.spring.springweb.sample02;
//
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import my.spring.springweb.sample01.TestController07;
//
//@Controller
//public class MemberController {
//	@PostMapping(value = "member1")
//	// requestparam을 주고 뒤에는 어떤 이름으로 넘어갈건지 받을건지를 명시를 해야함
//	// html에 있는 name으로 들어오는 것을 받을거란 걸 쓰기 
//	// 이 값이 안들어 올 수 도 있으니까 -- default메뉴를 설정해둬야해요 
//	public ModelAndView myMethod1(
//			// 굳이 바꿀 필요가 없으면 name, name을 쓰기도 해요
//			@RequestParam(value="name", defaultValue="없음") String name,
//			@RequestParam(value="phone", defaultValue="없음") String phone,
//			// 넘어오는 key 와 value가 이름이 같으면 생략할 수 있따! 
////			@RequestParam(value="id", defaultValue="없음") String id,
//			String id,
//			@RequestParam(value="pw", defaultValue="없음") String pw,
//			// 모델 주입받기  -> mav가 아니고 model에 주입받는 거로 하기 
//			Model model			) {
//		//모델 객체 대신에 모델엔뷰 객체를 사용하기 
//		ModelAndView mav = new ModelAndView();
//		// 내가 원하는 객체 붙이기
//		// 모델엔뷰 객체 만들어서 내가 에드오브젝트하면 request객체로 전달돼요?
////		mav.addObject("name", name);
////		mav.addObject("phone", phone);
////		mav.addObject("id", id);
////		mav.addObject("pw", pw);
////		
////		mav.setViewName("/memberView");   // jsp 이름을 여기에다가 쓰기 
//		// view객체를 만드는데 이 때 directive가 veiw를 찾자고 하면 
//		// string return을 안하는 이유는   모델을 안쓰는 이유는 이거 하나로 다 할수가 잆어요! 
//		
//		model.addAttribute("name", name);
//		model.addAttribute("phone", phone);
//		model.addAttribute("id", id);
//		model.addAttribute("pw", pw);
//		
//		mav.setViewName("/memberView");
//		
//		return mav;
//	}
//	
//
//		private static final Logger Logger =
//				LoggerFactory.getLogger(TestController07.class);
//		
//	@PostMapping(value = "member2")
//	//결론적으로는 멤버라는 객체를 만들고 
//	public ModelAndView myMethod2(Member vo) { // 여기에는 @ModelAttribute 가 생략되어 있어요 -> 얘를 이용하면 vo를 받을 수 있어요!
//		// 그러면 얘도 생략할 수 있고 쟤도 생략할 수 있어요? 다 생략되면 model이나 vo인지 어떻게 알아요?
//		// primitive type계열은??? 아 이거 그래서 구분을 어ㄸ
//		
//		Logger.debug(vo.toString()); // 확인하면 정말로 클라이언트가 보내준 데이터가 vo로 생성되는지 확인이 가능
//		
//		ModelAndView mav = new ModelAndView();
//		
//		mav.addObject("memberVO", vo);
//		// 모델엔뷰 만든거를 (경로)로 보내주기 
//		mav.setViewName("/memberView");   
//		// jsp가서 적절하게 변경하자!
//		return mav;
//		
////		return null;
//	}
//	
//	
//	@PostMapping(value = "member3")
//	//모델앤뷰 객체말고 string을 return할거에요
////	public String myMethod3(@ModelAttribute Member vo) { 
//	
//	// mem 형태로 받을건지 적어주는 거에요! 프리미타입은  / 모델어트리뷰트는 리퍼런스타입 ? --> 찾아보기 
//	public String myMethod3(@ModelAttribute(value="mem")Member vo) {
//		// 모델의 어트리뷰트를 사용하겠다고 했으니까 만들어진 객체를 모델이 자동으로 들어가게 됨
//		// 구러면 KEY로는 물써야하나요 ->  대부분 클래스명을 쓰는데 앞글자는 소문자로해서 밀어넣기 
//		// 데이터 세팅을 안하고 바로 밀어넣었어! -> 진짜 들어왔는지? 어떤 키로? member
//		// 어디서 확인하냐? memberView 의 설정해준 key! (아니면 memberVO -> member로 변경하기) 
//		
//		Logger.debug(vo.toString());
//
//		return "memberView";
//		
//
//	}
//	
//	@PostMapping(value = "member4")  // address가 추가 됨
//	public String myMethod3(Member vo, String address) {
//		
//		Logger.debug(vo.toString());
//
//		return "memberView";
//		
//
//	}
//	
//}
