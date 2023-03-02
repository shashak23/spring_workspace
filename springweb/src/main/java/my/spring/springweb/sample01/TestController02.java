package my.spring.springweb.sample01;

//
//@Controller
//@RequestMapping("/testController02")  // 우리 스프링 위에 02로 시작한다고 정해주면 info -> return 02 , profile -> return 02가 나옴
//public class TestController02 {
//
//	private static final Logger Logger = 
//			LoggerFactory.getLogger(TestController01.class);
//	
//
//	//핸들러 역할을 함
//	//requestmapping을 다양하게 쓸 수 있는데 이에 대한 확장버전!
//	//method 잡기
//	@RequestMapping("/testController02/info")
//	String myMethod01() {
//		Logger.debug("testController02/info 호출!");
//		return "TestController02";
//		// servlet 자체가 class 일 때에는 method만 구별해서 dopost 외에 필요에 따라 설정 
//		// 똑같이 할 수 있어요 
//	}
//	
//	@RequestMapping("/profile") 
//	String myMethod02() {
//		Logger.debug("testController02/profile 호출!");
//		return "TestController02";
//	}
//	
//	// 꼭 특정 url에 하나씩 매핑을 해야하나요?
//	// 여러개의 url을 하나의 핸드러로 할 수가 있어요 
//	@RequestMapping(value= {"","/test01","test03/*"})  // --> test03/*밑에 나오는 거 다 함
//	String myMethod03() {
//		Logger.debug("testController02/멀티호출!");
//		return "TestController02";
//	}
	
//}
