package com.jike.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jike.dao.UserInfoDao;
import com.jike.dao.PicInfoDao;
import com.jike.dao.RecordInfoDao;
import com.jike.entity.PicInfo;
import com.jike.entity.RecordInfo;
import com.jike.entity.UserInfo;

public class DaoTest {

	@Test
	public void testUserInfoDao() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-dao.xml");

		UserInfoDao userInfoDao = ac.getBean(UserInfoDao.class);

		UserInfo userInfo = userInfoDao.getById(1);
		System.out.println(userInfo);
		((ClassPathXmlApplicationContext) ac).close();
	}

	@Test
	public void testRecordInfoDao() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-dao.xml");

		RecordInfoDao recordInfoDao = ac.getBean(RecordInfoDao.class);
		RecordInfo byId = recordInfoDao.getById(1);
		System.out.println(byId);
		((ClassPathXmlApplicationContext) ac).close();
	}

	@Test
	public void testPicInfoDao() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-dao.xml");

		PicInfoDao picInfoDao = ac.getBean(PicInfoDao.class);
		PicInfo byId = picInfoDao.getById(1);
		System.out.println(byId);
		((ClassPathXmlApplicationContext) ac).close();
	}
}
