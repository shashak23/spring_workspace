//package my.spring.springweb.sample02;
//
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import my.spring.springweb.sample01.TestController08;
//
//@Controller
//@RequestMapping(value="cal.do")
//public class CalController {
//
//	private static final Logger logger = 
//			LoggerFactory.getLogger(TestController08.class);
//	
//	@PostMapping
//	public ModelAndView process(int firstNum, int secondNum, String operator) {
//		
//		ModelAndView mav = new ModelAndView();
//		String viewName = "";
//		
//		if (operator.equals("div") && secondNum == 0) {
//			viewName = "sample02/errorResult";
//			mav.addObject("msg", "나눗셈은 0으로 나눌 수 없습니다.");
//		} else {
//			int result = 0;
//			if (operator.equals("plus")) {
//				result = firstNum + secondNum;
//			} else if(operator.equals("minus")) {
//				result = firstNum - secondNum;
//			} else if(operator.equals("mul")) {
//				result = firstNum * secondNum;
//			} else {
//				result = firstNum / secondNum;
//			}
//			viewName = "calController";
//			mav.addObject("msg", result);
//		}
//		
//		mav.setViewName(viewName);
//		return mav;
//	}
//}