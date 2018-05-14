package com.jike.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WebTest {

	@Test
	public void testUserInfoController() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-dao.xml", "applicationContext-service.xml" });
		((ClassPathXmlApplicationContext) ac).close();
	}

}
