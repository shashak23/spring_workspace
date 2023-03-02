package my.spring.springweb.sample06;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import my.spring.springweb.sample06.dao.LottoDao;
import my.spring.springweb.sample06.vo.Lotto;

@Service
public class LottoService {   // scope를 안주면 기본적으로 
	
//	@Autowired
//	@Resource(name="lottoDao")  // 직접적으로 주입을 하도로고 class 이름 명시해주기
//	또는
	Logger log = LogManager.getLogger("case3");
	@Autowired
	@Qualifier(value="lottoDao")  // 이렇게 해서 주입해도 돼요 
	private LottoDao dao;  // dao생성하고 baen으로 주입하기 
	
	public LottoService() {
		
	}
	
	public boolean checkLottoNumber (Lotto lotto) {
		// 일반적인 로직 처리를 진행할거에요 
		// 그러고 나서 db처리를 하겠죠  - dao가 필요해요 -> dao 생성
		// 불리언 결과가 됐는지 확인하기 
		boolean result = false;  // 당첨 여부 , 초기값!! 설정을 해주는 거고 ! 
		int randomNumber = dao.selectLottoNumber();  // dao를 이용해서 당첨 번호를 알아오는 것 오토와이어로 받아온 거고 
		// 만약 랜덤으로 선택된 번호가 내가 선택한 번호와 같다면
		log.debug("내가 선택한 로또 번호:" + lotto.getLottoNum());
		log.debug("로또 당첨 번호:" + randomNumber);  // 위에는 변수인데 여기서는 함수로 쓰여서 괄호가 없어요 
		
		if (randomNumber == lotto.getLottoNum()) {
			result = true;  // 진실이다
		}
		return result;
	}

}
