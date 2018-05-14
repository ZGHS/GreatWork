package com.jike.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jike.entity.PicInfo;
import com.jike.entity.RecordInfo;
import com.jike.entity.UserInfo;
import com.jike.service.PicInfoService;
import com.jike.service.RecordInfoService;
import com.jike.service.UserInfoService;

public class ServiceTest {
	@Test
	public void testUserInfoService() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-dao.xml", "applicationContext-service.xml" });
		UserInfoService bean = ac.getBean(UserInfoService.class);
		UserInfo byId = bean.register(new UserInfo());
		System.out.println(byId);
		((ClassPathXmlApplicationContext) ac).close();
	}

	@Test
	public void testRecordInfoService() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-dao.xml", "applicationContext-service.xml" });
		RecordInfoService bean = ac.getBean(RecordInfoService.class);
		RecordInfo byId = bean.saveRecord(new RecordInfo());
		System.out.println(byId);
		((ClassPathXmlApplicationContext) ac).close();
	}

	@Test
	public void testPicInfoService() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-dao.xml", "applicationContext-service.xml" });
		PicInfoService bean = ac.getBean(PicInfoService.class);
		List<PicInfo> byId = bean.getByRid(1);
		System.out.println(byId);
		((ClassPathXmlApplicationContext) ac).close();
	}
}
