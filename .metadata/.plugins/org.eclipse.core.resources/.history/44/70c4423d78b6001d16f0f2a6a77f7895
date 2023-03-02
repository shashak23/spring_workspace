package my.spring.springweb.sample04;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathController {
	//변수를 지정할 수 있음 뭐가 들어오던 간데 PathController 가 Handler를 해서 잡을것이다!
	@RequestMapping(value = "/character/datail/{name}/{number}") // 변수 부분 : {name}{number}
							// 경로에 대한 변수명과 타입과 값을 함께 써주기 
	public String myMethod(@PathVariable("name") String name,
			@PathVariable("number") int num, Model model) {
		
		if(name.equals("kakao")) {
			if(num == 1) {
				model.addAttribute("imgname","ryan"); // 스트링이 imgname이라는 key로 간다
			} else if(num == 2) {
				model.addAttribute("imgname","apeach");  // img name이라는 key에 들어가는 데이터가 달라지니까
			} else if(num == 3) {
				model.addAttribute("imgname","frodoneo");
			}
		}
		
		if(name.equals("line")) {
			if(num == 1) {
				model.addAttribute("imgname","brown"); 
			} else if(num == 2) {
				model.addAttribute("imgname","james");
			} else if(num == 3) {
				model.addAttribute("imgname","cony");
			}
		}
		
		return "/sample04/detailView";
	}
}
