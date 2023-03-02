package my.spring.springweb.sample01;


import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import my.spring.springweb.sample01.vo.User;

@Controller
@RequestMapping(value="testController08")
public class TestController08 {

//	private static final Logger Logger =
//			LoggerFactory.getLogger(TestController08.class);
//	
	@PostMapping("userEL")
	public String myMethod(Model model) {
		
		model.addAttribute("myName", "김베리");
		model.addAttribute("myAge", 32);
		
		List<String> list = new ArrayList<String>();
		list.add("김토리");
		list.add("김까미");
		
		model.addAttribute("myList", list);
		
		User user = new User("김시하", 30);
		model.addAttribute("myUser", user);
		
		
		
		return "TestController08";
	}
	
}
