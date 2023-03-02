package my.spring.springweb.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware {
	
	private static ApplicationContext ctx; // 자동 호출됨 내부에서 쓰는 용도
	
	public static ApplicationContext getApplicationContext() {  // 외부에서 쓸 수 있게 하는 용도
		return ctx;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.ctx=applicationContext;  // 일반 메소드라서 this를 써도 되요. 내부에서 쓰는 용도
	}
}
