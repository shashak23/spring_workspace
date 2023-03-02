package my.spring.springweb.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

// 수동으로 bean을 application context에 등록하려면
// @Bean을 사용해야 해요
// Configuration은 Component 기능을 갖고 있어서
// 수동bean을 만들려고 하는 거구나를 파악하게 되고 

@Configuration
public class LibraryComponent {
	
	@Bean  // gson 객체를 정하고 이렇게 수동으로 bean을 적어줌 
	public Gson getGson() {

		return new Gson();  // gson객체가 잡히도록 함
	}
}
