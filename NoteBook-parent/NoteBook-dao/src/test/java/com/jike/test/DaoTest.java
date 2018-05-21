package com.jike.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jike.dao.UserInfoMapper;
import com.jike.dao.PicInfoMapper;
import com.jike.dao.RecordInfoMapper;
import com.jike.entity.PicInfo;
import com.jike.entity.RecordInfo;
import com.jike.entity.UserInfo;

public class DaoTest {

	@Test
	public void testUserInfoDao() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-dao.xml");

		UserInfoMapper userInfoDao = ac.getBean(UserInfoMapper.class);

		UserInfo userInfo = userInfoDao.selectByPrimaryKey(1);
		System.out.println(userInfo);
		((ClassPathXmlApplicationContext) ac).close();
	}

	@Test
	public void testRecordInfoDao() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-dao.xml");

		RecordInfoMapper recordInfoDao = ac.getBean(RecordInfoMapper.class);
		RecordInfo byId = recordInfoDao.selectByPrimaryKey(1);
		System.out.println(byId);
		((ClassPathXmlApplicationContext) ac).close();
	}

	@Test
	public void testPicInfoDao() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-dao.xml");

		PicInfoMapper picInfoDao = ac.getBean(PicInfoMapper.class);
		PicInfo byId = picInfoDao.selectByPrimaryKey(1);
		System.out.println(byId);
		((ClassPathXmlApplicationContext) ac).close();
	}
}
