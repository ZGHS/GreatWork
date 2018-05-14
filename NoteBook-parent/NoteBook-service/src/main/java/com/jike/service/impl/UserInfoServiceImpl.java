package com.jike.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jike.dao.UserInfoDao;
import com.jike.entity.UserInfo;
import com.jike.service.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	public UserInfoDao userInfoDao;

	@Override
	public UserInfo login(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo register(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo modifyProfile(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}

	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

}
