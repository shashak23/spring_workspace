package my.spring.springweb.sample02;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JSTLExampleController {
	// 핸들러 메소드 만들고 리ㅂ퀘스으 맵핑으로 연결을 해주기 
	
	@RequestMapping(value = "/jstlExample")
	public String myMethod(Model model) {
		// 모델객체 이용하기 
		List<String> list = new ArrayList<String>();
		// 안에ㅓ 데이터 추가
		list.add("김베리");
		list.add("김모모");
		list.add("김까미");
		// 모델에 addAttribute 사용하기 - 모델에 주입된 객체를 넣기 위해서
		model.addAttribute("myNum", 100);
		model.addAttribute("myList", list);
		// 이제 jsp 만들기 해요!
		
		// 나중에 jsp하면 url을 갖고 jsp를 찾는데
		// void를 쓰면 그냥 저렇게 쓰면 안되구 /sample02/jstlExample 이렇게 써야해요
		// String을 써서 return을  받는 곳을 경로를 정하기
		
		return "sample02/jstlExample";
		
		
	}
}
