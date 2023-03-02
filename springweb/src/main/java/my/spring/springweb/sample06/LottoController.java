package my.spring.springweb.sample06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import my.spring.springweb.sample06.vo.Lotto;

@Controller
public class LottoController {
	
	@Autowired
	private LottoService service;
	
	
	// 얘는 핸들러에요 
	@GetMapping(value="/lotto")  // vo 경로 설정
	public String lottoProcess(@ModelAttribute Lotto lotto) {
		
		
//		 service 객체를 만들어서 로직을 처리해야 해요 -> service 만들기 ㅋㅋㅋㅋㅋㅋ
//		LottoService service = new LottoService(); // @Autowired를 쓰면 이거 안써도 돼요 !!!! 
		boolean result = service.checkLottoNumber(lotto);  // 이게 문제가 1명이며 상관이 없는데 여러명이 들어오면 1명당 1개의 서비스 객체가 생기는데
		// 객체가 가지는 메소드를 호출하는 게 문제인대 -> 서비스 객체는 stateless는 결국 하나를 만들어놓고 공유하는 게 훨씬 효율적이다 ! 
		// 이거 bean으로 등록해서 편하게 써보자~~! -> service를 bean으로 등록하려면 어ㄸ헥 해얗애?
		// 클래스 위에 어노테이션 붙이기 -> 1. component 를 붙이면 헷갈릴 수 있으니까!     2.service를 붙이기 
		
		// 이거를 이제 받을 방법을 생각해야해요 param으로 받을수도 있고 
		// 근데 pathvariable이 안되는 건 쿼리스트링으로 이미 html에서 줬기때문에!
		// 그래서 정한 것이 model! 
		
		if(result) {
			lotto.setResult("당첨되었습니다! ");
		} else {
			lotto.setResult("될리가 없죠");
		}
		
		
		return "sample06/lottoView"; // 결과만 나오게 
	}
}
