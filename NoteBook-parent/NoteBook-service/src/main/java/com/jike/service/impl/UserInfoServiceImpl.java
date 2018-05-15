package com.jike.service.impl;

import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.sql.ast.statement.SQLIfStatement.Else;
import com.jike.dao.UserInfoMapper;
import com.jike.entity.UserInfo;
import com.jike.service.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	public UserInfoMapper userInfoDao;

	@Override
	public UserInfo login(UserInfo userInfo) {
		try{
			if (userInfo.getuPassword().equals(userInfoDao.selectByAccount(userInfo.getuAccount()).getuPassword())) {
				return userInfo;
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public UserInfo register(UserInfo userInfo) {
		if (userInfoDao.selectByAccount(userInfo.getuAccount()) == null) {
			userInfoDao.insert(userInfo);
			return userInfo;
		}
		return null;
	}

	@Override
	public UserInfo modifyProfile(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserInfoMapper getUserInfoDao() {
		return userInfoDao;
	}

	public void setUserInfoDao(UserInfoMapper userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

}
