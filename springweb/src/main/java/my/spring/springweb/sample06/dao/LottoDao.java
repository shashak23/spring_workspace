package my.spring.springweb.sample06.dao;

import java.util.Random;

import org.springframework.stereotype.Repository;

@Repository("lottoDao")
public class LottoDao {
	
	public LottoDao () {
		
	}
	
	public int selectLottoNumber() {
		
		Random rand = new Random();
		return rand.nextInt(6) + 1;   // 0~5까지 난수를 발생
	}
	
}
