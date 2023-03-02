package my.spring.springweb.sample07;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import my.spring.springweb.sample07.vo.Student;

// session 활용 방법 2가지 


@Controller
@SessionAttributes({"data1"})
@RequestMapping(value="/sessionAttributesTest02")  
public class SessionAttributeController02 {
	
	
	Logger log = LogManager.getLogger("case3");
	
	@ModelAttribute("data1") 
	public String createString1() {
		log.debug("createString1() 호출되었어요! ");
		return "createString1"; 
	}
	
	@ModelAttribute("data2") 
	public String createString2(HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		// true 이면 ? 
		
		// vo student 만들기
		Student student = new Student(36, "김베리", "철학과");
		session.setAttribute("kim", student);  // kim 이라는 key를 생성 -> jsp 02에 적용 
		
		log.debug("createString2() 호출되었어요! ");
		return "createString2";
	}
	
	@PostMapping
	public String Handler(@ModelAttribute("datat1") String str1, 
			@ModelAttribute("datat2") String str2, 
			@RequestParam(value="msg") String requestMsg,  
			@ModelAttribute("newStudent") Student studentVO,
			Model model) {   
		
		log.debug("handler()에서 출력 : " + str1 + "," + str2);
		log.debug("msg :" + requestMsg);
		log.debug("student :" + studentVO);

		return "sample07/sessionResult02";
	}
}
