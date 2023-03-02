package my.spring.springweb.sample01;


// 일반적으로 @ReuqestMapping을 class level에서 사용해요
//
//@Controller
//@RequestMapping(value="/testController04")  // 이 "url"로 들어온 거에따라 get방식으로 아래와 같이 하겠따
//public class TestController04 {
//	private static final Logger Logger =
//			LoggerFactory.getLogger(TestController04.class);
//	
//	@GetMapping("123")
//	String MyMethod01() {
//		Logger.debug("testController04 - GET 호출됐어요");
//		return "testController04";
//	}
//	
//	@GetMapping  // ?myName
//	String MyMethod02() {  // 이게 무슨 말씀인지 다시 듣고 싶은데.....
//		Logger.debug("testController04 - GET 호출됐어요");
//		return "testController04";
//	}
//	@PostMapping
//	String MyMethod03() {  // 이게 무슨 말씀인지 다시 듣고 싶은데.....
//		Logger.debug("testController04 - GET 호출됐어요");
//		return "testController04";
//	}
//}
