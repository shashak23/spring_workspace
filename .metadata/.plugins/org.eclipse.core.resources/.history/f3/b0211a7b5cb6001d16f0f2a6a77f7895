package my.spring.springweb.sample01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

@Controller
@RequestMapping(value="testController06")  // HTML은 따로 설정이 없어도 결과가 보여지는데
public class TestController06 {
	
	private static final Logger Logger = 
			LoggerFactory.getLogger(TestController06.class);
	
	// 진짜로 bean이 생성되는지 확인하기
	public TestController06() {
		Logger.debug("TestController06 Bean 생성");
	}
	
	@GetMapping
	public ModelAndView showStaticView(Model model) {
		Logger.debug("testController06 호출");
		
		// InternalResourceView가 JSP할 때 많이 사용되는데, 뿐만아니라 정적 리소스할 떄도 사용됨
		// html의 경우, webapp하단부터 절대경로를 이용하면 편해요
		InternalResourceView view =  
				new InternalResourceView("/resources/sample01/testController06.html");
		
		ModelAndView mav = new ModelAndView(view);
//		ModelAndView mav = new ModelAndView(view, model); // 결과를 랜더링해서 최종결과를 전달함, 없으면 안 줘도 돼요
		//만약에 모델 객체가 있으면 괄호안에 넣어주면 되고
		// 근데 원래 모델앤드뷰객체는 작성법이 따로 있어요! 나중에 합시다 
		return mav; //같이 들어가 있는 형태를 리턴하기
	}
}
