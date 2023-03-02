package my.spring.springweb.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import my.spring.springweb.sample06.LottoService;
import my.spring.springweb.sample06.vo.Lotto;


@Controller
@SessionAttributes({"data1"})
@RequestMapping(value="/BusketController") 
public class BusketController {
	
	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private LottoService service;
	
	// 선택하면 과일들이 바구니에 담기도록
	@GetMapping(value="/lotto")  // vo 경로 설정
	public String lottoProcess(@ModelAttribute Lotto lotto) {
		boolean result = service.checkLottoNumber(lotto);  
		if(result) {
			lotto.setResult("당첨되었습니다! ");
		} else {
			lotto.setResult("될리가 없죠");
		}
		
		
		return "sample06/lottoView"; // 결과만 나오게 
	}
}
