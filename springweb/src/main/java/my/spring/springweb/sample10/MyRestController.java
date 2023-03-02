package my.spring.springweb.sample10;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/rest/user")
public class MyRestController {
	
	Logger log = LogManager.getLogger("case3");
	
	// GET방식 호출이 되느지 확인을 위한 간단한 컨트롤러
	@GetMapping
	public ResponseEntity<?> method01(String id, String name){ // ajax에서 정한것
		log.debug("get방식으로 호출이 되었어요");
		log.debug(id +","+ name);
		
		return null;
	}
	
	// DELETE방식 호출이 되느지 확인을 위한 간단한 컨트롤러
	@DeleteMapping
	public ResponseEntity<?> method02(String id, String name){
		log.debug("delete방식으로 호출이 되었어요");
		log.debug(id +","+ name);

		
		return null;
	}
}
